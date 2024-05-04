package com.oneofone.petpal

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.droidsonroids.gif.GifImageView

class SecondActivity : AppCompatActivity() {

    // declare
    private lateinit var gifImage : GifImageView
    private var hunger = 65
    private var clean = 32
    private var happy = 87


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
            Log.i("ButtonClicked", "Feed button clicked") // Log button

            gifImage.setImageResource(R.drawable.eatingcat)
            updateUI()
            feedCat()
        }

        //Play button action
        btnPlay.setOnClickListener {
            Log.i("ButtonClicked", "Play button clicked") // Log button

            gifImage.setImageResource(R.drawable.playingcat)
            updateUI()
            playCat()
        }

        //Clean button action
        btnClean.setOnClickListener {
            Log.i("ButtonClicked", "Clean button clicked") // Log button

            gifImage.setImageResource(R.drawable.cleaningcat)
            updateUI()
            cleanCat()
        }
    }

    private fun feedCat(){
        hunger -= 10                      // Reduces hunger
        if (hunger < 0) hunger = 0        // minimum range
        if (hunger == 0)
        {Toast.makeText(this, "Chai is no longer hungary", Toast.LENGTH_SHORT).show()}

        if (happy < 100) happy += 5       // Increases happiness
        if (happy > 100) happy = 100      // maximum range
        if (happy == 100)
        {Toast.makeText(this, "Chai is satisfied", Toast.LENGTH_SHORT).show()}

        if (clean < 100) clean -= 3       // Slightly reduces cleanliness
        if (clean < 0) clean = 0          // minimum range
        if (clean == 0)
        {Toast.makeText(this, "Chai is dirty", Toast.LENGTH_SHORT).show()}
    }

    private fun playCat(){
        happy += 15                       // increases happiness
        if (happy > 100) happy = 100      // maximum range
        if (hunger == 100)
        {Toast.makeText(this, "Chai is the happiest", Toast.LENGTH_SHORT).show()}

        if (clean > 0) clean -= 12        // Reduces cleanliness
        if (clean < 0) clean = 0          // minimum range
        if (hunger == 0)
        {Toast.makeText(this, "Chai is mucky", Toast.LENGTH_SHORT).show()}

        if (hunger < 100) hunger += 6     // Slightly increase hunger
        if (hunger > 100) hunger = 100    // maximum range
        if (hunger == 100)
        {Toast.makeText(this, "Chai is really hungry", Toast.LENGTH_SHORT).show()}
    }

    private fun cleanCat(){
        clean += 18                       // increases cleanliness
        if (clean > 100) clean = 100      // maximum range
        if (hunger == 100)
        {Toast.makeText(this, "Chai is fully Cleaned", Toast.LENGTH_SHORT).show()}

        if (happy > 0) happy -= 8         // decreases happiness
        if (happy < 0) happy = 0          // maximum range
        if (hunger == 0)
        {Toast.makeText(this, "Chai is unhappy", Toast.LENGTH_SHORT).show()}

        if (hunger < 100) hunger += 5     // increase hunger
        if (hunger > 100) hunger = 100    // maximum range
        if (hunger == 100)
        {Toast.makeText(this, "Chai is starving", Toast.LENGTH_SHORT).show()}
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI(){

        val tvHunger = findViewById<TextView>(R.id.tvHunger)
        val tvClean = findViewById<TextView>(R.id.tvClean)
        val tvHappy = findViewById<TextView>(R.id.tvHappy)

        tvHunger.text = "Hunger: $hunger%"
        tvClean.text = "Clean: $clean%"
        tvHappy.text = "Happy: $happy%"

    }

}