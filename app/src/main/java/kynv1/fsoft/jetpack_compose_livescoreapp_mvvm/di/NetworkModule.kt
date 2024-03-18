package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove.ElenaApiService
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.utils.Constants.BASE_URL
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.utils.RequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun okHttp(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun elenaApiService(retrofit: Retrofit): ElenaApiService {
        return retrofit.create(ElenaApiService::class.java)
    }
}