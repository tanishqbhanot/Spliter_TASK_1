package com.example.splitroast.ui.balance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitroast.ui.addexpense.AddExpenseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BalanceScreen(navController: NavController) {
    var totalBalance by remember { mutableStateOf("$0.00") }
    val userBalances = listOf(
        "Alice: $10.00",
        "Bob: -$5.00",
        "Charlie: $15.00"
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Total Balance", style = MaterialTheme.typography.headlineMedium)
        Text(text = totalBalance, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Individual Balances", style = MaterialTheme.typography.headlineLarge)
        userBalances.forEach { balance ->
            Text(text = balance, style = MaterialTheme.typography.bodyMedium)
        }
    }
            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAddExpenseScreen() {
    val navController = rememberNavController()
    BalanceScreen(navController = navController)
}