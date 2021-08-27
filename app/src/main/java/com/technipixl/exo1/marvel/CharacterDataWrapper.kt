package com.technipixl.exo1.marvel
import com.google.gson.annotations.SerializedName

data class CharacterDataWrapper(
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("data")
    val `data`: CharacterDataContainer?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("status")
    val status: String?
)