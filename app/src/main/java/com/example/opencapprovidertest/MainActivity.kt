package com.example.opencapprovidertest

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.opencapprovidertest.ui.theme.OpenCapProviderTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenCapProviderTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        context = this
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context) {
    Column(modifier) {
        Button(onClick = {
            Util.sendBroadcastEvent(context, Util.ReceiverType.VEHICLE_INFORMATION)
        }) {
            Text("Vehicle Information Provider")
        }
        Button(onClick = {
            Util.sendBroadcastEvent(context, Util.ReceiverType.IDENTITY)
        }) {
            Text("Login Provider")
        }
        Button(onClick = {
          // VehicleInformation.setVin("1M2AX07Y79M006004")
        }) {
            Text("Change Vin")
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


