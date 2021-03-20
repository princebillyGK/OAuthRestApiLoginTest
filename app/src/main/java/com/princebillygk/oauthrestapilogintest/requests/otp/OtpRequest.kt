package com.princebillygk.oauthrestapilogintest.requests.otp

import com.squareup.moshi.Json

data class OtpRequest(
    @field:Json(name="") val phone: String
)
