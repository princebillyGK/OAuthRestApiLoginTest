package com.princebillygk.oauthrestapilogintest.models

import com.squareup.moshi.Json
import java.sql.Timestamp
import java.time.Year

enum class Sex { MALE, FEMALE, OTHER }

data class User @ExperimentalUnsignedTypes constructor(
    @field:Json(name = "id") val id: UInt,
    @field:Json(name = "first_name") val firstName: String,
    @field:Json(name = "last_name") val lastName: String,
    @field:Json(name = "phone") val phone: String,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "sex") val sex: Sex,
    @field:Json(name = "birth_year") val birthYear: Year,
    @field:Json(name = "address") val address: String,
    @field:Json(name = "district_id") val districtId: Int,
    @field:Json(name = "division_id") val divisionId: Int,
    @field:Json(name = "photo_url") val photoUrl: String?,
    @field:Json(name = "joined_at") val joinedAt: Timestamp,
    @field:Json(name = "updated_at") val updatedAt: Timestamp
)

