package com.princebillygk.oauthrestapilogintest.models

import com.squareup.moshi.Json

data class District @ExperimentalUnsignedTypes constructor(
   @field:Json(name="district_id") val id: UInt,
   @field:Json(name="division_id") val divisionId: UInt,
   @field:Json(name="en_name") val enName:String,
   @field:Json(name="bn_name") val bnName: String,
   @field:Json(name="gps_coordinate") val gpsCoordinate: Pair<Double, Double>
)
