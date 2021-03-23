package com.princebillygk.oauthrestapilogintest.api.requests.otp

import com.squareup.moshi.Json

data class OtpRequest(
    @field:Json(name="phone") val phone: String
)
