package com.mujapps.jettrivia.di

import com.mujapps.jettrivia.network.QuestionsApi
import com.mujapps.jettrivia.repository.QuestionsRepository
import com.mujapps.jettrivia.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideQuestionsApi(): QuestionsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideQuestionRepository(questionApi: QuestionsApi) = QuestionsRepository(questionApi)
}