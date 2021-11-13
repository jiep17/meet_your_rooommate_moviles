package pe.edu.upc.meetyourroommate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Login
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
    object Properties: Destinations("properties", "Properties", Icons.Rounded.List)
    object Property: Destinations("properties/?propertyId={propertyId}", "Property", Icons.Filled.Home){
        fun createRoute(propertyId: Int) = "properties/?propertyId=$propertyId"

    }
    object Students: Destinations("students","Students", Icons.Rounded.Person )
    object Student: Destinations("students/?studentId={studentId}","Student", Icons.Rounded.Person){
        fun createRoute(studentId: Int) = "students/?studentId=$studentId"
    }
    object Login: Destinations("login", "Login", Icons.Filled.Login)
    object Profile: Destinations("profile", "Profile", Icons.Filled.AccountCircle)

}
