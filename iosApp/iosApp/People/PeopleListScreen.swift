//
//  PeopleList.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import CommonData
import SwiftUI

struct PeopleListScreen: View {
    
    let viewModel = PeopleListViewModel()
    
    init() {
        viewModel.fetchPeople()
    }
    
    let peoplePresentationToUiModelMapper: PeoplePresentationToUiModelMapper =
        .init(personDetailPresentationToUiModelMapper: .init())
    
    let peopleListErrorPresentationToUiExceptionMapper:
    PeopleListErrorPresentationToUiExceptionMapper =
        .init()
    
    @State
    var viewState: PeopleListViewState = PeopleListViewStateLoading()
    @State private var shouldShowAlert = false
    
    var peopleUiModel: PeopleUiModel? {
        guard let loaded = viewState as? PeopleListViewStateLoaded else {
            return nil
        }
        return peoplePresentationToUiModelMapper.toUi(input: loaded)
    }
    
    var errorMessage: String? {
        guard let error = viewState as? PeopleListViewStateError else {
            return nil
        }
        return peopleListErrorPresentationToUiExceptionMapper.toUi(input: error)
    }
    
    var body: some View {
        
        VStack {
            switch viewState {
            case is PeopleListViewStateLoading:
                ProgressView(localizedString("loading_description"))
            case is PeopleListViewStateLoaded:
                if let peopleUiModel = peopleUiModel {
                    PeopleListContent(peopleUiModel: peopleUiModel)
                }
            default:
                EmptyView()
            }
        }
        .collect(flow: self.viewModel.viewState, into: $viewState) { newValue in
            viewState = newValue
            if newValue is PersonDetailViewStateError {
                shouldShowAlert = true
            }
            return viewState
        }
        .alert(isPresented: $shouldShowAlert) {
            Alert(
                title: Text(localizedString("alert_description")),
                message: Text(errorMessage ?? ""),
                dismissButton: .default(Text(localizedString("ok_description")))
            )
        }
        
    }
}

#Preview {
    PeopleListScreen()
    
}
