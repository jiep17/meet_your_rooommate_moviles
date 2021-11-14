package pe.edu.upc.meetyourroommate.data.remote.services

import okhttp3.RequestBody
import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.remote.responses.PropertyResponse
import retrofit2.Call
import retrofit2.http.*

interface PropertyService {
    @GET("properties")
    fun fetchProperties(): Call<PropertyResponse>

    @GET("properties/{propertyId}")
    fun fetchPropertyById(@Path("propertyId") id: Int): Call<Property>

    @Headers("Content-Type: application/json")
    @POST("properties")
    fun createProperty(@Body requestBody: Property): Call<Property>

}