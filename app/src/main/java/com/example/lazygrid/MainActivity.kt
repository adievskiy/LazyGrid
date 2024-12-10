package com.example.lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazygrid.ui.theme.LazyGridTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyVerticalGrid()
        }
    }
}

@Composable
fun LazyVerticalGrid() {
    val bookList = listOf(
        Books(R.drawable.part_01),
        Books(R.drawable.part_02),
        Books(R.drawable.part_03),
        Books(R.drawable.part_04),
        Books(R.drawable.part_05),
        Books(R.drawable.part_06),
        Books(R.drawable.part_07)
    )
    val gridItems = List(100) { bookList.random() }
    androidx.compose.foundation.lazy.grid.LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.Center,
        ) {
        items(gridItems) {item ->
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 150.dp, height = 250.dp)
                    .padding(3.dp)
            )
        }
    }
}