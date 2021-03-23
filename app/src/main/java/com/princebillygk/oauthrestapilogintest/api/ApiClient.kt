package com.princebillygk.oauthrestapilogintest.api

import com.princebillygk.oauthrestapilogintest.api.services.AnondoBazarService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient{
    private lateinit var anondoBazarService: AnondoBazarService
    fun getAnondoBazarService(): AnondoBazarService {
        if (!ApiClient::anondoBazarService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.107:8080/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            anondoBazarService = retrofit.create(AnondoBazarService::class.java)
        }
        return anondoBazarService
    }
}
