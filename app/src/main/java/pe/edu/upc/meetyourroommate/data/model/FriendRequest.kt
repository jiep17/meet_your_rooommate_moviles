package pe.edu.upc.meetyourroommate.data.model

class FriendRequest (
    val studentSendId: Int,

    val studentReceivedId: Int,

    val status: Int,

    val statusDescription: String,
) {
    constructor() : this(1,1,1,"")
}