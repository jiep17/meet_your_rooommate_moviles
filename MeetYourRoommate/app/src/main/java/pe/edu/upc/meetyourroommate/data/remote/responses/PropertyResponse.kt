package pe.edu.upc.meetyourroommate.data.remote.responses

import com.google.gson.annotations.SerializedName
import pe.edu.upc.meetyourroommate.data.model.Property

class PropertyResponse(
    @SerializedName("content")
    val properties: List<Property>
)