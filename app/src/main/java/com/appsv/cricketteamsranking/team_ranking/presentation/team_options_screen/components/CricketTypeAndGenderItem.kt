package com.appsv.cricketteamsranking.team_ranking.presentation.team_options_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp,mainColor, RoundedCornerShape(10.dp))
            .background(itemBackground)
            .clickable { }
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = format.cricketFormat,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = mainColor
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(menOrWomenIcon),
                    contentDescription = "",
                    tint = mainColor
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = if (format.isMen) "Men" else "Women",
                    fontSize = 16.sp,
                    color = mainColor
                )
            }
        }

    }
}