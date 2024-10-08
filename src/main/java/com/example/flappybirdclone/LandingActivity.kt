package com.example.flappybirdclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flappybirdclone.databinding.ActivityMainBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the start button to launch the game
        binding.startButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        // Optionally, display the high score
        val highScore = getHighScore()
        binding.highScoreTextView.text = "High Score: $highScore"
    }

    // Function to retrieve the high score from shared preferences
    private fun getHighScore(): Int {
        val sharedPref = getSharedPreferences("FlappyBirdClone", MODE_PRIVATE)
        return sharedPref.getInt("HIGH_SCORE", 0)
    }
}
