package com.appsv.cricketteamsranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appsv.cricketteamsranking.core.presentation.ui.theme.CricketTeamsRankingTheme
import com.appsv.cricketteamsranking.team_ranking.data.repository.TeamRankingUIImpl
import com.appsv.cricketteamsranking.team_ranking.domain.model.TeamRankingUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CricketTeamsRankingTheme {
                TeamRankingUIImpl().getTeamRankingByTypeAndGender("T20I","women")
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CricketTeamsRankingTheme {
        Greeting("Android")
    }
}