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
    private lateinit var gifImage : GifImageView
    private var hunger = 60
    private var clean = 30
    private var happy = 80


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
        gifImage = findViewById(R.id.gifCat)

        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnClean = findViewById<Button>(R.id.btnClean)

        //Feed button action
        updateUI()

        btnFeed.setOnClickListener {
            gifImage.setImageResource(R.drawable.eatingcat)
            updateUI()
            feedCat()
        }

        //Play button action
        btnPlay.setOnClickListener {
            gifImage.setImageResource(R.drawable.playingcat)
            updateUI()
            playCat()
        }

        //Clean button action
        btnClean.setOnClickListener {
            gifImage.setImageResource(R.drawable.cleaningcat)
            updateUI()
            cleanCat()
        }
    }

    private fun feedCat(){
        if (hunger > 0) hunger -= 10 // Reduces hunger
        if (happy < 100) happy += 5  // Increases happiness
        if (clean < 100) clean -= 5   // Slightly reduces cleanliness
    }

    private fun playCat(){
        if (happy < 100) happy += 20  // Significantly increases happiness
        if (clean > 0) clean -= 10  // Reduces cleanliness
        if (hunger > 0) hunger += 5  // Slightly increase hunger
    }

    private fun cleanCat(){
        if (clean < 100) clean += 20  // Significantly increases cleanliness
        if (happy < 100) happy += 5   // Slightly increases happiness
        if (hunger > 0) hunger += 5  // Slightly increase hunger
    }

    private fun updateUI(){

        val tvHunger = findViewById<TextView>(R.id.tvHunger)
        val tvClean = findViewById<TextView>(R.id.tvClean)
        val tvHappy = findViewById<TextView>(R.id.tvHappy)

        tvHunger.text = "Health: $hunger"
        tvClean.text = "Clean: $clean"
        tvHappy.text = "Happy: $happy"

    }

}