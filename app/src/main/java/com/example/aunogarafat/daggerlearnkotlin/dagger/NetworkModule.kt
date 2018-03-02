package com.example.aunogarafat.daggerlearnkotlin.dagger

import com.example.aunogarafat.daggerlearnkotlin.network.ApiInterface
import com.example.aunogarafat.daggerlearnkotlin.utils.Const
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton



/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
@Module
class NetworkModule {
    companion object {
        private const val NAME_BASE_URL = "NAME_BASE_URL"
    }

    @Provides
    @Named(NAME_BASE_URL)
    fun provideBaseUrlString()=Const.BASE_URL

    @Provides
    @Singleton
    fun provideGsonConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(converter: Converter.Factory, @Named(NAME_BASE_URL) baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .build()
    }
    @Provides
    @Singleton
    fun provideUsApi(retrofit: Retrofit):ApiInterface{
        return  retrofit.create(ApiInterface::class.java)
    }

}