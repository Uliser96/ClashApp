package com.aptivist.clashapp.core.di

import com.aptivist.clashapp.BuildConfig
import com.aptivist.clashapp.Constants
import com.aptivist.clashapp.data.remote.ClashRoyaleAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.API_BASE_URL)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    @Provides
    @Singleton
    fun providesClashApi(retrofit: Retrofit): ClashRoyaleAPI =
        retrofit.create(ClashRoyaleAPI::class.java)

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer ${Constants.BEARER_TOKEN}")
                .build()
            chain.proceed(newRequest)
        }).apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY

                })
            }
        }.build()
}