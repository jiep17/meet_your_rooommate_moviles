package pe.edu.upc.meetyourroommate

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.navigation.Destinations
import pe.edu.upc.meetyourroommate.presentation.screens.friends.FriendRequest
import pe.edu.upc.meetyourroommate.presentation.screens.home.Home
import pe.edu.upc.meetyourroommate.presentation.screens.login.SignIn
import pe.edu.upc.meetyourroommate.presentation.screens.properties.CreatePropertyScreen
import pe.edu.upc.meetyourroommate.presentation.screens.properties.Properties
import pe.edu.upc.meetyourroommate.presentation.screens.properties.PropertyScreen
import pe.edu.upc.meetyourroommate.presentation.screens.register.LessorRegister
import pe.edu.upc.meetyourroommate.presentation.screens.register.Register
import pe.edu.upc.meetyourroommate.presentation.screens.register.StudentRegister
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
                navigateRegister = {
                    navController.navigate(Destinations.Register.route)
                },
                changeUser = fun(user: User) {
                    usuario = user
                }
            )
        }

        // Register
        composable(Destinations.Register.route){
            Register(
                navigateToStudentRegister = {
                    navController.navigate(Destinations.StudentRegister.route)
                },
                navigateToLessorRegister = {
                    navController.navigate(Destinations.LessorRegister.route)
                }
            )
        }

        composable(Destinations.StudentRegister.route){
            StudentRegister(
                navigateHome = {
                    navController.navigate(Destinations.Home.route)
                })
        }

        composable(Destinations.LessorRegister.route){
            LessorRegister(
                navigateHome = {
                    navController.navigate(Destinations.Home.route)
                })
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
            CreatePropertyScreen(
                navigateProperties = {
                    navController.navigate(Destinations.Properties.route)
                },
                usuario = usuario
            )
        }
        
        // Friend Request
        composable (Destinations.FriendRequest.route) {
            FriendRequest(usuario = usuario)
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

    }

}

@Composable
fun changeUser(function: () -> Unit) {

}

