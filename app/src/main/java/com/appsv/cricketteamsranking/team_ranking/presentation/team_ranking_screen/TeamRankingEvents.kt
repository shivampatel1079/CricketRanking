package com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen

sealed class TeamRankingEvents {

    data class GetTeamRankingByTypeAndGender(val type:String , val gender: String) : TeamRankingEvents()
}