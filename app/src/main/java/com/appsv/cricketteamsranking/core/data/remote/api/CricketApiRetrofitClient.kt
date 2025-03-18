package com.appsv.cricketteamsranking.core.data.remote.api

import com.appsv.cricketteamsranking.core.util.CRICKET_API_BASE_URL
import com.appsv.cricketteamsranking.team_ranking.data.remote.apis.cricket_api.CricketApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// another best practise that we keep it inside object bec only singleton instance can
// be created , so only one object

object ApiRetrofitClient{
    val cricketApiRetrofitClient by lazy {
        Retrofit.Builder()
            .baseUrl(CRICKET_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CricketApiService::class.java)
    }
}




