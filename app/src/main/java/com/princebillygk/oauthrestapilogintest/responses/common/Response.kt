package com.princebillygk.oauthrestapilogintest.responses.common

import com.squareup.moshi.Json






abstract class Response {
    abstract val statusCode: Int
    abstract val errCode: Int?
    abstract val developerMessage: String?
    abstract val user_message: String?
    abstract val moreInfo: String?
}