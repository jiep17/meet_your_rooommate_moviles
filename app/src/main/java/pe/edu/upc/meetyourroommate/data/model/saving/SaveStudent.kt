package pe.edu.upc.meetyourroommate.data.model.saving

class SaveStudent(
    val firstName: String,
    val lastName: String,
    val dni: String,
    val phoneNumber: String,
    val gender: String,
    val birthdate: String,
    val address: String,
    val description: String,
    val hobbies: String,
    val smoker: Boolean,
    val searching: Boolean,
    val premium: Boolean,
    val mail: String,
    val password: String,
)
{
    constructor():this("","","","","","","","","",false,false,true,"","")
}