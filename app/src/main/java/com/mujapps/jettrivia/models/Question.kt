package com.mujapps.jettrivia.models

data class Question(
    val question: String,
    val category: String,
    val answer: String,
    val choices: List<String>
)
