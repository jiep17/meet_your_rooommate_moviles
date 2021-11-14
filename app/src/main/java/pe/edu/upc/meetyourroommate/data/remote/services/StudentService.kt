package pe.edu.upc.meetyourroommate.data.remote.services

import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.model.saving.SaveStudent
import pe.edu.upc.meetyourroommate.data.remote.responses.StudentResponse
import retrofit2.Call
import retrofit2.http.*

interface StudentService {
    @GET("students")
    fun fetchStudents(): Call<StudentResponse>

    @GET("students/{studentId}")
    fun fetchStudentById(@Path("studentId") id: Int): Call<Student>

    @POST("students")
    fun createStudent(@Body student: SaveStudent, @Query("campus") campusId: Int): Call<Student>

}
