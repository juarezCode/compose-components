package com.ju4r3z.compcatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyBasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var position by remember { mutableStateOf(0f) }
        Slider(value = position, onValueChange = { position = it })
        Text(text = position.toString())
    }
}


@Composable
fun MyAdvancedSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var position by remember { mutableStateOf(0f) }
        Slider(
            value = position,
            onValueChange = { position = it },
            valueRange = 0f..10f,
            steps = 9,
            enabled = false
        )
        Text(text = position.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun MyRangeSlider() {
    Column {
        var currentRange by remember { mutableStateOf(0f..10f) }

        RangeSlider(
            value = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..40f,
            steps = 9
        )
        Text(text = "valor inicial ${currentRange.start}")
        Text(text = "valor final ${currentRange.endInclusive}")
    }

}