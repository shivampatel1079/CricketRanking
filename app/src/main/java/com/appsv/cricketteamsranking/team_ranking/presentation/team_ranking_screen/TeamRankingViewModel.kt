package com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.cricketteamsranking.team_ranking.data.repository.TeamRankingImpl
import com.appsv.cricketteamsranking.team_ranking.domain.repository.TeamRanking
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamRankingViewModel : ViewModel() {

    private val teamRankingRepository : TeamRanking = TeamRankingImpl()

    private val _state = MutableStateFlow(TeamRankingState())
    val state = _state.asStateFlow() // only read,cant modify

    fun onEvent(events: TeamRankingEvents){
        when(events){
            is TeamRankingEvents.GetTeamRankingByTypeAndGender -> {
                getTeamRankingByTypeAndGender(events.type, events.gender)
            }
        }
    }

    private fun getTeamRankingByTypeAndGender(type : String, gender : String){

        viewModelScope.launch {
            teamRankingRepository.getTeamRankingByTypeAndGender(type,gender) .collect{teamRankingList->
                _state.value = state.value.copy(
                    isLoading = false,
                    teamRankingList = teamRankingList
                )

            }
            // we can get type,gender by creating events.
            //we have used callbackFlow -> .collect
            //at first we didn't make this fun as suspend bec we don't need coroutine to call this fun.
            //but we need to correct flow by 'collect' which is a sus.fun, so used viewModelScope
        }

    }
}