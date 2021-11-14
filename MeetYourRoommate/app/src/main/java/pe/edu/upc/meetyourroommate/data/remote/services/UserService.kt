package pe.edu.upc.meetyourroommate.data.remote.services

import pe.edu.upc.meetyourroommate.data.model.User
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @POST("users")
    fun login(@Query("mail") mail: String, @Query("pwd") password: String): Call<User>

}