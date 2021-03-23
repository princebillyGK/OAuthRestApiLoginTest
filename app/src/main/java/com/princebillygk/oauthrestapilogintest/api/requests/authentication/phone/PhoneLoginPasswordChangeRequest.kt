package com.princebillygk.oauthrestapilogintest.api.requests.authentication.phone

import com.squareup.moshi.Json

data class PhoneLoginPasswordChangeRequest (
    @field:Json(name="otp_token") val otpCode: String,
    @field:Json(name="new_password") val newPassword: String,
    @field:Json(name="new_password_confirmation") val newPasswordConfirmation: String,
)