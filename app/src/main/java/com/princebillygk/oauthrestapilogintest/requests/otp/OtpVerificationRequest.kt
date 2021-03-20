package com.princebillygk.oauthrestapilogintest.requests.otp

import com.squareup.moshi.Json

data class OtpVerificationRequest(
    @field:Json(name="otp_session_id") val otpSessionId: String,
    @field:Json(name="otp_code") val otpCode: String
)
