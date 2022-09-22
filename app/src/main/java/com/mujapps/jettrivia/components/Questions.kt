package com.mujapps.jettrivia.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.mujapps.jettrivia.screens.QuestionsViewModel
import com.mujapps.jettrivia.util.LoggerUtil

@Composable
fun Questions(qViewModel: QuestionsViewModel) {
    val questions = qViewModel.mData.value.data?.toMutableList()
    if (qViewModel.mData.value.loading == true) {
        CircularProgressIndicator()
        LoggerUtil.logMessage("Loading")
    } else {
        questions?.forEach { question ->
            LoggerUtil.logMessage("Question :" + question.question)
        }
    }
}