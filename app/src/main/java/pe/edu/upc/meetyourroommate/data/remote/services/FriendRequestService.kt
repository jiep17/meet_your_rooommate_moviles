package pe.edu.upc.meetyourroommate.data.remote.services

import pe.edu.upc.meetyourroommate.data.model.FriendRequest
import pe.edu.upc.meetyourroommate.data.model.saving.SaveFriendRequest
import pe.edu.upc.meetyourroommate.data.remote.responses.FriendRequestResponse
import retrofit2.Call
import retrofit2.http.*

interface FriendRequestService {
    @POST("friend-requests")
    fun createFriendRequest(@Query("sender") senderId: Int, @Query("receiver") receiverId: Int): Call<FriendRequest>

    @GET("received/friend-requests")
    fun fetchAllFriendRequestByReceivedId(@Query("student") receiverId: Int): Call<FriendRequestResponse>

    @PUT("friend-requests")
    fun acceptFriendRequest(@Body requestBody: SaveFriendRequest, @Query("sender") senderId: Int, @Query("receiver") receiverId: Int): Call<FriendRequest>
}