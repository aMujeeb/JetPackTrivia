package com.mujapps.jettrivia.repository

import com.mujapps.jettrivia.data.DataOrException
import com.mujapps.jettrivia.models.Question
import com.mujapps.jettrivia.network.QuestionsApi
import javax.inject.Inject

class QuestionsRepository @Inject constructor(
    private val mQApi: QuestionsApi
) {
    private val mListOfQuestions = DataOrException<ArrayList<Question>,
            Boolean,
            Exception>()
}