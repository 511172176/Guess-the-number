// MainViewModel.kt
package com.example.guessinggame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    // 隨機生成一個目標數字
    private var targetNumber = Random.nextInt(1, 101)

    // 用於存儲用戶猜測的數字
    val userGuess = MutableLiveData<String>()

    // 用於存儲回饋信息
    private val _feedback = MutableLiveData<String>()
    val feedback: LiveData<String> = _feedback

    // 檢查用戶的猜測
    fun checkGuess() {
        // 取得用戶輸入的數字
        val guess = userGuess.value?.toIntOrNull()
        // 根據用戶的猜測更新回饋信息
        when {
            guess == null -> _feedback.value = "Please enter a valid number"
            guess < targetNumber -> _feedback.value = "Too low!"
            guess > targetNumber -> _feedback.value = "Too high!"
            else -> _feedback.value = "Congratulations! You guessed it!"
        }
    }
    // 開始新遊戲
    fun startNewGame() {
        targetNumber = Random.nextInt(1, 101)
        userGuess.value = ""
        _feedback.value = "New game started! Guess a number between 1 and 100."
    }
}
