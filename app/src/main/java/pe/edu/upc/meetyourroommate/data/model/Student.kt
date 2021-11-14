package pe.edu.upc.meetyourroommate.data.model

class Student (
    val id: Int,

    val personType: String,

    val firstName: String,

    val lastName: String,

    val dni: String,

    val phoneNumber: String,

    val gender: String,

    val birthdate: String,

    val address: String,

    val premium: Boolean,

    val description: String,

    val hobbies: String,

    val smoker: Boolean,

    val searching: Boolean,

) {
    constructor() : this(1,"","","","","","","","", false, "","", false, false)

}