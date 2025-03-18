package com.appsv.cricketteamsranking.team_ranking.domain.repository

import com.appsv.cricketteamsranking.team_ranking.domain.model.TeamRankingUI

//after setting up from where to get data, and to access these data we create repository
interface TeamRanking {

    //fun name same as another interface for CricketApi
    fun getTeamRankingByTypeAndGender(
        type : String,
        gender : String

        // here we know that return type will be List but which data class type, it will
        //be of UI(jo fields user ko show karna hai), so mapping work()
    ) : List<TeamRankingUI>
}