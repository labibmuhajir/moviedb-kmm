//
//  SegmentedMovie.swift
//  iosApp
//
//  Created by Labib Muhajir on 13/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SegmentedMovie: View {
    private let title: String
    private let movies: [Movie]
    
    init(title: String, movies: [Movie]) {
        self.movies = movies
        self.title = title
    }
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(title)
            ScrollView(.horizontal) {
                LazyHStack {
                    ForEach(movies, id: \.id) { movie in
                        URLImage(url: movie.posterPath).frame(width: 120, alignment: .center)
                    }
                }
            }
        }
    }
}

struct SegmentedMovie_Previews: PreviewProvider {
    static var previews: some View {
        SegmentedMovie(title: "", movies: [])
    }
}
