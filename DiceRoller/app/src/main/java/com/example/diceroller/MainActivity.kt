package com.example.diceroller //Package had to be call, to reference views from XMLs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var diceImage : ImageView  //lateinit is used when you set field variables
    /* The reason you'll want to set field variables is to make less cpu
        expensive processes, like trying to find id for the rollDice().

        It doesn't make much of a difference here since this app is small, and
        being tested on newer devices.  It really matters when you have to call
        various ID'd views.  Once they're set as field variables, you just need
        to remember to call them in this onCreate function.

        BE SURE TO USE THE COLON ( : ) NOT THE EQUAL ( = ) SYMBOL.  COLONS ARE
        USED FOR VARIABLE TYPE DEFINITION, EQUALS LETS YOU DEFINE THE ACTUAL
        VALUE OF A VARIABLE.

        Define ya variables inside of the MainActivity class to prevent memory leaks
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
            // An example of calling an XML view by ID

        rollButton.setOnClickListener { //setOnClickListener is the onClick event trigger
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)

    }

    private fun rollDice() {

        val randomInt = Random().nextInt(6) + 1 //Rolls between 1 and 6

        val drawableResource = when (randomInt) { //dice_# refers to the dice images in
                // The drawable folder
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}


/*  How to make Toast (The little notification box, that gives little tibbits)
*
* Toast.makeText(this,
                 "button works",
                 Toast.LENGTH_SHORT)
                .show()

            * Toast is the little notification box at the bottom of an android app
            *
            * makeText is a command that allows text to be added to an object
            *   the first argument is looking for a Context, or the OS to put something on
            *   the screen.  Putting "this" here should be fine, so the text is put on the
            *   current screen
            *
            *   The second argument is what the text will show
            *
            *   The third is looking for a duration to show the text, in this toast's case
            *   it'll be short
            *
            *  .show() will allow the previously set text to be shown

            /
 */