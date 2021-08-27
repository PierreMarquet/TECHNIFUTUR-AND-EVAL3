package com.technipixl.exo1.marvel
import com.google.gson.annotations.SerializedName

data class CharacterDataContainer(
    @SerializedName("count")
    val count: String?,
    @SerializedName("limit")
    val limit: String?,
    @SerializedName("offset")
    val offset: String?,
    @SerializedName("results")
    val results: List<Character>?,
    @SerializedName("total")
    val total: String?
)