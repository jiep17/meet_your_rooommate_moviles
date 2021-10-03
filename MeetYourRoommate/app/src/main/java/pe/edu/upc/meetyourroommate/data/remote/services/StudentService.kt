package pe.edu.upc.meetyourroommate.data.remote.services

import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.remote.responses.StudentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentService {
    @GET("students")
    fun fetchStudents(): Call<StudentResponse>

    @GET("students/{studentId}")
    fun fetchStudentById(@Path("studentId") id: Int): Call<Student>
}
