package pe.edu.upc.meetyourroommate.presentation.screens.students

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.data.remote.StudentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Students(
    navigateStudentScreen: (Int) -> Unit
) {
    var students by remember {
        mutableStateOf(listOf<Student>())
    }
    val studentService = ApiClient.buildStudent()
    val fetchStudents = studentService.fetchStudents()

    fetchStudents.enqueue(object: Callback<StudentResponse> {
        override fun onResponse(
            call: Call<StudentResponse>,
            response: Response<StudentResponse>
        ) {
            if(response.isSuccessful) {
                students = response.body()!!.students
            }
        }

        override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
            Log.d("StudentComposeError", t.toString())
        }

    })

    Scaffold (
        backgroundColor = colorResource(R.color.piel_p)
    ){
        StudentsList(students, navigateStudentScreen)
    }
}


@Composable
fun StudentsList(students: List<Student>, navigateStudentScreen: (Int)-> Unit){
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Roommates",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )
            )
        }
        items(students) {
                student -> StudentRow(student, navigateStudentScreen)
        }
    }
}

@Composable
fun StudentRow(student: Student, navigateStudentScreen: (Int)-> Unit){
    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = colorResource(R.color.plomo_p),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.im_person_anonimo),
                contentDescription = "Imagen del estudiante",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(90.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            ItemStudentDescription(student, navigateStudentScreen)

        }
    }
}

@Composable
fun ItemStudentDescription(student: Student, navigateStudentScreen: (Int)-> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.clickable { isExpanded = !isExpanded }
    ) {
        Text(
            text = student.firstName + " " + student.lastName,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = student.birthdate.dropLast(19),
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )

        Text(
            text = student.description,
            modifier = Modifier.padding(all = 4.dp),
            maxLines = if (isExpanded) Int.MAX_VALUE else 2,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = student.gender,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
            Button(
                onClick = { navigateStudentScreen(student.id) },
                shape = RoundedCornerShape(corner = CornerSize(30.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.naranja_p)),
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Text(text = "Ver más")
            }
        }

    }
}