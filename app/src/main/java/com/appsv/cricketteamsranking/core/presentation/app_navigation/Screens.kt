package com.appsv.cricketteamsranking.core.presentation.app_navigation

import kotlinx.serialization.Serializable


@Serializable
data object TeamOptionScreen

@Serializable
data class TeamRankingScreen(
    val type : String,
    val gender : String
)