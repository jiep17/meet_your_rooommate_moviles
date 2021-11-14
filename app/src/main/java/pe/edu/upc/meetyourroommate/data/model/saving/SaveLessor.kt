package pe.edu.upc.meetyourroommate.data.model.saving

class SaveLessor(
    val firstName: String,
    val lastName: String,
    val dni: String,
    val phoneNumber: String,
    val gender: String,
    val birthdate: String,
    val address: String,
    val premium: Boolean,
    val mail: String,
    val password: String,
)
{
    constructor():this("","","","","","","",false,"","")
}