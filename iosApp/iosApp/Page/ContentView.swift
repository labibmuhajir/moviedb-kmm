import SwiftUI
import shared

struct ContentView: View {
    @EnvironmentObject var viewModel: MovieViewModel
    
    var body: some View {
        ZStack{
            Color.white.edgesIgnoringSafeArea(.all)
            
            ScrollView(.vertical) {
                VStack(alignment: .leading){
                    
                    Banner(movies: viewModel.discoverMovie).frame(height: 300, alignment: .center).edgesIgnoringSafeArea(.top)
                    
                    SegmentedMovie(title: "Popular Movie", movies: viewModel.popularMovie).frame(height: 210)
                    
                    Divider()
                    SegmentedMovie(title: "Upcoming Movie", movies: viewModel.upcomingMovie).frame(height: 210)
                    
                }
            }.edgesIgnoringSafeArea(.top)
        }.onAppear(perform: {
            viewModel.getData()
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

extension Movie: Identifiable {}