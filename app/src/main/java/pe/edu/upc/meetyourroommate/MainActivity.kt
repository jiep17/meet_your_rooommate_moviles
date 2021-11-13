package pe.edu.upc.meetyourroommate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.meetyourroommate.navigation.Destinations
import pe.edu.upc.meetyourroommate.presentation.components.Drawer
import pe.edu.upc.meetyourroommate.presentation.components.TopBar
import pe.edu.upc.meetyourroommate.presentation.screens.login.SignIn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)  // Para que el box aparezca cerrado
    )
    val  scope = rememberCoroutineScope()

    val navigationItems = listOf(
        Destinations.Home,
        Destinations.Properties,
        Destinations.Students
    )
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope, scaffoldState)},
        drawerContent = {
            Drawer(scope, scaffoldState, navController, items = navigationItems) },
        drawerGesturesEnabled = true,
    ){
        NavigationHost(navController)
    }
}

