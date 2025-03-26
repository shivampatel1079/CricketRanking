package com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen

import com.appsv.cricketteamsranking.team_ranking.domain.model.TeamRankingUI
import com.appsv.cricketteamsranking.team_ranking.domain.repository.TeamRanking


data class TeamRankingState(
    val isLoading : Boolean = true,
    val teamRankingList: List<TeamRankingUI> = emptyList()

)
