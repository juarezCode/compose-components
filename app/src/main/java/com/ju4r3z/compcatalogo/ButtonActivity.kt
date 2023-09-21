package com.ju4r3z.compcatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ju4r3z.compcatalogo.ui.theme.CompCatalogoTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompCatalogoTheme {
                // A surface container using the 'background' color from the theme
                var optionSelected by rememberSaveable { mutableStateOf("option1") }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val myOptions = getOptions(listOf("Jose", "Roberto", "Juarez"))

                    Column {
//                        MyDialog()
                    }
                }
            }
        }
    }
}

@Composable
fun MyButtonExample() {
    var enabled by remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        Button(
            onClick = {
                enabled = false
            },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Green),
            border = BorderStroke(5.dp, Color.Red),
            enabled = enabled
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = {
                enabled = false
            },
            enabled = enabled
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { }) {
            Text(text = "Hola")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    CompCatalogoTheme {
        MyButtonExample()
    }
}