package com.ju4r3z.compcatalogo

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldComponent() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("click on $it")
                    }
                },
                onClickDrawer = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomBar() },
        floatingActionButton = { MyFAB() },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            MyDrawer(
                onClose = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        }

    ) {

    }
}

@Composable
fun MyTopAppBar(onClick: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "appbar")
        },
        backgroundColor = Color.Red,
        navigationIcon = {
            IconButton(onClick = onClickDrawer) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onClick("search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "")
            }
            IconButton(onClick = { onClick("warning") }) {
                Icon(imageVector = Icons.Filled.Warning, contentDescription = "")
            }
        }
    )
}

@Composable
fun MyBottomBar() {
    var selectedItem by remember { mutableStateOf(0) }

    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(
            selected = selectedItem == 0,
            onClick = { selectedItem = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = selectedItem == 1,
            onClick = { selectedItem = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Fav"
                )
            },
            label = { Text(text = "Fav") }
        )
        BottomNavigationItem(
            selected = selectedItem == 2,
            onClick = { selectedItem = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person"
                )
            },
            label = { Text(text = "Person") }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.Yellow,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add icon")
    }
}

@Composable
fun MyDrawer(onClose: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClose() }
        )
        Text(
            text = "Segunda Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Tercera Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}