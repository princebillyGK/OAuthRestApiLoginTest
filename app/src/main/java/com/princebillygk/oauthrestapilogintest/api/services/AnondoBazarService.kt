package com.princebillygk.oauthrestapilogintest.api.services

import com.princebillygk.oauthrestapilogintest.api.requests.otp.OtpRequest
import com.princebillygk.oauthrestapilogintest.api.responses.otp.OtpRequestResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST



interface AnondoBazarService {
    @POST("otp/")
    suspend fun requestOtp (@Body request: OtpRequest): Response<OtpRequestResponse>
}