import SwiftUI
import shared

@main
struct iOSApp: App {
    private let movieUseCase: MovieUseCase = MovieUseCaseImpl()
    
    init() {
        AppModuleKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView().environmentObject(
                MovieViewModel(movieUseCase: movieUseCase)
            )
        }
    }
}
