package pe.edu.upc.meetyourroommate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import pe.edu.upc.meetyourroommate.R

sealed class Destinations(
    val route : String,
    val title : String,
    val icon : ImageVector
) {
    object Home: Destinations("home", "Home", Icons.Filled.Home)
    object Login: Destinations("login", "Login", Icons.Filled.Login)

    // Property
    object Properties: Destinations("properties", "Properties", Icons.Rounded.List)
    object Property: Destinations("properties/?propertyId={propertyId}", "Property", Icons.Filled.Home){
        fun createRoute(propertyId: Int) = "properties/?propertyId=$propertyId"
    }
    object AddProperty: Destinations( "addproperty", "Crear Propiedad", Icons.Filled.Home)

    // Student
    object Students: Destinations("students","Students", Icons.Rounded.Person )
    object Student: Destinations("students/?studentId={studentId}","Student", Icons.Rounded.Person){
        fun createRoute(studentId: Int) = "students/?studentId=$studentId"
    }

    //Register
    object Register: Destinations("register", "Register", Icons.Filled.AppRegistration)
    object StudentRegister: Destinations("register/student", "Student Register", Icons.Filled.Person)
    object LessorRegister: Destinations("register/lessor", "Lessor Register", Icons.Filled.Person)

}
