//
//  PagerView.swift
//  iosApp
//
//  Created by Labib Muhajir on 14/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct ViewPager<Content: View>: View {
    let pageCount: Int
    let content: Content
    
    @Binding var currentIndex: Int
    @GestureState private var translation: CGFloat = 0
    
    init(pageCount: Int, currentIndex: Binding<Int>, @ViewBuilder content: () -> Content) {
        self.pageCount = pageCount
        self._currentIndex = currentIndex
        self.content = content()
    }
    
    var body: some View {
        GeometryReader { geometry in
            HStack(spacing: 0) {
                self.content.frame(width: geometry.size.width)
            }
            .frame(width: geometry.size.width, alignment: .leading)
            .offset(x: -(CGFloat(self.currentIndex) * geometry.size.width))
            .offset(x: self.translation)
            .animation(.interactiveSpring(), value: currentIndex)
            .animation(.interactiveSpring(), value: translation)
            .gesture(
                DragGesture().updating(self.$translation) { (value, state, _) in
                    state = value.translation.width
                }.onEnded{ (value) in
                    let offset = value.translation.width / geometry.size.width
                    let newIndex = (CGFloat(self.currentIndex) - offset).rounded()
                    self.currentIndex = min(max(Int(newIndex), 0), self.pageCount - 1)
                }
            )
            
        }
    }
}

//struct PagerView_Previews: PreviewProvider {
//    @State private var currentPage = 0
//    static var previews: some View {
//        ViewPager(pageCount: 1, currentIndex: $currentPage) {
//            Text("a")
//        }
//    }
//}
