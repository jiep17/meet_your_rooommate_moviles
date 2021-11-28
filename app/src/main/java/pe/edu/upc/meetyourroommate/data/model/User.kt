package pe.edu.upc.meetyourroommate.data.model

class User(
    var id: Int?,
    var discriminator: String
 ){
    constructor() : this(null, "")
}