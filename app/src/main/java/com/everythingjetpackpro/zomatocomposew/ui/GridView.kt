package com.everythingjetpackpro.zomatocomposew.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview


@Composable
fun <T> LazyGridFor(
    data: List<T>,
    colSize: Int = 1,
    itemContent: @Composable BoxScope.(T) -> Unit
) {
    val columns = data.windowed(colSize, colSize, true)
    LazyRowFor(columns) { row ->
        Column(modifier = Modifier.fillMaxWidth(3 / 4f)) {
            val weight = 1f / colSize
            for (item in row) {
                Box() {
                    itemContent(item)
                }
            }
            if (row.size < colSize) {
                for (i in 0 until (colSize - row.size)) {
                    Box(modifier = Modifier.weight(weight))
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    LazyGridFor(
//        listOf("Hello", "Hello", "Hello", "Hello", "Hello", "Hello", "Hello"),
//        2
//    ) { item ->
//        RestaurantCardSmall("Android") {
//
//        }
//    }
//
//}