package com.example.movieapp.di

import androidx.compose.ui.text.style.LineBreak
import com.example.movieapp.data.interceptors.AcceptedContentTypeInterceptor
import com.example.movieapp.data.interceptors.AuthInterceptor
import com.example.movieapp.data.movies.datasource.MoviesApi
import com.example.movieapp.networkingconfig.NetworkingConfig
import com.example.movieapp.networkingconfig.NetworkingConfig.API_BASE_URL
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TIMEOUT = 30L

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideGson(): Gson = GsonBuilder().setStrictness(Strictness.LENIENT).create()

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    fun provideAuthInterceptor(): Interceptor = AuthInterceptor()

    @Provides
    fun provideOkhttpClient(authInterceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(AcceptedContentTypeInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()


    @Provides
    @Singleton
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi =  retrofit.create(MoviesApi::class.java)
}