package com.example.splitroast.ui.balance

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitroast.ui.addexpense.AddExpenseScreen
import com.example.splitroast.ui.theme.backgroundColor
import com.example.splitroast.ui.theme.button_color_1
import com.example.splitroast.ui.theme.button_content_color

@Composable
fun BalanceScreen(navController: NavController) {
    val pastPayments = listOf(
        "Paid $20 to Tejas on 01/03/2025",
        "Received $15 from Vedaant on 28/02/2025",
        "Paid $10 to Tejas on 25/02/2025"
    )
    val netBalance = "Owed $5.00"

    Column(modifier = Modifier.background(color = backgroundColor)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(color = backgroundColor)
                .fillMaxWidth()
                .height(744.dp)
        ) {
            Text(text = "Net Balance: $netBalance", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(top = 40.dp))
            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Past Payments: ", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            pastPayments.forEach { payment ->
                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)) { Row(modifier = Modifier.padding(start = 32.dp, top = 16.dp, bottom = 16.dp, end = 32.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = payment, style = MaterialTheme.typography.bodyMedium)
                }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Button(onClick = {navController.popBackStack()},
                colors = ButtonColors(
                    containerColor = button_color_1,
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
fun PreviewBalanceScreen() {
    val navController = rememberNavController()
    BalanceScreen(navController)
}