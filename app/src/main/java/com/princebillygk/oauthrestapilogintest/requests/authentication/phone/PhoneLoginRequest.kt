package com.princebillygk.oauthrestapilogintest.requests.authentication.phone

import com.squareup.moshi.Json

data class PhoneLoginRequest(
    @field:Json(name="phone") val phone :String,
    @field:Json(name="password") val password :String,
)
