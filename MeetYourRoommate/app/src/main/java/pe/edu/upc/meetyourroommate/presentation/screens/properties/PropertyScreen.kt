package pe.edu.upc.meetyourroommate.presentation.screens.properties

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.Lessor
import pe.edu.upc.meetyourroommate.data.model.Property
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun PropertyScreen(
    propertyId: Int
) {
    var property by remember { mutableStateOf(Property()) }
    var lessor by remember { mutableStateOf(Lessor()) }

    val propertyService = ApiClient.buildProperty()
    val fetchPropertyById = propertyService.fetchPropertyById(propertyId)

    // FETCH PROPERTY

    fetchPropertyById.enqueue(object : Callback<Property>{
        override fun onResponse(call: Call<Property>, response: Response<Property>) {
            if(response.isSuccessful && response.body() != null) {
                property = response.body()!!
            }
        }

        override fun onFailure(call: Call<Property>, t: Throwable) {
            Log.d("PropertyScreenError", t.toString())
        }
    })

    // FETCH LESSOR

    val lessorService = ApiClient.buildLessor()
    val fetchLessorById = lessorService.fetchLessorById(property.lessorId)

    fetchLessorById.enqueue(object : Callback<Lessor>{
        override fun onResponse(call: Call<Lessor>, response: Response<Lessor>) {
            if(response.isSuccessful && response.body() != null) {
                lessor = response.body()!!
            }
        }

        override fun onFailure(call: Call<Lessor>, t: Throwable) {
            Log.d("PropertyScreenError", t.toString())
        }


    })

    LazyColumn() {
        item {
            PropertyRow(property, lessor)
        }
    }
}

@Composable
fun PropertyRow(
    property: Property,
    lessor: Lessor
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface{
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                PropertyHeader(property = property, containerHeigh = 800.dp)
                PropertyContent(property = property)
                DescriptionLessor(lessor = lessor)
            }
        }
    }
}

@Composable
fun PropertyHeader(
    property: Property,
    containerHeigh : Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeigh / 2)
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.i_department_default),
        contentDescription = "Imagen del Departamento",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PropertyContent(
    property: Property
) {
    Column {
        PropertyProperty(label = stringResource(id = R.string.property_description), value = property.description)
        PropertyProperty(label = stringResource(id = R.string.property_address), value = property.address)
        PropertyProperty(label = stringResource(id = R.string.property_price), value = property.price.toString())

        Spacer(modifier = Modifier.height((20.dp).coerceAtLeast(0.dp)))

    }
}

@Composable
fun PropertyProperty(label: String, value: String) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
fun DescriptionLessor(lessor: Lessor) {
    Card(
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(2.dp, Color.Black),
        elevation = 12.dp
    ){
        Column(
            modifier = Modifier.padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = lessor.firstName + " " + lessor.lastName,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Sexo: "+lessor.gender,
                modifier = Modifier.height(24.dp),
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Visible
            )
            Text(
                text = "Contacto: " + lessor.phoneNumber,
                modifier = Modifier.height(24.dp),
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Visible
            )
            Text(
                text = "Documento: "+lessor.dni,
                modifier = Modifier.height(24.dp),
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Visible
            )
        }
    }

}
