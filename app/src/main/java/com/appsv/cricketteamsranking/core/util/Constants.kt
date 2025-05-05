package com.appsv.cricketteamsranking.core.util

import com.appsv.cricketteamsranking.team_ranking.domain.model.CricketFormat

const val CRICKET_API_BASE_URL = "https://cricket.sportmonks.com/api/v2.0/"
const val API_KEY = "Vx25vyxe0rxondBINQSllSGQcFE6UdbdX4XYNslrcOaIkD3ezvzC8JPNce8v"

val cricketTypeAndGender = listOf(
    CricketFormat(
        cricketFormat = "T20I",
        isMen = true
    ),
    CricketFormat(
        cricketFormat = "T20I",
        isMen = false
    ),
    CricketFormat(
        cricketFormat = "ODI",
        isMen = false
    ),
    CricketFormat(
        cricketFormat = "ODI",
        isMen = true
    ),
    CricketFormat(
        cricketFormat = "TEST",
        isMen = true
    ),
    CricketFormat(
        cricketFormat = "TEST",
        isMen = false
    ),
)