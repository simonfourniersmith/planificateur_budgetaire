package com.example.planificateurbudgetaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.Console
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

        val bouton_ajouter = findViewById<Button>(R.id.bouton_ajouter)
        val spinner_categorie = findViewById<Spinner>(R.id.spinner_categorie)

        val sommeTIET = findViewById<TextInputEditText>(R.id.input_somme)
        sommeTIET.text.toString().toFloat()
        val liste = arrayListOf<Float>()
        val spin = findViewById<Spinner>(R.id.spinner_categorie)
        val test = spin.onItemSelectedListener.toString()

        bouton_ajouter.setOnClickListener {
            
        }

    }
}