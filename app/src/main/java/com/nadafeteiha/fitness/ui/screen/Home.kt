package com.nadafeteiha.fitness.ui.screen

import android.app.GrammaticalInflectionManager
import android.content.res.Configuration
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ComponentActivity
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.nadafeteiha.fitness.ui.compose.Gender
import com.nadafeteiha.fitness.ui.compose.PersonalInfo

@RequiresApi(34)
@Composable
fun Home() {
    HomeContent(
        grammaticalInflectionManager = LocalContext.current.applicationContext?.getSystemService(
            ComponentActivity.GRAMMATICAL_INFLECTION_SERVICE
        ) as GrammaticalInflectionManager
    )
}


@OptIn(ExperimentalPagerApi::class)
@RequiresApi(34)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    grammaticalInflectionManager: GrammaticalInflectionManager
) {

    val pagerState = rememberPagerState(initialPage = 0)
    val genderSelection = remember { mutableStateOf(false) }

    HorizontalPager(count = 3, state = pagerState) { page ->
        if (page == 0) {
            Gender(onClick = { gender ->
                genderSelection.value = true
                val configuration = if (gender == 1) {
                    Configuration.GRAMMATICAL_GENDER_MASCULINE
                } else {
                    Configuration.GRAMMATICAL_GENDER_FEMININE
                }
                grammaticalInflectionManager.setRequestedApplicationGrammaticalGender(configuration)
            })
        } else if (page == 1) {
            PersonalInfo()
        }
    }

    LaunchedEffect(key1 = genderSelection.value) {
        if (genderSelection.value) {
            pagerState.scrollToPage(pagerState.currentPage + 1)
        }
    }
}

@RequiresApi(34)
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}