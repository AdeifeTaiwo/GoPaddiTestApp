package com.example.gopadditestapp.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.gopadditestapp.navigation.mainnavigation.mainGraph

@Composable
fun RootNavigationGraph(
    activity: Activity,
) {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN
    ) {

        mainGraph(
            navHostController = navHostController,
            activity = activity,
        )
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val MAIN = "main_graph"
}
