package com.technipixl.exo1.marvel
import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String?,
    @SerializedName("path")
    val path: String?
)