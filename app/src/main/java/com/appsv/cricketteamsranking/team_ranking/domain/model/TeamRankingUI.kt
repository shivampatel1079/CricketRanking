package com.appsv.cricketteamsranking.team_ranking.domain.model

import com.appsv.cricketteamsranking.team_ranking.data.dto.team_ranking_dtos.Ranking

data class TeamRankingUI(
    val id : Int,
    val type : String,
    val gender : String,
    val updateAt : String,
    val name : String,
    val code : String,
    val image_path : String,
    val ranking : Ranking,

)
