//
//  ContentView.swift
//  iosApp
//
//  Created by ibrahim animasahun on 09/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//


import SwiftUI
import CommonData


struct ContentView: View {
    
    var body: some View {
        TabView {
            PeopleListScreen()
                .tabItem {
                    Image(systemName: "person.fill")
                    Text("People")
            }
            Text("StarShips Screen")
                .tabItem {
                    Image(systemName: "star.fill")
                    Text("StarShips")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
