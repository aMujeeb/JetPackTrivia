package com.mujapps.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mujapps.jettrivia.data.DataOrException
import com.mujapps.jettrivia.models.Question
import com.mujapps.jettrivia.repository.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val mQRepo: QuestionsRepository
) : ViewModel() {

    val mData: MutableState<DataOrException<ArrayList<Question>,
            Boolean,
            Exception>> = mutableStateOf(
        DataOrException(
            null,
            true,
            Exception("")
        )
    )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            mData.value.loading = true
            mData.value = mQRepo.getAllQuestions()
            if (mData.value.data.toString().isNotEmpty()) {
                mData.value.loading = false //This is fishy
            }
        }
    }

    fun getTotalQuestionsCount() : Int = mData.value.data?.toMutableList()?.size ?: 0
}