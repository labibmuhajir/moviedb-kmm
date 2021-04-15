// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "MovieDbKit",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "MovieDbKit",
            targets: ["MovieDbKit"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "MovieDbKit",
            path: "./MovieDbKit.xcframework"
        ),
    ]
)
