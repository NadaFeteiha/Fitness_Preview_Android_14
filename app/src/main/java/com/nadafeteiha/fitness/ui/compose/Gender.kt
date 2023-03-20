package com.nadafeteiha.fitness.ui.compose

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nadafeteiha.fitness.R

@RequiresApi(34)
@Composable
fun Gender(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.gender),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        AppButton(
            onClick = { onClick(0) },
            textRes = R.string.female
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            onClick = { onClick(1) },
            textRes = R.string.male
        )
    }
}




@RequiresApi(34)
@Preview
@Composable
fun GenderPreview() {
    Gender(onClick = {})
}