package com.appsv.cricketteamsranking.core.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.cricketteamsranking.R

@Preview
@Composable
fun TeamOptionScreen(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier.statusBarsPadding(),
    ) {
        AppToolBar(
            title = "Team Options"
        )

        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Blue, colorResource(R.color.hard_pink))
                    )
                ),
            contentAlignment = Alignment.Center
        ){

            Column {
                RankingMarqueeText()

                Spacer(Modifier.height(10.dp))

                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp),
                    verticalItemSpacing = 20.dp,
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    items(cricketTypeAndGender){
                        CricketFormatItems(it)
                    }
                }
            }
        }
    }
}

@Composable
fun RankingMarqueeText(modifier: Modifier = Modifier){

    Text(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .basicMarquee(iterations = 5, velocity = 60.dp
            ),
        color = Color.White, 
        text = buildAnnotatedString {

            append("Latest Ranking of ")

            withStyle(
                style = SpanStyle(
                    color = Color.Cyan,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline ,
                    fontWeight = FontWeight.Bold
                )
            ){
                append("Men's ")
            }

            append("and ")

            withStyle(
                style = SpanStyle(
                    color = colorResource(R.color.light_pink1),
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline ,
                    fontWeight = FontWeight.Bold
                )
            ){
                append("Women's ")
            }
            append(" International Cricket Teams.")
        }
    )
}