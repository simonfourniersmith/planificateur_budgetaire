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
import kotlinx.serialization.Serializable

@Serializable
data class Revenu(
    val categorie: String,
    val frequence: String,
    val somme: Float
)

data class Depense(
    val categorie: String,
    val frequence: String,
    val somme: Float
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

    }
}