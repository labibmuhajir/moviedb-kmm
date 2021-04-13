//
//  URLImage.swift
//  iosApp
//
//  Created by Labib Muhajir on 13/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct URLImage: View {
    private let url: String?
    private let placeholder: String
    
    @ObservedObject private var imageLoader = ImageLoader()
    
    init(url: String?, placeholder: String = "placeholder") {
        self.url = url
        self.placeholder = placeholder
        
        if let url = url {
            self.imageLoader.downloadImage(url: url)
        }
    }
    
    var body: some View {
        if let data = imageLoader.imageData {
            return Image(uiImage: UIImage(data: data)!).resizable()
        } else {
            return Image(placeholder).resizable()
        }
    }
}

struct URLImage_Previews: PreviewProvider {
    static var previews: some View {
        URLImage(url: "https://fyrafix.files.wordpress.com/2011/08/url-8.jpg")
    }
}
