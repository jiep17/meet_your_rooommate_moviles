package pe.edu.upc.meetyourroommate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pe.edu.upc.meetyourroommate.navigation.Destinations
import pe.edu.upc.meetyourroommate.presentation.screens.home.Home
import pe.edu.upc.meetyourroommate.presentation.screens.login.SignIn
import pe.edu.upc.meetyourroommate.presentation.screens.profile.Profile
import pe.edu.upc.meetyourroommate.presentation.screens.properties.Properties
import pe.edu.upc.meetyourroommate.presentation.screens.properties.PropertyScreen
import pe.edu.upc.meetyourroommate.presentation.screens.students.StudentScreen
import pe.edu.upc.meetyourroommate.presentation.screens.students.Students

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Destinations.Login.route){

        // HOME
        composable(Destinations.Home.route) {
            Home(navController)
        }

        // LOG IN
        composable(Destinations.Login.route){
            SignIn(
                navigateHome = {
                    navController.navigate(Destinations.Home.route)
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
            StudentScreen(studentId)
        }
        composable(Destinations.Profile.route) {
            Profile()
        }
    }
}