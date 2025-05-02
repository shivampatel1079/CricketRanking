package com.appsv.cricketteamsranking.team_ranking.presentation.team_options_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.appsv.cricketteamsranking.R
import com.appsv.cricketteamsranking.team_ranking.domain.model.CricketFormat


@Preview
@Composable
fun CricketFormatItems(
    format: CricketFormat=
        CricketFormat(
            cricketFormat = "T20I",
            isMen = true
        )
){
    val mainColor = if (format.isMen) Color.Blue else colorResource(R.color.hard_pink)
    val itemBackground = colorResource(if (format.isMen)R.color.light_blue1 else R.color.light_pink1)
    val menOrWomenIcon = if (format.isMen) R.drawable.male_24dp_e8eaed_fill0_wght400_grad0_opsz24 else R.drawable.female_24dp_e8eaed_fill0_wght400_grad0_opsz24
}