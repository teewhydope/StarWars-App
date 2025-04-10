//
//  PersonDetailErrorPresentationToUiExceptionMapper.swift
//  iosApp
//
//  Created by ibrahim animasahun on 10/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//


import Foundation
import CommonData

class PersonDetailErrorPresentationToUiExceptionMapper: PresentationToUiMapper{
    typealias T = PersonDetailViewStateError
    
    typealias U = String
    
    
    func toUi(input: PersonDetailViewStateError) -> String {
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
    
    private func localizedString(_ key: String) -> String {
        return NSLocalizedString(key, comment: "")
    }
}


