package com.pratikvelani.taskly.ui.screen

sealed class Screen(val route: String, val name: String) {
    object Home : Screen("home", "Home")
}
