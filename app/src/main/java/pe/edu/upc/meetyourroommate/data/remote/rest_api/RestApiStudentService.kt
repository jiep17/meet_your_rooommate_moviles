package pe.edu.upc.meetyourroommate.data.remote.rest_api

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.presentation.screens.students.StudentRow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiStudentService {
    fun fetchStudent(studentId: Int, onResult: (Student?) -> Unit) {
        val studentService = ApiClient.buildStudent()
        val fetchStudentById = studentService.fetchStudentById(studentId)

        fetchStudentById.enqueue(object : Callback<Student> {
            override fun onResponse(call: Call<Student>, response: Response<Student>) {
                if(response.isSuccessful && response.body() != null) {
                    val student = response.body()
                    onResult(student)
                }
            }

            override fun onFailure(call: Call<Student>, t: Throwable) {
                Log.d("StudentScreenError", t.toString())
            }
        })
    }

}