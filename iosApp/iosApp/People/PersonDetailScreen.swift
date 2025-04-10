//
//  PersonDetailScreen.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import CommonData



struct PersonDetail: View {
    
    let id: Int32?
    
    let viewModel = PersonDetailViewModel()
    
    init (id: Int32) {
        self.id = id
        viewModel.fetchPersonDetail(id: id)
    }
    
    let personDetailPresentationToUiModelMapper: PersonDetailPresentationToUiModelMapper =
        .init()
    
    let personDetailErrorPresentationToUiExceptionMapper: PersonDetailErrorPresentationToUiExceptionMapper =
        .init()
    
    @State
    var viewState: PersonDetailViewState = PersonDetailViewStateLoading()
    @State private var shouldShowAlert = false
    
    
    var model: PersonDetailUiModel? {
        guard let loaded = viewState as? PersonDetailViewStateLoaded else { return nil }
        return personDetailPresentationToUiModelMapper.toUi(input: loaded)
    }
    
    var errorMessage: String? {
        guard let error = viewState as? PersonDetailViewStateError else { return nil }
        return personDetailErrorPresentationToUiExceptionMapper.toUi(input: error)
    }
    
    
    var body: some View {
        VStack {
            switch viewState {
            case is PersonDetailViewStateLoading:
                ProgressView(localizedString("loading_description"))
            case is PersonDetailViewStateLoaded:
                if let model = model {
                    ScrollView {
                        VStack(alignment: .leading, spacing: 0) {
                            itemCard(
                                imageUrl: model.image,
                                name: model.name
                            )
                            Spacer()
                            Text(model.birthYear)
                            Spacer()
                            Text(model.gender)
                            Spacer()
                            Text(model.url)
                        }
                    }
                }
            default:
                EmptyView()
            }
        }
        .collect(flow: self.viewModel.viewState, into: $viewState){ newValue in
            viewState = newValue
            if newValue is PersonDetailViewStateError {
                shouldShowAlert = true
            }
            return viewState
        }
        .navigationTitle(model?.name ?? "")
        .toolbarRole(.editor)
        .alert(isPresented: $shouldShowAlert) {
            Alert(title: Text(localizedString("alert_description")),
                  message: Text(errorMessage ?? ""),
                  dismissButton: .default(Text(localizedString("ok_description"))){
                viewModel.fetchPersonDetail(id: Int32(id!))
            }
            )
        }
    }
    
}



#Preview {
    
    PersonDetail(id: 2)
    
}

