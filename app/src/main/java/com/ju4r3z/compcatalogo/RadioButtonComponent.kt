package com.ju4r3z.compcatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButtonList(optionSelected: String, onRadioSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = optionSelected == "option1",
                onClick = { onRadioSelected("option1") }
            )
            Text(text = "option1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = optionSelected == "option2",
                onClick = { onRadioSelected("option2") }
            )
            Text(text = "option2")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false,
            onClick = { },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Blue
            )
        )
        Text(text = "radio")
    }

}