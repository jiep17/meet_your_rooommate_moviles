package pe.edu.upc.meetyourroommate.data.remote

import pe.edu.upc.meetyourroommate.data.remote.services.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://meetyourroommateapi.herokuapp.com/api/"

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

    private var userService: UserService? = null

    fun buildUser() : UserService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create(UserService::class.java)
        return userService as UserService
    }

    private var friendRequestService: FriendRequestService? = null

    fun buildFriendRequest() : FriendRequestService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        friendRequestService = retrofit.create(FriendRequestService::class.java)
        return friendRequestService as FriendRequestService
    }
}