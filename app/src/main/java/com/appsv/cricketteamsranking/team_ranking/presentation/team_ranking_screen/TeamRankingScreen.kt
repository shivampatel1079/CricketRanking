package com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.cricketteamsranking.R
import com.appsv.cricketteamsranking.core.presentation.app_navigation.TeamRankingScreen
import com.appsv.cricketteamsranking.core.presentation.component.AppToolBar
import com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen.component.TeamRankingItem
import com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen.component.teamRankingList

@Composable
fun TeamRankingScreen(
    isMen : String = "men"
) {
    Column(
        modifier = Modifier.statusBarsPadding(),
    ) {

        val boxGradientBg = if (isMen == "men"){
            listOf(colorResource(R.color.light_blue), colorResource(R.color.light_pink))
        } else {
           listOf(colorResource(R.color.light_pink), colorResource(R.color.light_blue))
        }
        AppToolBar(
            title = "Team Ranking",
            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = boxGradientBg
                    )
                ),
        ) {
            Column {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    contentPadding = PaddingValues(5.dp)
                ) {
                    item{
                        Spacer(Modifier.height(10.dp))
                        LastUpdatedText()
                        Spacer(Modifier.height(10.dp))
                    }

                    items(teamRankingList, key = {it.id}){
                        TeamRankingItem(teamRankingUI = it)
                    }
                }
            }
        }
    }
}

@Composable
fun LastUpdatedText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = ImageVector.vectorResource(R.drawable.baseline_access_time_24),
            contentDescription = "",
            tint = colorResource(R.color.half_black)
        )
        Spacer(Modifier.width(5.dp))
        Text(
            text = "Last Updated at",
            fontSize = 15.sp,
            color = colorResource(R.color.half_black),
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = "24 Oct,2024",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}