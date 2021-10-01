package com.example.twoplayerdicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.twoplayerdicegame.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var playerOnePoints = 0
    var playerTwoPoints = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rollButton.setOnClickListener {
            rollDice()

        }

    }

    private fun rollDice() {
        val random = Random().nextInt(6) + 1
        val randomTwo = Random().nextInt(6) + 1

        val drawableResource = when (random) {
            1 -> R.drawable.dice_one
            2 -> R.drawable.dice_two
            3 -> R.drawable.dice_three
            4 -> R.drawable.dice_four
            5 -> R.drawable.dice_five
            else -> R.drawable.dice_six
        }
        val diceImage: ImageView = findViewById(R.id.player_1)
        diceImage.setImageResource(drawableResource)

        val drawableResourceTwo = when (randomTwo) {
            1 -> R.drawable.dice_one
            2 -> R.drawable.dice_two
            3 -> R.drawable.dice_three
            4 -> R.drawable.dice_four
            5 -> R.drawable.dice_five
            else -> R.drawable.dice_six
        }

        val diceImage2 : ImageView = findViewById(R.id.player_2)
        diceImage2.setImageResource(drawableResourceTwo)

        if(random > randomTwo) {
             playerOnePoints++
            binding.playerOneText.text = "Player One : $playerOnePoints"

        } else if (randomTwo > random) {
            playerTwoPoints++
            binding.playerTwoText.text = "Player Two: $playerTwoPoints "
        }

    }





}




