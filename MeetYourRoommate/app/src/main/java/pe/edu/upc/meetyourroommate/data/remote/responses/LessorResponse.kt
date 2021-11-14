package pe.edu.upc.meetyourroommate.data.remote.responses

import com.google.gson.annotations.SerializedName
import pe.edu.upc.meetyourroommate.data.model.Lessor

class LessorResponse(
    @SerializedName("content")
    val lessors: List<Lessor>
)