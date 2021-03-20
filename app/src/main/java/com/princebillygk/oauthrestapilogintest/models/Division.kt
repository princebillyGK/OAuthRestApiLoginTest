package com.princebillygk.oauthrestapilogintest.models

import com.squareup.moshi.Json

data class Division @ExperimentalUnsignedTypes constructor(
    @field:Json(name = "division_id") val id: UInt,
    @field:Json(name = "en_name") val enName: String,
    @field:Json(name ="bn_name") val bnName: String,
)
