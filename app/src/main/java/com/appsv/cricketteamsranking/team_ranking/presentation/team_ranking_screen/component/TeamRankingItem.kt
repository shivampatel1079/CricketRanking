package com.appsv.cricketteamsranking.team_ranking.presentation.team_ranking_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.cricketteamsranking.R
import com.appsv.cricketteamsranking.team_ranking.data.dto.team_ranking_dtos.Ranking
import com.appsv.cricketteamsranking.team_ranking.domain.model.TeamRankingUI

@Composable
fun TeamItemPreview(modifier: Modifier = Modifier) {

    TeamRankingItem(
        teamRankingUI = TeamRankingUI(
            id = 1,
            type = "T20I",
            gender = "women",
            name = "India",
            image_path = "https://cdn.sportmonks.com/images/cricket/teams/10/10.png",
            ranking = Ranking(
                matches = 234,
                points = 2345,
                position = 1,
                rating = 345
            ),
            updateAt = "23 Oct, 2024"
        )
    )
}

@Composable
fun TeamRankingItem(
    modifier: Modifier = Modifier,
    teamRankingUI: TeamRankingUI
) {

    val mainColor = if (teamRankingUI.gender == "men") Color.Blue else colorResource(R.color.hard_pink)
    val itemBackground = colorResource(if (teamRankingUI.gender == "men") R.color.light_blue else R.color.light_pink)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, mainColor, RoundedCornerShape(10.dp))
            .background(itemBackground)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(R.drawable.sports_cricket_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.weight(0.8f).padding(3.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = teamRankingUI.name,
                    fontSize = if (teamRankingUI.ranking.position ==1) 40.sp else 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = mainColor,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.sports_cricket_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "Matches",
                            tint = Color.Red,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = teamRankingUI.ranking.matches.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    }

                    Row {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "Matches",
                            tint = Color.Magenta,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = teamRankingUI.ranking.rating.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Magenta
                        )
                    }

                    Row {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.star_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "Matches",
                            tint = Color.Blue,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = teamRankingUI.ranking.points.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                    }
                }
            }

            Text(
                modifier = Modifier.weight(0.2f),
                text = teamRankingUI.ranking.position.toString(),
                fontSize = if (teamRankingUI.ranking.position == 1) 60.sp else 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = mainColor
            )
        }
    }
}

val teamRankingList = listOf(

    TeamRankingUI(
        id = 1,
        type = "T20I",
        gender = "women",
        name = "Australia",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/1/1.png",
        ranking = Ranking(matches = 210, points = 2295, position = 2, rating = 330),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 2,
        type = "T20I",
        gender = "women",
        name = "England",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/2/2.png",
        ranking = Ranking(matches = 198, points = 2180, position = 3, rating = 320),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 3,
        type = "T20I",
        gender = "women",
        name = "India",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/10/10.png",
        ranking = Ranking(matches = 234, points = 2345, position = 1, rating = 345),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 4,
        type = "T20I",
        gender = "women",
        name = "South Africa",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/3/3.png",
        ranking = Ranking(matches = 190, points = 2070, position = 4, rating = 310),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 5,
        type = "T20I",
        gender = "women",
        name = "New Zealand",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/4/4.png",
        ranking = Ranking(matches = 185, points = 1950, position = 5, rating = 305),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 6,
        type = "T20I",
        gender = "women",
        name = "West Indies",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/5/5.png",
        ranking = Ranking(matches = 175, points = 1805, position = 6, rating = 295),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 7,
        type = "T20I",
        gender = "women",
        name = "Pakistan",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/6/6.png",
        ranking = Ranking(matches = 165, points = 1720, position = 7, rating = 285),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 8,
        type = "T20I",
        gender = "women",
        name = "Sri Lanka",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/7/7.png",
        ranking = Ranking(matches = 158, points = 1635, position = 8, rating = 275),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 9,
        type = "T20I",
        gender = "women",
        name = "Bangladesh",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/8/8.png",
        ranking = Ranking(matches = 150, points = 1520, position = 9, rating = 265),
        updateAt = "23 Oct, 2024"
    ),

    TeamRankingUI(
        id = 10,
        type = "T20I",
        gender = "women",
        name = "Ireland",
        image_path = "https://cdn.sportmonks.com/images/cricket/teams/9/9.png",
        ranking = Ranking(matches = 140, points = 1410, position = 10, rating = 255),
        updateAt = "23 Oct, 2024"
    ),

    )