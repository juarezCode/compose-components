package com.ju4r3z.compcatalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MyTriStateCheckBox() {
    var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(
        state = state,
        onClick = {
            state = when (state) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        }
    )
}

@Composable
fun getOptions(titles: List<String>): List<CheckBoxInfo> {
    return titles.map {
        var state by rememberSaveable { mutableStateOf(false) }

        CheckBoxInfo(
            title = it,
            checked = state,
            onCheckedChange = { newState -> state = newState }
        )
    }
}


data class CheckBoxInfo(
    val title: String,
    var checked: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)

@Composable
fun MyCheckBoxWithText(checkBoxInfo: CheckBoxInfo) {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkBoxInfo.checked,
            onCheckedChange = { checkBoxInfo.onCheckedChange(!checkBoxInfo.checked) },
            modifier = Modifier.padding(0.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = checkBoxInfo.title)
    }
}


@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Checkbox(
        checked = state,
        onCheckedChange = {
            state = !state
        },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green,
            checkmarkColor = Color.Black
        )
    )
}