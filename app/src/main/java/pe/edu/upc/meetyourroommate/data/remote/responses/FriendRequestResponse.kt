package pe.edu.upc.meetyourroommate.data.remote.responses

import com.google.gson.annotations.SerializedName
import pe.edu.upc.meetyourroommate.data.model.FriendRequest

class FriendRequestResponse (
    @SerializedName("content")
    val friendRequests: List<FriendRequest>
)