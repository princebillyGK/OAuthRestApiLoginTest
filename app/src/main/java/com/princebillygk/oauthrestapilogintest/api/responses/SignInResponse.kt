package com.princebillygk.oauthrestapilogintest.api.responses

import com.princebillygk.oauthrestapilogintest.models.User
import com.princebillygk.oauthrestapilogintest.api.responses.common.Response
import com.squareup.moshi.Json


data class SignInResponse(
    @field:Json(name="status_code") override val statusCode: Int,
    @field:Json(name="error_code") override val errCode: Int?,
    @field:Json(name="developer_message") override val developerMessage: String?,
    @field:Json(name="user_message") override val userMessage: String?,

    @field:Json(name="jwt_token") val authToken: String,
    @field:Json(name="user") val user:User
):Response

