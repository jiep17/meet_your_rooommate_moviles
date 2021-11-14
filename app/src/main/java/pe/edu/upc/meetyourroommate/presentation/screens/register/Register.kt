package pe.edu.upc.meetyourroommate.presentation.screens.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.meetyourroommate.R


@Composable
fun Register(
    navigateToStudentRegister: () -> Unit,
    navigateToLessorRegister: () -> Unit
) {
    val titles = listOf<String>("Roommate", "Lessor")
    Scaffold {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()

        ) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    text = "ÚNETE A MEET YOUR ROOMMATE",
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Elige como quieres registrarte",
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Thin,
                        textAlign = TextAlign.Center
                    )
                )
            }
            items(titles){
                title -> CardList(title,navigateToStudentRegister,navigateToLessorRegister)
            }
        }

    }
}

@Composable
fun CardList(title: String, navigateToStudentRegister: () -> Unit, navigateToLessorRegister: () -> Unit){
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 10.dp)

            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = colorResource(R.color.plomo_p),
    ) {
        Button(onClick = {
            if (title == "Roommate"){
                navigateToStudentRegister()
            }else {
                navigateToLessorRegister()
            }

        }) {
            Text(title)
        }
    }
}