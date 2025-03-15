package com.appsv.cricketteamsranking.team_ranking.data.dto.team_ranking_dtos

data class Ranking(
    val matches: Int,
    val points: Int,
    val position: Int,
    val rating: Int
)