package pe.edu.upc.meetyourroommate.data.remote.services

import pe.edu.upc.meetyourroommate.data.model.FriendRequest
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface FriendRequestService {
    @POST("friend-requests")
    fun createFriendRequest(@Query("sender") senderId: Int, @Query("receiver") receiverId: Int): Call<FriendRequest>
}