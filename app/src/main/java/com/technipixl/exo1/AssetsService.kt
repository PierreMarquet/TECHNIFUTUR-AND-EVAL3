package com.technipixl.exo1

import com.technipixl.exo1.marvel.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AssetsService {
    @GET("/v1/public/characters")
    suspend fun assets(
        @Query("apikey", encoded = true) apikey: String,
        @Query("ts",encoded = true) ts: Long,
        @Query("hash", encoded = true) hash: String,
        @Query("limit", encoded = true) limit: Int
    ): Response<CharacterDataWrapper>

}