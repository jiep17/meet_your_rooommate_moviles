package pe.edu.upc.meetyourroommate.data.remote.rest_api

import android.util.Log
import pe.edu.upc.meetyourroommate.data.model.FriendRequest
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.model.saving.SaveFriendRequest
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.data.remote.responses.FriendRequestResponse
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

    fun getFriendRequestByReceivedId(receiverId: Int, onResult: (FriendRequestResponse) -> Unit) {
        val friendRequestService = ApiClient.buildFriendRequest()
        val getFriendRequest = friendRequestService.fetchAllFriendRequestByReceivedId(receiverId)
        getFriendRequest.enqueue(object: Callback<FriendRequestResponse> {
            override fun onResponse(
                call: Call<FriendRequestResponse>,
                response: Response<FriendRequestResponse>
            ) {
                Log.d("Llega al success", "si llegas")
                if(response.isSuccessful) {
                    val friendRequest = response.body()!!
                    onResult(friendRequest)
                    Log.d("Que retorna",friendRequest.toString())
                }
            }

            override fun onFailure(call: Call<FriendRequestResponse>, t: Throwable) {
                Log.d("Get FriendRequest error", t.toString())
            }

        })
    }

    fun acceptFriendRequest(type: String, senderId: Int, receiverId: Int, onResult: (FriendRequest?) -> Unit) {
        val friendRequestService = ApiClient.buildFriendRequest()
        var saveFriendRequest = SaveFriendRequest(3)

        if (type == "accept") {
            saveFriendRequest.status = 1
        } else {
            saveFriendRequest.status = 2
        }

        val acceptFriendRequest = friendRequestService.acceptFriendRequest(saveFriendRequest, senderId, receiverId)

        acceptFriendRequest.enqueue(object: Callback<FriendRequest> {
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