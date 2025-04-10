//
//  PeoplePresentationToUiModelMapper.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//


import Foundation
import CommonData

class PeoplePresentationToUiModelMapper: PresentationToUiMapper{
    typealias T = PeopleListViewStateLoaded
    
    typealias U = PeopleUiModel
    
    private let personDetailPresentationToUiModelMapper: PersonDetailPresentationToUiModelMapper
    
    init(
        personDetailPresentationToUiModelMapper: PersonDetailPresentationToUiModelMapper,
    ) {
        self
            .personDetailPresentationToUiModelMapper = personDetailPresentationToUiModelMapper
    }
    
    func toUi(input: PeopleListViewStateLoaded) -> PeopleUiModel {
        
        return .init(
            count: Int(input.people.count),
            results: input.people.results.map {
                personDetailPresentationToUiModelMapper
                    .toUi(input: PersonDetailViewStateLoaded(personDetail: $0) )
            }
        )
    }
    
}

