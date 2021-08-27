package com.technipixl.exo1

import com.technipixl.exo1.marvel.CharacterDataContainer
import com.technipixl.exo1.marvel.CharacterDataWrapper
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class AssetsServiceImpl {

    fun getRetrofit(): Retrofit {
        val okBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            callTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }
        return  Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
    }



    suspend fun getAssets(): Response<CharacterDataWrapper> {

        val uniqueTs = Date().time

        return getRetrofit().create(AssetsService::class.java).assets(
            apikey = "e3ae1478d54d4ebecc43d5829ef7c2e3",
            ts = uniqueTs,
            hash = HashGenerator.generateHash(
                uniqueTs,
                "203ef302e7e2f26a107646c529ebbc7063260e0b",
                "e3ae1478d54d4ebecc43d5829ef7c2e3"
            )!!,
            limit = 100
        )
    }
}