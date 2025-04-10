//
//  PeopleList.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import CommonData



struct PeopleListScreen: View {
    
    let viewModel = PeopleListViewModel()
    
    init () {
        viewModel.fetchPeople()
    }
        
    let peoplePresentationToUiModelMapper: PeoplePresentationToUiModelMapper =
        .init(personDetailPresentationToUiModelMapper: .init())
    
    @State
    var viewState: PeopleListViewState = PeopleListViewStateLoading()
    
    var peopleUiModel: PeopleUiModel? {
           guard let loaded = viewState as? PeopleListViewStateLoaded else { return nil }
        return peoplePresentationToUiModelMapper.toUi(input: loaded)
       }

    var body: some View {
        
        let model = (viewState as? PeopleListViewStateLoaded).map { peoplePresentationToUiModelMapper.toUi(input: $0) }
        
        VStack {
            switch viewState {
            case is PeopleListViewStateLoading:
                ProgressView("Loading...")
            case is PeopleListViewStateLoaded:
                if let peopleUiModel = model {
                    NavigationView {
                        ScrollView {
                            LazyVStack(alignment: .leading, spacing: 0) {
                                ForEach(peopleUiModel.results, id: \.id) { model in
                                    ItemCard(model: model)
                                }
                            }
                        }.navigationTitle("Characters")

                    }                }
            case is PeopleListViewStateError:
                Text("Error occurred")
            default:
                EmptyView()
            }
        }
        .collect(flow: self.viewModel.viewState, into: $viewState)

    }
}

struct ItemCard: View {
    var model: PersonDetailUiModel
    var body: some View {
        VStack {
            AsyncImage(url: URL(string: model.image)) { image in
                image.resizable()
            } placeholder: {
                Color.gray
            }
            .frame(height: 200)
            Text(model.name)
            Spacer()
            Divider().background(.gray)
        }
    }

}



#Preview {
    PeopleListScreen()

}

