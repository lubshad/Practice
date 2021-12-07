package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


const val TAG ="ScoreViewModel"
class ScoreFragmentViewModel(finalScore: Int): ViewModel() {
    var score = finalScore
    init {
        Log.i(TAG, "score is $score")
    }
}