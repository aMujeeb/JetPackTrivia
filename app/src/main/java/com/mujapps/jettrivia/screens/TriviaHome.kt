package com.mujapps.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mujapps.jettrivia.components.Questions

@Composable
fun TriviaHome(qViewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(qViewModel = qViewModel)
}