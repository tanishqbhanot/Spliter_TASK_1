package com.example.splitroast.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splitroast.ui.addexpense.AddExpenseScreen
import com.example.splitroast.ui.balance.BalanceScreen
import com.example.splitroast.ui.home.HomeScreen
import com.example.splitroast.ui.settlepayment.SettlePaymentsScreen

@Composable
fun ExpenseNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("add_expense") { AddExpenseScreen(navController) }
        composable("balance") { BalanceScreen(navController) }
        composable("settle_payment") { SettlePaymentsScreen("Tanishq", navController) }
//        composable("settings") {SettingsScreen(navController)}
//        composable("about_us") {AboutUsScreen(navController)}
    }
}

