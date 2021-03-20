package com.princebillygk.oauthrestapilogintest.responses.otp

import com.princebillygk.oauthrestapilogintest.responses.common.Response
import com.squareup.moshi.Json


data class OtpRequestResponse(
    override val statusCode: Int,
    override val errCode: Int?,
    override val developerMessage: String?,
    override val user_message: String?,
    override val moreInfo: String?,

    @field:Json(name = "otp_session_id") val otpSessionId: String,
    @field:Json(name = "otp_session_expires_in") val otpSessionExpiresIn: Int
) : Response()