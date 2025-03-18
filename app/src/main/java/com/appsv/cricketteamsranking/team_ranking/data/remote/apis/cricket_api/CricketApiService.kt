package com.appsv.cricketteamsranking.team_ranking.data.remote.apis.cricket_api

import com.appsv.cricketteamsranking.core.util.API_KEY
import com.appsv.cricketteamsranking.team_ranking.data.dto.team_ranking_dtos.TeamRankingDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CricketApiService{

    @GET("team-rankings")
    fun getTeamRankingByTypeAndGender(
        @Query("api_token") apiToken : String = API_KEY,
        @Query("filter[type]") type : String,
        @Query("filter[gender]") gender : String,
        // Response using ':' after providing request, return type is Call(interface)
        //after that we need to provide "<Type>" bec. Retro. don't known which data it fetching
        //it only know at that end-point(team-ranking) there is some data which it need to respond
        //So, we need to handle data format - need to create data classes with same name of the fields
        //create dto package
    ) : Call<TeamRankingDTO>

}