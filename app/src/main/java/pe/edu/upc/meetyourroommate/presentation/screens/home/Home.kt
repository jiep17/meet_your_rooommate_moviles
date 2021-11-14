package pe.edu.upc.meetyourroommate.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.data.remote.rest_api.RestApiStudentService
import pe.edu.upc.meetyourroommate.presentation.screens.students.StudentRow
import pe.edu.upc.meetyourroommate.presentation.screens.students.StudentScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Home(
    navController: NavController,
    usuario: User
) {
    if (usuario.discriminator == "student") {
        StudentScreen(studentId = usuario.id!!, usuario)
    } else {
        Log.d("HOLa", "Hola")
    }

}




