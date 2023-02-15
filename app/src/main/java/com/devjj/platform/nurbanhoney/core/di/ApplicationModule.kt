package com.devjj.platform.nurbanhoney.core.di

import android.content.Context
import com.devjj.platform.nurbanhoney.BuildConfig
import com.devjj.platform.nurbanhoney.R
import com.devjj.platform.nurbanhoney.domain.BoardRepository
import com.devjj.platform.nurbanhoney.network.repositories.BoardRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun provideBoardRepository(dataSource : BoardRepositoryImpl) : BoardRepository = dataSource
}