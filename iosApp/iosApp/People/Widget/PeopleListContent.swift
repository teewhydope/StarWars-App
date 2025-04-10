//
//  PeopleListContent.swift
//  iosApp
//
//  Created by ibrahim animasahun on 10/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct PeopleListContent: View {
    var peopleUiModel: PeopleUiModel
    @State private var shouldShowDetailView = false
    @State private var selectedPersonId: Int32? = nil
    @State private var selectedPersonName: String? = nil
    
    var body: some View {
        NavigationStack {
            ScrollView {
                LazyVStack(alignment: .leading, spacing: 0) {
                    ForEach(peopleUiModel.results, id: \.id) {
                        model in
                        itemCard(
                            imageUrl: model.image,
                            name: model.name
                        ).onTapGesture {
                            selectedPersonId = Int32(model.id)
                            shouldShowDetailView = true
                            selectedPersonName = model.name
                        }
                    }
                }
            }.navigationTitle("Characters")
                .navigationBarTitleDisplayMode(.inline)
                .navigationDestination(
                    isPresented: $shouldShowDetailView
                ) {
                    if let personName = selectedPersonName {
                        PersonDetail(id: selectedPersonId ?? 0)
                            .navigationTitle(personName)
                    }
                }
        }
    }
}
