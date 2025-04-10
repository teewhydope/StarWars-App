//
//  PeopleListErrorPresentationToUiExceptionMapper.swift
//  iosApp
//
//  Created by ibrahim animasahun on 10/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import CommonData

class PeopleListErrorPresentationToUiExceptionMapper: PresentationToUiMapper{
    typealias T = PeopleListViewStateError
    
    typealias U = String
    
    
    func toUi(input: PeopleListViewStateError) -> String {
        switch input.error {
        case is CharacterErrorPresentationModelNoInternet:
            return localizedString("no_internet_error")
        case is CharacterErrorPresentationModelRequestTimeout:
            return localizedString("error_timeout_description")
        case is CharacterErrorPresentationModelUnknown:
            return localizedString("error_unknown_description")
        default:
            return localizedString("error_unknown_description")
        }
    }
}

