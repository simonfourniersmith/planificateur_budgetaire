package com.example.planificateurbudgetaire.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Revenu(
    val categorie: String,
    val frequence: String,
    val somme: Float
): Parcelable