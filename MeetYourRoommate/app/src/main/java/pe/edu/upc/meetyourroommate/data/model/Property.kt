package pe.edu.upc.meetyourroommate.data.model

class Property (

    val id: Int,

    val description: String,

    val address: String,

    val price: Double,

    val lessorId: Int
) {
    constructor() : this(1, "", "",0.00, 1)
}