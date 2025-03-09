package com.example.splitroast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.splitroast.navigation.ExpenseNavHost
import com.example.splitroast.ui.theme.SplitRoastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplitRoastTheme {
                ExpenseNavHost()
            }
        }
    }
}
