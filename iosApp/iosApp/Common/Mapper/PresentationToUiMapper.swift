//
//  PresentationToUiMapper.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//



import Foundation

protocol PresentationToUiMapper {
    associatedtype T
    associatedtype U

    func toUi(input: T) -> U
}

