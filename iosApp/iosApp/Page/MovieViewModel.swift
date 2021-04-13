//
//  MovieViewModel.swift
//  iosApp
//
//  Created by Labib Muhajir on 13/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class MovieViewModel: ObservableObject {
    private let movieUseCase: MovieUseCase
    
    @Published var discoverMovie = [Movie]()
    @Published var upcomingMovie = [Movie]()
    @Published var popularMovie = [Movie]()
    
    init(movieUseCase: MovieUseCase) {
        self.movieUseCase = movieUseCase
    }
    
    func getData() {
        getDiscoverMovie()
        getPopularMovie()
        getUpComingMovie()
    }
    
    private func getDiscoverMovie() {
        movieUseCase.flowDiscoverMovie(page: 1) { (movie, error) in
            if let error = error {
                print(error)
                return
            }
            
            guard let movie = movie else { return }
            
            self.discoverMovie = movie
        }
    }
    
    private func getPopularMovie() {
        movieUseCase.flowPopularMovie(page: 1) { (movie, error) in
            if let error = error {
                print(error)
                return
            }
            
            guard let movie = movie else { return }
            
            self.popularMovie = movie
        }
    }
    
    private func getUpComingMovie() {
        movieUseCase.flowUpcomingMovie(page: 1) { (movie, error) in
            if let error = error {
                print(error)
                return
            }
            
            guard let movie = movie else { return }
            
            self.upcomingMovie = movie
        }
    }
}
