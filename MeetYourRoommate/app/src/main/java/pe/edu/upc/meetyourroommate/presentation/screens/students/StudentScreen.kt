package pe.edu.upc.meetyourroommate.presentation.screens.students

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.data.remote.rest_api.RestApiFriendRequestService
import pe.edu.upc.meetyourroommate.presentation.screens.properties.DescriptionLessor
import pe.edu.upc.meetyourroommate.presentation.screens.properties.PropertyContent
import pe.edu.upc.meetyourroommate.presentation.screens.properties.PropertyHeader
import pe.edu.upc.meetyourroommate.presentation.screens.properties.PropertyRow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun StudentScreen(
    studentId: Int,
    usuario: User
) {
    var student by remember { mutableStateOf(Student())}

    val studentService = ApiClient.buildStudent()
    val fetchStudentById = studentService.fetchStudentById(studentId)

    fetchStudentById.enqueue(object : Callback<Student>{
        override fun onResponse(call: Call<Student>, response: Response<Student>) {
            if(response.isSuccessful && response.body() != null) {
                student = response.body()!!
            }
        }

        override fun onFailure(call: Call<Student>, t: Throwable) {
            Log.d("StudentScreenError", t.toString())
        }
    })
    LazyColumn() {
        item {
            StudentRow(student, usuario)
        }
    }
}

@Composable
fun StudentRow(student: Student, usuario: User) {
    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        backgroundColor = colorResource(R.color.naranja_p),
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ){
        val friendRequestService =RestApiFriendRequestService()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    StudentHeader(student)
                    Spacer(modifier = Modifier.width(8.dp))
                    StudentContent(student)
                    Button(
                        onClick = {
                            friendRequestService.createFriendRequest(usuario.id!!, student.id) {
                                if(it?.status == 3) {
                                    Log.d("FriendRequest", "Solicitud enviada")
                                }
                                else{
                                    Log.d("FriendRequest error", "No se pudo enviar la solicitud")
                                }
                            }
                        },
                        shape = RoundedCornerShape(corner = CornerSize(24.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.naranja_p)),
                        modifier = Modifier
                            .padding(end = 10.dp)
                    ) {
                        Text(text = "Agregar")
                    }
                }
            }
        }
    }
}

@Composable
fun StudentHeader(student: Student) {
    Image(
        modifier = Modifier
            .heightIn(max = 400.dp)
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.im_person_anonimo),
            contentDescription = "Imagen del Estudiante",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun StudentContent(student: Student) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = student.firstName + " " + student.lastName,
        style = TextStyle(
            color = colorResource(R.color.red_p),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
    )
    TextStringValue(text = "Contact ", value = student.phoneNumber)
    TextStringValue(text = "Gender ", value = student.gender)
    TextStringValue(text = "Birthdate ", value = student.birthdate.dropLast(19))
    TextStringValue(text = "Description ", value = student.description)
    TextStringValue(text = "Hobbies ", value = student.hobbies)
    TextStringValue(text = "Smoker ", value = if (student.smoker) "True" else "False")
}

@Composable
fun TextStringValue(text: String, value: String) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}

