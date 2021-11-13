package pe.edu.upc.meetyourroommate.data.remote.services

import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.remote.responses.PropertyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PropertyService {
    @GET("properties")
    fun fetchProperties(): Call<PropertyResponse>

    @GET("properties/{propertyId}")
    fun fetchPropertyById(@Path("propertyId") id: Int): Call<Property>

}