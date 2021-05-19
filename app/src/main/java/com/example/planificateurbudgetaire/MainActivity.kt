package com.example.planificateurbudgetaire

import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.planificateurbudgetaire.model.Depense
import com.example.planificateurbudgetaire.model.Revenu
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {

    var liste_revenus = mutableListOf<Revenu>()
    var liste_depenses = mutableListOf<Depense>()
    val fichier_revenus = "sauvegarde_revenus"
    val fichier_depenses = "sauvegarde_depenses"

    public fun addRevenu(revenu: Revenu) {
        liste_revenus.add(revenu)
        var json_liste_revenus = Json.encodeToString(liste_revenus)
        openFileOutput(fichier_revenus, Context.MODE_PRIVATE).use {
            it.write(json_liste_revenus.toByteArray())
        }
    }

    public fun addDepense(depense: Depense) {
        liste_depenses.add(depense)
        var json_liste_depenses = Json.encodeToString(liste_depenses)
        openFileOutput(fichier_depenses, Context.MODE_PRIVATE).use {
            it.write(json_liste_depenses.toByteArray())
        }
    }
    
    public fun emptyFiles() {
        liste_revenus.clear()
        var json_liste_revenus = Json.encodeToString(liste_revenus)
        openFileOutput(fichier_revenus, Context.MODE_PRIVATE).use {
            it.write(json_liste_revenus.toByteArray())
        }
        liste_depenses.clear()
        var json_liste_depenses = Json.encodeToString(liste_depenses)
        openFileOutput(fichier_depenses, Context.MODE_PRIVATE).use {
            it.write(json_liste_depenses.toByteArray())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

        try {
            val importation_sauvegarde_revenus_string = openFileInput(fichier_revenus).bufferedReader().readText()
            liste_revenus = Json.decodeFromString(importation_sauvegarde_revenus_string)
        } catch (e: FileNotFoundException) {

        }

        try {
            val importation_sauvegarde_depenses_string = openFileInput(fichier_depenses).bufferedReader().readText()
            liste_depenses = Json.decodeFromString(importation_sauvegarde_depenses_string)
        } catch (e: FileNotFoundException) {

        }
    }
}
