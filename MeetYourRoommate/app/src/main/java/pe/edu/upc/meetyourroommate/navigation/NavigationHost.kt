package pe.edu.upc.meetyourroommate

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.navigation.Destinations
import pe.edu.upc.meetyourroommate.presentation.screens.home.Home
import pe.edu.upc.meetyourroommate.presentation.screens.login.SignIn
import pe.edu.upc.meetyourroommate.presentation.screens.profile.Profile
import pe.edu.upc.meetyourroommate.presentation.screens.properties.CreatePropertyScreen
import pe.edu.upc.meetyourroommate.presentation.screens.properties.Properties
import pe.edu.upc.meetyourroommate.presentation.screens.properties.PropertyScreen
import pe.edu.upc.meetyourroommate.presentation.screens.students.StudentScreen
import pe.edu.upc.meetyourroommate.presentation.screens.students.Students

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    var usuario by remember { mutableStateOf(User()) }

    NavHost(navController = navController, startDestination = Destinations.Login.route){
        // HOME
        composable(Destinations.Home.route) {
            Home(navController, usuario)
        }

        // LOG IN
        composable(Destinations.Login.route){
            SignIn(
                navigateHome = {
                    navController.navigate(Destinations.Home.route)
                },
                changeUser = fun(user: User) {
                    usuario = user
                }
            )
        }

        // VISTA PROPERTIES
        composable(Destinations.Properties.route) {
            Properties(
                navigatePropertyScreen = { propertyId ->
                    navController.navigate(Destinations.Property.createRoute(propertyId))
                }
            )
        }

        // VISTA PROPERTY
        composable(
            Destinations.Property.route,
            arguments = listOf(navArgument("propertyId"){ defaultValue = 1})
        ) {
            navBackStackEntry ->
            var propertyId = navBackStackEntry.arguments?.getInt("propertyId")
            requireNotNull(propertyId)
            PropertyScreen(propertyId)
        }

        // VISTA CREAR PROPERTY
        composable(Destinations.AddProperty.route) {
            CreatePropertyScreen()
        }

        // VISTA STUDENTS
        composable(Destinations.Students.route) {
            Students(
                navigateStudentScreen = { studentId ->
                    navController.navigate(Destinations.Student.createRoute(studentId))
                }
            )
        }

        // VISTA STUDENT
        composable(
            Destinations.Student.route,
            arguments = listOf(navArgument("studentId"){ defaultValue = 1})
        ) {
                navBackStackEntry ->
            var studentId = navBackStackEntry.arguments?.getInt("studentId")
            requireNotNull(studentId)
            StudentScreen(studentId, usuario)
        }
        composable(Destinations.Profile.route) {
            Profile()
        }
    }

}

@Composable
fun changeUser(function: () -> Unit) {

}

