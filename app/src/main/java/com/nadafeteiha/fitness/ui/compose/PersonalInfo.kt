package com.nadafeteiha.fitness.ui.compose

import android.app.GrammaticalInflectionManager
import android.content.res.Configuration
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nadafeteiha.fitness.R

@RequiresApi(34)
@Composable
fun PersonalInfo(
    modifier: Modifier = Modifier,
    grammaticalInflectionManager: GrammaticalInflectionManager
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = stringResource(id = R.string.welcom),
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.routine),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        val composition by rememberLottieComposition(
            if (grammaticalInflectionManager.applicationGrammaticalGender == Configuration.GRAMMATICAL_GENDER_FEMININE) {
                LottieCompositionSpec.RawRes(R.raw.female)
            } else {
                LottieCompositionSpec.RawRes(R.raw.male)
            }
        )

        LottieAnimation(
            composition,
            alignment = Alignment.TopCenter,
            iterations = LottieConstants.IterateForever,
        )
    }
}