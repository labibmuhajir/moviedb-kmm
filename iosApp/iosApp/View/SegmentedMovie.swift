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
            Text(title).padding(EdgeInsets(top: 0, leading: 12, bottom: 0, trailing: 12))
            ScrollView(.horizontal) {
                LazyHStack {
                    ForEach(movies, id: \.id) { movie in
                        URLImage(url: movie.posterPath).frame(width: 120, alignment: .center)
                    }
                }.padding(EdgeInsets(top: 0, leading: 12, bottom: 0, trailing: 12))
            }
        }.padding(EdgeInsets(top: 8, leading: 0, bottom: 8, trailing: 0))
    }
}

struct SegmentedMovie_Previews: PreviewProvider {
    static var previews: some View {
        SegmentedMovie(title: "", movies: [])
    }
}
