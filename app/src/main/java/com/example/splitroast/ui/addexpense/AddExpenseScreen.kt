package com.example.splitroast.ui.addexpense

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitroast.ui.theme.backgroundColor
import com.example.splitroast.ui.theme.button_color_1
import com.example.splitroast.ui.theme.button_color_3
import com.example.splitroast.ui.theme.button_content_color
import java.util.Calendar

@Composable
fun AddExpenseScreen(navController: NavController) {
    var expenseName by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var selectedPayer by remember { mutableStateOf("Select Payer") }
    var selectedDate by remember { mutableStateOf("Select Date") }
    val payerList = listOf("Tejas", "Vedaant", "Tanishq")
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(modifier = Modifier.background(color = backgroundColor)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .height(732.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = expenseName,
                onValueChange = { expenseName = it },
                label = { Text("Expense Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            DropdownMenuDemo(selectedPayer, payerList) { selectedPayer = it }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { datePickerDialog.show() }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonColors(
                    containerColor = button_color_1,
                    contentColor = button_content_color,
                    disabledContainerColor = Color.Yellow,
                    disabledContentColor = Color.Yellow
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(selectedDate)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    Toast.makeText(context, "Expense Added", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier.width(156.dp),
                colors = ButtonColors(
                    containerColor = button_color_3,
                    contentColor = button_content_color,
                    disabledContainerColor = Color.Yellow,
                    disabledContentColor = Color.Yellow
                ), shape = RoundedCornerShape(8.dp)
            ) {
                Text("Add Expense")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

            Column(modifier = Modifier.padding(24.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { navController.popBackStack() },
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

@Composable
fun DropdownMenuDemo(selectedPayer: String, items: List<String>, onSelection: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonColors(
                containerColor = button_color_3,
                contentColor = button_content_color,
                disabledContainerColor = Color.Yellow,
                disabledContentColor = Color.Yellow
            ), shape = RoundedCornerShape(8.dp)) {
            Text(selectedPayer)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = { expanded = false; onSelection(item)}
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun PreviewAddExpenseScreen() {
    val navController = rememberNavController()
    AddExpenseScreen(navController = navController)
}
