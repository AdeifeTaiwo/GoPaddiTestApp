package com.example.gopadditestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gopadditestapp.navigation.RootNavigationGraph
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoPaddiTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GoPaddiTest(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        RootNavigationGraph(activity = this)
                    }
                }
            }
        }
    }
}

@Composable
fun GoPaddiTest(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val systemTheme = isSystemInDarkTheme()
    GoPaddiTestAppTheme(
        darkTheme = false //implement dark theme
    ) {
        content()
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoPaddiTestAppTheme {
        Greeting("Android")
    }
}