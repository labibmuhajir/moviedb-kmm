//
//  Banner.swift
//  iosApp
//
//  Created by Labib Muhajir on 13/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct Banner: View {
    private let movies: [Movie]
    
    @State private var currentPage = 0
    
    init(movies: [Movie]) {
        self.movies = movies
    }
    
    var body: some View {
        ViewPager(pageCount: movies.count, currentIndex: $currentPage) {
            
            GeometryReader { geometry in
                LazyHStack(spacing: 0) {
                    ForEach(movies, id: \.id) { movie in
                        URLImage(url: movie.backdropPath).frame(width: geometry.size.width, alignment: .center)
                    }
                }
            }
            
        }
    }
}

struct Banner_Previews: PreviewProvider {
    static var previews: some View {
        GeometryReader{ geometry in
            Banner(movies: [])
        }
    }
}
