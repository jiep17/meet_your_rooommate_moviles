package pe.edu.upc.meetyourroommate.data.remote.responses

import com.google.gson.annotations.SerializedName
import pe.edu.upc.meetyourroommate.data.model.Student

class StudentResponse (
    @SerializedName("content")
    val students: List<Student>
)

