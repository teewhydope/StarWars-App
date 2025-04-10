import SwiftUI
import CommonData

@main
struct iOSApp: App {
    
    init() {
        AppDIContainer().doInitKoinModules()
    }
    
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
