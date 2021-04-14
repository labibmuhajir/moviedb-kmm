package com.github.labibmuhajir.moviedb.di

import com.github.labibmuhajir.moviedb.data.MovieDataSource
import com.github.labibmuhajir.moviedb.data.MovieRepository
import com.github.labibmuhajir.moviedb.domain.MovieUseCase
import com.github.labibmuhajir.moviedb.domain.MovieUseCaseImpl
import com.github.labibmuhajir.moviedb.service.HttpService
import com.github.labibmuhajir.moviedb.service.Service
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule)
    }

// called by iOS etc
fun initKoin() = initKoin {}

val commonModule = module {
    single {
        HttpClient {
            defaultRequest {
                host = HttpService.baseUrl
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                parameter("api_key", HttpService.apiKey)
            }
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
                serializer = KotlinxSerializer(json)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }
    single<Service> { HttpService() }
    single<MovieDataSource> { MovieRepository() }
    single<MovieUseCase> { MovieUseCaseImpl() }
}