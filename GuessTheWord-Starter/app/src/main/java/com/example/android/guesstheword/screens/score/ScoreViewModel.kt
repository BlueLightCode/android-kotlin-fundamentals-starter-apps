package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
    private var _playAgain = MutableLiveData<Boolean>()
        val playAgain: LiveData<Boolean>
                get() = _playAgain

    init {
        _score.value = finalScore
        Log.i("ScoreViewModel", "Final score is $_score.value")
    }
    fun onPlayAgain(){
        _playAgain.value = true
    }
    fun onPlayAgainComplete(){
        _playAgain.value = false
    }
}