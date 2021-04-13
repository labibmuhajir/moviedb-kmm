//
//  ImageLoader.swift
//  iosApp
//
//  Created by Labib Muhajir on 13/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

enum ImageSize: String{
    case w200, w500
}

class ImageLoader: ObservableObject {
    @Published var imageData: Data?
    
    func downloadImage(url: String, size: ImageSize = .w200) {
        let fixUrl = "\(HttpService.Companion().imageUrl)/\(size)/\(url)"
        
        guard  let imageUrl = URL(string: fixUrl) else {
            return
        }
        
        URLSession.shared.dataTask(with: imageUrl) { data, response, error in
            if let error = error {
                print(error)
            }
            
            guard let data = data else { return }
            
            DispatchQueue.main.async {
                self.imageData = data
            }
        }.resume()
    }
}
