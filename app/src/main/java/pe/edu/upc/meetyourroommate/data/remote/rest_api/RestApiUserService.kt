package pe.edu.upc.meetyourroommate.data.remote.rest_api

import android.util.Log
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiUserService {
    fun loginUser(mail: String, password: String, onResult: (User?) -> Unit) {
        val userService = ApiClient.buildUser()
        val authentication = userService.login(mail, password)

        authentication.enqueue(object: Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                if(response.isSuccessful) {
                    val login_user = response.body()
                    onResult(login_user)
                }

            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                onResult(User())
            }
        })

    }
}