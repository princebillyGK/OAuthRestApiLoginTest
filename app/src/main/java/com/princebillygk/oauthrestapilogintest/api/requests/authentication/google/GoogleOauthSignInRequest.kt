package com.princebillygk.oauthrestapilogintest.api.requests.authentication.google

import com.squareup.moshi.Json

data class GoogleOauthSignInRequest(
    @field:Json(name="google_id_token") val idToken: String
)
