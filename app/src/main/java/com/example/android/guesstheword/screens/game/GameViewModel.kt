package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData


const val TAG = "GAME"
class GameViewModel : ViewModel() {
    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }


    // The current word
    var word = MutableLiveData("")

    // The current score
    var score = MutableLiveData(0)
    private lateinit var wordList: MutableList<String>

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        val newScore = score.value!! - 1
        score.value = newScore
        nextWord()
    }

    fun onCorrect() {
        val newScore = score.value!! + 1
        score.value = newScore
        Log.e(TAG, score.value!!.toString())
        nextWord()
    }

    /**
     * Moves to the next word in the list
     */
    fun nextWord() {
        if (!wordList.isNullOrEmpty()) {
            //Select and remove a word from the list
            word.value = wordList.removeAt(0)
        }
    }
}