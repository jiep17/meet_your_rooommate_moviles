package pe.edu.upc.meetyourroommate.data.remote.services

import pe.edu.upc.meetyourroommate.data.model.Lessor
import pe.edu.upc.meetyourroommate.data.remote.responses.LessorResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LessorService {
    @GET("lessors")
    fun fetchLessors(): Call<LessorResponse>

    @GET("lessors/{lessorId}")
    fun fetchLessorById(@Path("lessorId") id: Int): Call<Lessor>
}