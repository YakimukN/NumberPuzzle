package com.example.numberpuzzle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberpuzzle.databinding.ActivityMainBinding
import com.example.numberpuzzle.game.GameActivity
import com.example.numberpuzzle.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gameBtn.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        binding.settingsBtn.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        binding.helpBtn.setOnClickListener {
            startActivity(Intent(this, HelpActivity::class.java))
        }

        binding.statisticBtn.setOnClickListener {
            startActivity(Intent(this, StatisticActivity::class.java))
        }
    }
}