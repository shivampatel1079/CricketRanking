package com.appsv.cricketteamsranking.core.presentation.app_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.appsv.cricketteamsranking.core.presentation.component.TeamOptionScreen

@Composable
fun SetUpNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = TeamOptionScreen){

        composable<TeamOptionScreen>{
            TeamOptionScreen(){type,gender ->
                navController.navigate(TeamRankingScreen(
                    type = type,
                    gender = gender
                ))
            }
        }

        composable<TeamRankingScreen> {
            val args = it.toRoute<TeamRankingScreen>()
            TeamRankingScreenn(args.type, args.gender)
        }
    }
}

@Composable
fun TeamRankingScreenn(
    type: String,
    gender : String
    )
{
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Type $type, Gender $gender")
    }
}