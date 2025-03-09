package com.example.splitroast.ui.settlepayment

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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SettlePaymentScreen(navController: NavController){
    Scaffold(
        topBar = { TopAppBar(title = { Text("Settle Expenses") }) }
    ) { padding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color(0xFFffb380)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)){
                //TextShow("Tejas Kadam", "150", "Due")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                //TextShow("Vedaant Agarwaal", "230", "Due")
            }
            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}

//@Composable
//fun TextShow(txt1: String, txt2: String, txt3: String){
//    Column( modifier = Modifier.weight(2f)) {
//        Text(txt1, fontSize = 18.sp)
//    }
//    Box(modifier = Modifier.weight(1f)) {
//        Text(txt2, fontSize = 18.sp)
//    }
//    Box(modifier = Modifier.weight(1f)) {
//        Text(txt3, fontSize = 18.sp)
//    }
//}
