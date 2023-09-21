package com.ju4r3z.compcatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 12.dp,
        backgroundColor = Color.White,
        border = BorderStroke(2.dp, Color.Gray)
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(text = "text1")
            Text(text = "text1")
            Text(text = "text1")
        }
    }
}