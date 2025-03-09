package com.example.splitroast.ui.home

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitroast.R
import com.example.splitroast.ui.theme.button_color_1
import com.example.splitroast.ui.theme.button_color_2
import com.example.splitroast.ui.theme.button_color_3
import com.example.splitroast.ui.theme.button_content_color
import kotlin.math.cos
import kotlin.math.sin

val name = "Tanishq"

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen (navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFff751a))) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Hi, $name!") },
                    )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(color = Color(0xFFffb380)),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Welcome to Split-It",
                    fontSize = 24 .sp,
                    color = Color(0xFF662900),
                    modifier = Modifier.padding(20.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .height(180.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonColors(
                                containerColor = button_color_3,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                        ){
                            Column {
                                Text(
                                    text = "Amount Owed:"
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "1069.78",
                                    fontSize = 35.sp,
                                    color = Color(0xFFcc2900)
                                )
                            }
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .height(180.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonColors(
                                containerColor = button_color_3,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                            ){
                            Column {
                                Text(
                                    text = "Due Amount:"
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "1546.69",
                                    fontSize = 35.sp,
                                    color = Color(0xFF269900)
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .height(180.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonColors(
                                containerColor = button_color_3,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                        ) {
                            Column(
                                modifier = Modifier,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Expense Stats",
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                                DrawPieChartWithLabels()
                            }
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .height(180.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonColors(
                                containerColor = button_color_3,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                        ) {
                            Column() {
                                Text(
                                    text = "Budget Remaining: "
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "2674.64",
                                    fontSize = 35.sp,
                                    color = Color(0xFF269900)
                                )
                            }
                        }
                    }
                }
                Column {
                    GearMenu()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Button(
                            onClick = { navController.navigate("add_expense") },
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier
                                .weight(.1f)
                                .height(60.dp),
                            colors = ButtonColors(
                                containerColor = button_color_1,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                        ) {
                            Text(
                                "Add\nExpense",
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { navController.navigate("balance") },
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier
                                .weight(.1f)
                                .height(60.dp),
                            colors = ButtonColors(
                                containerColor = button_color_2,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                        ) {
                            Text(
                                "View\nBalances",
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { navController.navigate("settle_payment") },
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier
                                .weight(.1f)
                                .height(60.dp),
                            colors = ButtonColors(
                                containerColor = button_color_1,
                                contentColor = button_content_color,
                                disabledContainerColor = Color.Yellow,
                                disabledContentColor = Color.Yellow
                            )
                        ) {
                            Text(
                                "Settle\nPayments",
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GearMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),contentAlignment = Alignment.BottomEnd)
    {
        Button(onClick = { expanded = true }, shape = CircleShape,
            colors = ButtonColors(
                containerColor = button_color_2,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White,
            )) {
            Image(
                painter = painterResource(R.drawable.gear),
                contentDescription = null,
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { expanded = false }
                )
                DropdownMenuItem(
                    text = { Text("About us") },
                    onClick = { expanded = false }
                )
        }
    }
}

@Composable
fun PieChartWithLabels(
    data: List<Float>,
    labels: List<String>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    val total = data.sum()
    var startAngle = 0f

    Canvas(modifier = modifier
        .height(200.dp)
        .width(240.dp)) {
        data.forEachIndexed { index, value ->
            val sweepAngle = (value / total) * 360f

            drawArc(
                color = colors[index],
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true
            )

            val midAngle = startAngle + (sweepAngle / 2)
            val radius = size.minDimension / 3
            val x = (size.width / 2) + (radius * cos(Math.toRadians(midAngle.toDouble()))).toFloat()
            val y = (size.height / 2) + (radius * sin(Math.toRadians(midAngle.toDouble()))).toFloat()

            drawContext.canvas.nativeCanvas.drawText(
                "${labels[index]}",
                x,
                y,
                Paint().apply {
                    color = android.graphics.Color.WHITE
                    textSize = 30f
                    textAlign = Paint.Align.CENTER
                }
            )

            startAngle += sweepAngle
        }
    }
}

@Composable
fun DrawPieChartWithLabels() {
    val expenses = listOf(300f, 200f, 150f, 100f)
    val labels = listOf("Food", "Travel", "Shopping", "Others")
    val colors = listOf(Color(0xFFff4d4d), Color(0xFF4d9900), Color(0xFF0080ff), Color(0xFFe6b800))

    PieChartWithLabels(data = expenses, labels = labels, colors = colors, modifier = Modifier.padding(16.dp))
}


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}