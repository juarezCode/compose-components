package com.ju4r3z.compcatalogo

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ju4r3z.compcatalogo.model.SuperHero
import kotlinx.coroutines.launch


@Composable
fun SimpleRecyclerView() {
    val myList = listOf("uno", "dos", "tres")
    LazyColumn {
        item {
            Text(text = "Footer")
        }
        items(7) {
            Text(text = "este es el item $it")
        }
        items(myList) {
            Text(text = "some item $it")
        }
        item {
            Text(text = "Footer")
        }
    }
}

@Composable
fun RVSuperHero() {
    val context = LocalContext.current

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) {
            ItemHero(
                hero = it,
                onItemSelected = { hero ->
                    Toast.makeText(context, hero.name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RVStickySuperHero() {
    val context = LocalContext.current
    val superHeroMap: Map<String, List<SuperHero>> = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHeroMap.forEach { (publisher, heroes) ->
            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            items(heroes) {
                ItemHero(
                    hero = it,
                    onItemSelected = { hero ->
                        Toast.makeText(context, hero.name, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Composable
fun RVSuperHeroWithSpecialControls() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) {
                ItemHero(
                    hero = it,
                    onItemSelected = { hero ->
                        Toast.makeText(context, hero.name, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
        val showButton by remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }

        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Iam a button")
            }
        }

    }
}

@Composable
fun RVGridSuperHero() {
    val context = LocalContext.current

    LazyVerticalGrid(
        modifier = Modifier.background(Color.White),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(getSuperHeroes()) {
                ItemHero(
                    hero = it,
                    onItemSelected = { hero ->
                        Toast.makeText(context, hero.name, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        })
}

@Composable
fun ItemHero(hero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemSelected(hero)
            },
        backgroundColor = Color.White
    ) {
        Column {
            Image(
                painter = painterResource(id = hero.photo),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = hero.name,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black
            )
            Text(
                text = hero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp,
                color = Color.Black
            )
            Text(
                text = hero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                color = Color.Black
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("spiderman", "Peter", "marvel", R.drawable.spiderman),
        SuperHero("wolverine", "james", "marvel", R.drawable.logan),
        SuperHero("batman", "bruce", "DC", R.drawable.batman),
        SuperHero("thor", "thor", "marvel", R.drawable.thor),
        SuperHero("Flash", "Jay", "DC", R.drawable.flash),
        SuperHero("Green lantern", "Alan", "DC", R.drawable.green_lantern),
        SuperHero("wonder woman", "Diana", "DC", R.drawable.wonder_woman),
    )
}