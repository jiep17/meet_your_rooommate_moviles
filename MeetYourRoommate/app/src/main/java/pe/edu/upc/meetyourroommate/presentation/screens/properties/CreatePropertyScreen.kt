package pe.edu.upc.meetyourroommate.presentation.screens.properties

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.remote.rest_api.RestApiPropertyService

@Composable
fun CreatePropertyScreen() {
    val apiService = RestApiPropertyService()
    var description by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var price by remember { mutableStateOf("0.00")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crear Departamento",
            style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Black),
            textAlign = TextAlign.Center
        )
        // Description
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Description ") }
        )
        // Address
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(text = "Address ") }
        )
        // Price
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text(text = "Alquiler mensual ") }
        )

        Button(
            onClick = {
                val propertyInfo = Property(null, description, address, price.toDouble(), 4)
                apiService.addProperty(propertyInfo) {
                    if (it?.id == null) {
                        Log.d("Error al crear", "error al crear ")
                    }
                }
            },
            shape = RoundedCornerShape(corner = CornerSize(30.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.naranja_p)),
            modifier = Modifier
                .padding(end = 10.dp)
        ) {
            Text(text = "Crear Propiedad")
        }
    }
}