package pe.edu.upc.meetyourroommate.presentation.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pe.edu.upc.meetyourroommate.R

@Composable
fun AlertDialogBoxs() {
    // Open the Dialog box
    var openDialog by remember{mutableStateOf(true)}
    // Set Dialog
    if(openDialog) {
        AlertDialog(
            modifier = Modifier.fillMaxWidth()
                .padding(15.dp),
            onDismissRequest = { openDialog = false },
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .background(
                            color = colorResource(R.color.red_p),
                            shape = RoundedCornerShape(25.dp)
                        )
                ){
                    Icon(painter = painterResource(id = R.drawable.ic_adb), contentDescription = "Android")
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Error al iniciar sesion",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            },
            text = {
                Text(text = "Correo o contraseña incorrecta",
                    color = Color.White)
            },
            confirmButton = {
                TextButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.naranja_p),
                            shape = CircleShape
                        ),
                    onClick = {openDialog = false}
                ) {
                    Text(text = "Confirm",
                        color = Color.White
                    )
                }
            },
            dismissButton = {
//            TextButton(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(
//                        color = colorResource(id = R.color.naranja_p),
//                        shape = CircleShape
//                    ),
//                onClick = {openDialog.value = false}
//            ) {
//                Text(text = "Dimiss"
//            }
            },

            backgroundColor = colorResource(id = R.color.piel_p),
            contentColor = colorResource(id = R.color.plomo_p),
            shape = RoundedCornerShape(25.dp)
        )
    }

}