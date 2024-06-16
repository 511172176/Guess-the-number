package com.example.guessinggame

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.guessinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 使用 ViewModels 委託屬性來取得 ViewModel 實例
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 設置 DataBinding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // 設置退出按鈕點擊事件
        binding.exitButton.setOnClickListener {
            finish() // 退出應用程式
        }
    }
}
