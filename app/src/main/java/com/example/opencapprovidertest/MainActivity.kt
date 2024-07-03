package com.example.opencapprovidertest

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import com.example.opencapprovidertest.ui.theme.OpenCapProviderTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenCapProviderTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        VinUpdateUI(context = this@MainActivity)
                    }
                }
            }
        }
    }
}

@Composable
fun VinUpdateUI(modifier: Modifier = Modifier, context: Context) {
    var vin by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Set VIN", fontSize = 20.sp)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            BasicTextField(
                value = vin,
                onValueChange = {
                    vin = it
                    CurrentVin.setVin(vin)
                },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
        }
        Button(
            onClick = {
                Util.sendIntent(context, Util.ReceiverType.VEHICLE_INFORMATION)
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Set VIN")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpenCapProviderTestTheme {
  //      Greeting("Android")
    }
}


