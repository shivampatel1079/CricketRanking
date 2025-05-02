package com.appsv.cricketteamsranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.appsv.cricketteamsranking.core.presentation.component.TeamOptionScreen
import com.appsv.cricketteamsranking.core.presentation.ui.theme.CricketTeamsRankingTheme
import com.appsv.cricketteamsranking.team_ranking.data.repository.TeamRankingImpl
import com.appsv.cricketteamsranking.team_ranking.domain.model.TeamRankingUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color(0xFFAC009B).toArgb()
            )
        )
        setContent {
            CricketTeamsRankingTheme {
                TeamOptionScreen()
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