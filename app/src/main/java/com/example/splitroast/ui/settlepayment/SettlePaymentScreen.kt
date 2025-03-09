package com.example.splitroast.ui.settlepayment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitroast.ui.theme.backgroundColor
import com.example.splitroast.ui.theme.button_color_1
import com.example.splitroast.ui.theme.button_color_3
import com.example.splitroast.ui.theme.button_content_color

@Composable
fun SettlePaymentsScreen(currentUser: String = "", navController: NavController) {
    val unsettledDebts = listOf(
        "Tejas owes Tanishq: $20.00",
        "Vedaant owes Tejas: $15.00",
        "Tanishq owes Tejas: $5.00"
    )
    val userDebts = unsettledDebts.filter { it.contains(currentUser) }

    Column(modifier = Modifier.background(color = backgroundColor)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            if (userDebts.isEmpty()) {
                Text(text = "No pending settlements", style = MaterialTheme.typography.bodyMedium)
            } else {
                userDebts.forEach { debt ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)) {
                        Row(modifier = Modifier.padding(start = 32.dp, top = 16.dp, bottom = 16.dp, end = 32.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = debt, modifier = Modifier.weight(1f))
                            Button(onClick = {},
                                colors = ButtonColors(
                                    containerColor = button_color_1,
                                    contentColor = button_content_color,
                                    disabledContainerColor = Color.Yellow,
                                    disabledContentColor = Color.Yellow
                                )) {
                                Text("Settle")
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(168.dp))
            Button(onClick = { navController.popBackStack() },
                colors = ButtonColors(
                    containerColor = button_color_3,
                    contentColor = button_content_color,
                    disabledContainerColor = Color.Yellow,
                    disabledContentColor = Color.Yellow
                ), shape = RoundedCornerShape(8.dp)
            ) {
                Text("BACK")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun PreviewSettlePaymentsScreen() {
    val navController = rememberNavController()
    SettlePaymentsScreen(currentUser = "Tanishq", navController)
}