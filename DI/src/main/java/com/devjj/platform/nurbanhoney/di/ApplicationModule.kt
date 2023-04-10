package com.devjj.platform.nurbanhoney.di

import android.content.Context
import com.devjj.platform.nerbanhoney.di.R
import com.devjj.platform.nurbanhoney.domain.*
import com.devjj.platform.nurbanhoney.network.repositories.*
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
    fun provideArticleRepository(dataSource: ArticleRepositoryImpl): ArticleRepository = dataSource

    @Provides
    @Singleton
    fun provideBoardRepository(dataSource: BoardRepositoryImpl): BoardRepository = dataSource

    @Provides
    @Singleton
    fun LoginRepository(dataSource: LoginRepositoryImpl): LoginRepository = dataSource

    @Provides
    @Singleton
    fun profileRepository(dataSource: ProfileRepositoryImpl): ProfileRepository = dataSource

    @Provides
    @Singleton
    fun RankRepository(dataSource: RankRepositoryImpl): RankRepository = dataSource

    @Provides
    @Singleton
    fun TextEditorRepository(dataSource: TextEditorRepositoryImpl): TextEditorRepository = dataSource

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.server_address))
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)

        return okHttpClientBuilder.build()
    }
}
