package pe.edu.upc.meetyourroommate.data.remote.rest_api

import android.util.Log
import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiPropertyService {
    fun addProperty(propertyData: Property, onResult: (Property?) -> Unit) {
        val propertyService = ApiClient.buildProperty()
        val createProperty = propertyService.createProperty(propertyData, propertyData.lessorId)

        createProperty.enqueue(object: Callback<Property>{
            override fun onResponse(
                call: Call<Property>,
                response: Response<Property>
            ) {
                if(response.isSuccessful) {
                    val addedProperty = response.body()
                    onResult(addedProperty)
                }
            }
            override fun onFailure(call: Call<Property>, t: Throwable) {
                Log.d("PropertiesComposeError", t.toString())
            }
        })

    }
}