package pe.edu.upc.meetyourroommate.presentation.screens.properties

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.data.remote.PropertyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Properties(
    navigatePropertyScreen: (Int) -> Unit
) {
    var properties by remember {
        mutableStateOf(listOf<Property>())
    }
    val propertyService = ApiClient.buildProperty()
    val fetchProperties = propertyService.fetchProperties()

    fetchProperties.enqueue(object: Callback<PropertyResponse> {
        override fun onResponse(
            call: Call<PropertyResponse>,
            response: Response<PropertyResponse>
        ) {
            if(response.isSuccessful) {
                properties = response.body()!!.properties
            }
        }

        override fun onFailure(call: Call<PropertyResponse>, t: Throwable) {
            Log.d("PropertiesComposeError", t.toString())
        }

    })

    Scaffold (
        backgroundColor = colorResource(R.color.piel_p)
    ){
        PropertyList(properties, navigatePropertyScreen)
    }
}


@Composable
fun PropertyList(properties: List<Property>, navigatePropertyScreen: (Int)-> Unit){
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Departamentos Disponibles",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )
            )
        }
        items(properties) {
            property -> PropertyRow(property, navigatePropertyScreen)
        }
    }
}

@Composable
fun PropertyRow(property: Property, navigatePropertyScreen: (Int)-> Unit){
    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = colorResource(R.color.plomo_p),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.i_department_default),
                contentDescription = "Imagen del Departamento",
                modifier = Modifier
                    .padding(top = 25.dp)
                    .size(80.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            ) {
                Text(
                    text = property.description,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = property.address,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${property.price}$",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic
                        ),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Button(
                        onClick = { navigatePropertyScreen(property.id) },
                        shape = RoundedCornerShape(corner = CornerSize(30.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.naranja_p)),
                        modifier = Modifier
                            .padding(end = 10.dp)
                    ) {
                        Text(text = "Ver Detalle")
                    }
                }

            }
        }
    }
}