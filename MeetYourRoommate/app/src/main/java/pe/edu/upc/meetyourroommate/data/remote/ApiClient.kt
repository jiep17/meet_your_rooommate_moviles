package pe.edu.upc.meetyourroommate.data.remote

import pe.edu.upc.meetyourroommate.data.remote.services.LessorService
import pe.edu.upc.meetyourroommate.data.remote.services.PropertyService
import pe.edu.upc.meetyourroommate.data.remote.services.StudentService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://myr-v1.herokuapp.com/api/"

    private var propertyService: PropertyService? = null

    fun buildProperty(): PropertyService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        propertyService = retrofit.create(PropertyService::class.java)
        return propertyService as PropertyService
    }

    private var lessorService: LessorService? = null

    fun buildLessor(): LessorService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        lessorService = retrofit.create(LessorService::class.java)
        return lessorService as LessorService
    }


    private var studentService: StudentService? = null

    fun buildStudent(): StudentService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        studentService = retrofit.create(StudentService::class.java)
        return studentService as StudentService
    }
}