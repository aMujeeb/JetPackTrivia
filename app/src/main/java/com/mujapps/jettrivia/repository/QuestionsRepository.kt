package com.mujapps.jettrivia.repository

import com.mujapps.jettrivia.data.DataOrException
import com.mujapps.jettrivia.models.Question
import com.mujapps.jettrivia.network.QuestionsApi
import javax.inject.Inject

class QuestionsRepository @Inject constructor(
    private val mQApi: QuestionsApi
) {
    private val mDataOrException = DataOrException<ArrayList<Question>,
            Boolean,
            Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<Question>,
            Boolean,
            Exception> {
        try {
            mDataOrException.loading = true
            mDataOrException.data = mQApi.getAllQuestions()
            mDataOrException.loading = false
        } catch (e: Exception) {
            mDataOrException.e = e
        }
        return mDataOrException
    }
}