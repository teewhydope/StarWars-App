//
//  ViewExtension.swift
//  iosApp
//
//  Created by ibrahim animasahun on 10/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI


extension View{
    func itemCard(imageUrl: String, name: String) -> some View {
            VStack {
                AsyncImage(url: URL(string: imageUrl)) { image in
                    image.resizable()
                } placeholder: {
                    Color.gray
                }
                .frame(height: 200)
                Text(name)
                Spacer()
                Divider().background(.gray)
            }
    }
}
