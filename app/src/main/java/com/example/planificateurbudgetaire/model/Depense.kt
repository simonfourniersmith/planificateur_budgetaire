package com.example.planificateurbudgetaire.model

import kotlinx.serialization.Serializable

@Serializable
data class Depense(
    val categorie: String,
    val frequence: String,
    val somme: Float
)