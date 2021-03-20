package com.princebillygk.oauthrestapilogintest.requests.user

import com.princebillygk.oauthrestapilogintest.models.User
import com.squareup.moshi.Json


data class CreateNewUserRequest (
    @field:Json(name="otp_token") val otpCode: String?,
    @field:Json(name="google_id_token") val googleIdToken: String?,

    //User Information
    @field:Json(name="user") val user: User
)

