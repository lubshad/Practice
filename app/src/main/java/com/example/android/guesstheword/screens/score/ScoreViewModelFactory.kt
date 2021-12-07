package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScoreViewModelFactory(private val finalScore: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if (modelClass.name == ScoreFragmentViewModel::class.java.name) {
            return  ScoreFragmentViewModel(finalScore) as T
        }
        else {
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}