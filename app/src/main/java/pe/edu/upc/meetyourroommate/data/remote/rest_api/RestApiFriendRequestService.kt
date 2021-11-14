package pe.edu.upc.meetyourroommate.data.remote.rest_api

import android.util.Log
import pe.edu.upc.meetyourroommate.data.model.FriendRequest
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiFriendRequestService {
    fun createFriendRequest(senderId: Int, receiverId: Int, onResult: (FriendRequest?) -> Unit) {
        val friendRequestService = ApiClient.buildFriendRequest()
        val addFriendRequest = friendRequestService.createFriendRequest(senderId, receiverId)

        addFriendRequest.enqueue(object: Callback<FriendRequest> {
            override fun onResponse(
                call: Call<FriendRequest>,
                response: Response<FriendRequest>
            ) {
                if(response.isSuccessful) {
                    val friendRequest = response.body()
                    onResult(friendRequest)
                }
            }
            override fun onFailure(call: Call<FriendRequest>, t: Throwable) {
                Log.d("FriendRequest error", t.toString())
            }
        })
    }

}