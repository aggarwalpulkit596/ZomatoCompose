package com.everythingjetpackpro.zomatocomposew.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.everythingjetpackpro.zomatocomposew.R

@Composable
fun RestaurantCardSmall(
    name: String, onClick: () -> Unit
) {
    val image = imageResource(R.drawable.burger)

    Row(
        modifier = Modifier.padding(4.dp).clickable(onClick = onClick)
    ) {
        val imageModifier = Modifier
            .size(48.dp)
            .clip(shape = shapes.small)


        Image(
            image, modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                "Wat a Burger",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 12.sp)
            )
            Text(
                "27 mins",
                maxLines = 1,
                color = Color.Gray,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 8.sp)
            )

            Text(
                "pro extra 20% OFF",
                maxLines = 1,
                color = Color.Red,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 8.sp)
            )


            Text(
                "40% OFF",
                maxLines = 1,
                color = Color.Blue,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 8.sp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestaurantCardSmall("Android") {
    }
}