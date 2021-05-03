package com.example.planificateurbudgetaire

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Spinner
import com.example.planificateurbudgetaire.model.Depense
import com.example.planificateurbudgetaire.model.Revenu
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.Console
import kotlin.math.log
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class MainActivity : AppCompatActivity() {

    val liste_revenus = mutableListOf<Revenu>()
    val liste_depenses = mutableListOf<Depense>()

    public fun addRevenu(revenu: Revenu) {
        liste_revenus.add(revenu)
        var json_liste_revenus = Json.encodeToString(liste_revenus)
        openFileOutput("sauvegarde_revenus", Context.MODE_PRIVATE).use {
            it.write(json_liste_revenus.toByteArray())
        }
    }

    public fun addDepense(depense: Depense) {
        liste_depenses.add(depense)
        var json_liste_depenses = Json.encodeToString(liste_depenses)
        openFileOutput("sauvegarde_depenses", Context.MODE_PRIVATE).use {
            it.write(json_liste_depenses.toByteArray())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

        /* TODO Charger les fichiers de données lors de l'ouverture de l'application */
    }
}
