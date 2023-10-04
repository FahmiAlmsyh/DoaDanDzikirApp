package com.rival.belajardoadandzikirapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtikelModel(
    val imageArtikel: Int,
    val titleArtikel: String,
    val descriptionArtikel: String
) : Parcelable
