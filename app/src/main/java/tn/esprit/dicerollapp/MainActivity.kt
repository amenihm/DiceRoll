package tn.esprit.dicerollapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    var rollBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

             setContentView(R.layout.activity_main)

      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        diceImage = findViewById(R.id.diceImage)
        rollBtn = findViewById(R.id.rollBtn)

        // Appel du fonction permet l'afficher d'une image de dé au démarrage.
        displayDiceImage()

             rollBtn!!.setOnClickListener {
            displayDiceImage()
        }
    }

  fun displayDiceImage() {
        // Création d'un objet Dice de 6 faces.
        val dice = Dice(6)
        // génère un numéro aléatoire entre 1 et 6.
        val generatedNumber = dice.rollDice()
      when (generatedNumber) {
            1 -> diceImage.setImageResource(R.drawable.dice_1) // Met à jour l'image pour un dé montrant 1.
            2 -> diceImage.setImageResource(R.drawable.dice_2) // Met à jour l'image pour un dé montrant 2.
            3 -> diceImage.setImageResource(R.drawable.dice_3) // Met à jour l'image pour un dé montrant 3.
            4 -> diceImage.setImageResource(R.drawable.dice_4) // Met à jour l'image pour un dé montrant 4.
            5 -> diceImage.setImageResource(R.drawable.dice_5) // Met à jour l'image pour un dé montrant 5.
            6 -> diceImage.setImageResource(R.drawable.dice_6) // Met à jour l'image pour un dé montrant 6.
        }
    }
}
