//
//  PersonDetailPresentationToUiModelMapper.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.

import Foundation
import CommonData

class PersonDetailPresentationToUiModelMapper: PresentationToUiMapper{
    typealias T = PersonDetailViewStateLoaded
    
    typealias U = PersonDetailUiModel
    
    
    func toUi(input: PersonDetailViewStateLoaded) -> PersonDetailUiModel {
        return .init(
            id: Int(input.personDetail.id),
            name: input.personDetail.name,
            height: input.personDetail.height,
            mass: input.personDetail.mass,
            image: input.personDetail.image,
            birthYear: input.personDetail.birthYear,
            gender: input.personDetail.gender,
            homeWorld: input.personDetail.homeWorld,
            url: input.personDetail.url,
        )
    }
    
}


