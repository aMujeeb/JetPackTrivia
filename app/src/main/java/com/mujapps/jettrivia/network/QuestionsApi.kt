package com.mujapps.jettrivia.network

import com.mujapps.jettrivia.models.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionsApi {
    @GET("world.json")
    suspend fun getAllQuestions(): ArrayList<Question>
}