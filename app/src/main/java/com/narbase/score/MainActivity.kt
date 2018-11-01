package com.narbase.score

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { obtainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initiateScore()

        increaseScoreButton.setOnClickListener {
            increaseScore()
        }
    }

    private fun obtainViewModel() = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

    private fun initiateScore() {
        scoreTextView.text = (viewModel.score).toString()
    }

    private fun increaseScore() {
        val newScore = ++(viewModel.score)
        scoreTextView.text = newScore.toString()
    }
}
