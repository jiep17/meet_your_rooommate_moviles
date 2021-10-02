package pe.edu.upc.meetyourroommate.data.remote

import pe.edu.upc.meetyourroommate.data.model.Student
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentService {
    @GET("students")
    fun fetchStudents(): Call<StudentResponse>

    @GET("lessors/{lessorId}")
    fun fetchStudentById(@Path("studentId") id: Int): Call<Student>
}
