package com.appsv.cricketteamsranking.team_ranking.data.repository

import android.util.Log
import com.appsv.cricketteamsranking.core.data.remote.api.ApiRetrofitClient
import com.appsv.cricketteamsranking.team_ranking.data.dto.team_ranking_dtos.TeamRankingDTO
import com.appsv.cricketteamsranking.team_ranking.data.mappers.toTeamRankingUI
import com.appsv.cricketteamsranking.team_ranking.domain.model.TeamRankingUI
import com.appsv.cricketteamsranking.team_ranking.domain.repository.TeamRanking
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// In this repository we access data

class TeamRankingImpl : TeamRanking {
    // here interface fun. all are not sus.fun. bec we doing api call and ye background
    // thread me ho, and no bec use using 'Call with enqueue' which specify it uses
    // asynchronously, and in "Response with execute" its synchronously but have to use sus.fun
    override fun getTeamRankingByTypeAndGender(type: String, gender: String): Flow<List<TeamRankingUI>> = callbackFlow {

        val teamRankingData = ApiRetrofitClient.cricketApiRetrofitClient.getTeamRankingByTypeAndGender(
            type = type,
            gender = gender
        )
        //var result = emptyList<TeamRankingUI>()

        val callBack = object : Callback<TeamRankingDTO> {
            override fun onResponse(
                call: Call<TeamRankingDTO>,
                response: Response<TeamRankingDTO>
            ) {
                try {
                    if (response.isSuccessful){
                        val data = response.body()?.toTeamRankingUI()
                        //result = data!!
                        trySend(data!!)
                    }
                }
                catch (e: Exception){
                    close()
                }
            }

            override fun onFailure(call: Call<TeamRankingDTO>, t: Throwable) {
                close()
            }

        }
        teamRankingData.enqueue(
            callBack
        )
        //return result
        awaitClose{}
    }

}
