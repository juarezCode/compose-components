package com.ju4r3z.compcatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ju4r3z.compcatalogo.ui.theme.CompCatalogoTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        MyTextFieldOutlined()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompCatalogoTheme {
        MyTextFieldOutlined()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("Jose") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "label") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Green
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText,
        onValueChange = {
            myText = if (it.contains("a")) it.replace("a", "")
            else it
        },
        label = { Text(text = "Introduce tu nombre") }
    )
}

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("Jose") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "esto es un string")
        Text(text = "esto es un string", color = Color.Blue)
        Text(text = "esto es un string", fontWeight = FontWeight.Bold)
        Text(text = "esto es un string", fontFamily = FontFamily.Cursive)
        Text(
            text = "esto es un string",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "esto es un string",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(text = "esto es un string", fontSize = 30.sp)
    }
}