package com.oneofone.petpal

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.droidsonroids.gif.GifImageView

class SecondActivity : AppCompatActivity() {

    // declare
    private lateinit var gifCat : GifImageView
    private var hunger = 100
    private var clean = 100
    private var happy = 100


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //initialise
        gifCat = findViewById(R.id.gifCat)

        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnClean = findViewById<Button>(R.id.btnClean)

        //Feed button action
        updateUI()
    }

    private fun updateUI(){

        val tvHunger = findViewById<TextView>(R.id.tvHunger)
        val tvClean = findViewById<TextView>(R.id.tvClean)
        val tvHappy = findViewById<TextView>(R.id.tvHappy)
    }

}