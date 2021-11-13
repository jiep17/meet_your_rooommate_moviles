package pe.edu.upc.meetyourroommate.data.model

class Lessor (
    val id: Int,

    val personType: String,

    val firstName: String,

    val lastName: String,

    val dni: String,

    val phoneNumber: String,

    val gender: String,

    val birthdate: String,

    val address: String,

    val premium: Boolean
) {
    constructor() : this(1,"","","","","","","","", false)
}