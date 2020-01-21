package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){

    // The current word
   private var _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word


    // The current score
   private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val timer: CountDownTimer

    private var _eventGameFinish = MutableLiveData<Boolean>()
     val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

fun resetList() {
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
                "bubble",
                "Terry",
                "Jim",
                "Randy"
        )
        wordList.shuffle()
    }
 fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
    }
    init{
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){
            override fun onTick(p0: Long) {
                _currentTime.value = p0 / ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()
            }
        }
        _word.value = ""
        _score.value = 0
        resetList()
        nextWord()
        Log.i("GameViewModel","GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        Log.i("GameVieModel", "GameViewModel destroyed!")

    }
 fun onSkip() {
        if (!wordList.isEmpty()) {
            _score.value = score.value?.minus(1)
            nextWord()
        }else {
            resetList()
        }

    }

 fun onCorrect() {
        if (!wordList.isEmpty()) {
            _score.value = score.value?.plus(1)
            nextWord()
        }else{
            resetList()
        }

    }
    fun onGameFinish(){
        _eventGameFinish.value = true
    }
    fun onGameFinishComplete(){
        _eventGameFinish.value = false
    }

    companion object {
        //Time when the game is over
        private const val DONE = 0L

        //Countdown time interval
        private const val ONE_SECOND = 1000L

        //Total time for the game
        private const val COUNTDOWN_TIME = 60000L




    }
}
