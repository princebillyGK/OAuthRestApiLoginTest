package com.princebillygk.oauthrestapilogintest.api.responses.common

import com.squareup.moshi.Json

interface Response {
    @Json(name="status_code") val statusCode: Int
    @Json(name="error_code") val errCode: Int?
    @Json(name="developer_message") val developerMessage: String?
    @Json(name="user_message") val userMessage: String?
}