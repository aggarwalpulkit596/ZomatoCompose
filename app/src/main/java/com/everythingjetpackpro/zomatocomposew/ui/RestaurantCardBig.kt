package com.everythingjetpackpro.zomatocomposew.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
fun RestaurantCardBig(
    name: String, onClick: () -> Unit
) {
    val image = imageResource(R.drawable.burger)
    Card(
        modifier = Modifier.clip(
            shape = RoundedCornerShape(8.dp),
        ).padding(8.dp)

    ) {
        val imageModifier = Modifier
            .height(120.dp)
        Column {
            Box {
                Image(
                    image, modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.matchParentSize()
                        .padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
                ) {
                    Text(text = "Chinese By Nature", modifier = Modifier.padding(start = 8.dp))
                    Row {
                        Text(
                            "pro extra 20% OFF",
                            maxLines = 1,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(fontSize = 8.sp),
                            modifier = Modifier.clip(
                                shape = RoundedCornerShape(
                                    topRight = 2.dp,
                                    bottomRight = 2.dp
                                )
                            )
                                .background(Color.Red)
                                .padding(start = 4.dp, end = 4.dp)

                        )
                        Text(
                            "20% OFF",
                            maxLines = 1,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(fontSize = 8.sp),
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .clip(shape = RoundedCornerShape(2.dp))
                                .background(Color.Blue)
                                .padding(start = 4.dp, end = 4.dp)

                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "20 mins",
                            maxLines = 1,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(fontSize = 8.sp),
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .clip(shape = RoundedCornerShape(2.dp))
                                .background(Color.DarkGray)
                                .padding(start = 4.dp, end = 4.dp)

                        )
                    }

                }
            }
            ConstraintLayout(modifier = Modifier.padding(8.dp)) {
                // Create references for the composables to constrain
                val (rsName, category, rating, divider, price, orders) = createRefs()

                Text("Raj Bathure Wala", Modifier.constrainAs(rsName) {

                })

                Text(
                    listOf("North Indian", "Chinese").joinToString(", "),
                    color = Color.Gray,
                    style = TextStyle(fontSize = 8.sp),
                    modifier = Modifier.constrainAs(category) {
                        top.linkTo(rsName.bottom)
                    })
                Text(
                    "3.2/5",
                    color = Color.Gray,
                    style = TextStyle(fontSize = 8.sp),
                    modifier = Modifier.constrainAs(rating) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top,margin = 8.dp)
                    })
                Text(
                    "200 for one",
                    color = Color.Gray,
                    style = TextStyle(fontSize = 8.sp),
                    modifier = Modifier.constrainAs(price) {
                        end.linkTo(parent.end)
                        top.linkTo(rating.bottom)
                    })

                Divider(Modifier.constrainAs(divider) {
                    top.linkTo(category.bottom, margin = 4.dp)
                })
//                Text(
//                    "475+ people ordered from here since lockdown",
//                    color = Color.Gray,
//                    style = TextStyle(fontSize = 8.sp),
//                    modifier = Modifier.constrainAs(orders) {
//                        top.linkTo(divider.bottom,margin = 4.dp)
//                        bottom.linkTo(parent.bottom)
//                    })

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column() {
        repeat(5){
            RestaurantCardBig("Android") {
            }
        }
    }

}