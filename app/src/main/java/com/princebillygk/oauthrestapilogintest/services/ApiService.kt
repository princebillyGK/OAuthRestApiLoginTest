package com.princebillygk.oauthrestapilogintest.services

import com.princebillygk.oauthrestapilogintest.requests.authentication.google.GoogleOauthSignInRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {





    @POST("oauth/google")
    fun googleAuthLogin(@Body request: GoogleOauthSignInRequest) {

    }




}