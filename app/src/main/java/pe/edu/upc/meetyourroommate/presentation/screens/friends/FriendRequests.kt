package pe.edu.upc.meetyourroommate.presentation.screens.friends

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.FriendRequest
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.remote.rest_api.RestApiFriendRequestService
import pe.edu.upc.meetyourroommate.data.remote.rest_api.RestApiStudentService

@Composable
fun FriendRequest(
    usuario: User
) {
    var friendRequests by remember {
        mutableStateOf(listOf<FriendRequest>())
    }
    val friendRequestService = RestApiFriendRequestService()
    friendRequestService.getFriendRequestByReceivedId(usuario.id!!) {
        friendRequests = it.friendRequests
    }

    Scaffold (
        backgroundColor = colorResource(R.color.piel_p)
    ){
        FriendRequestList(friendRequests, usuario)
    }
}

@Composable
fun FriendRequestList(friendRequests: List<FriendRequest>, usuario: User) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Solicitudes de Amistad",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )
            )
        }
        items(friendRequests) {
                friendRequest -> ItemFriendRequestRow(friendRequest, usuario)
        }
    }
}

@Composable
fun ItemFriendRequestRow(friendRequest: FriendRequest, usuario: User) {
    if (friendRequest.status == 3) {
        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = colorResource(R.color.plomo_p),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ){
            var student by remember {
                mutableStateOf(Student())
            }
            val studentService = RestApiStudentService()
            studentService.fetchStudent(friendRequest.studentSendId) {
                student = it!!
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                val openDialogFriendRequest = remember { mutableStateOf(false)}
                val openDialogFriendRequestRechazar = remember { mutableStateOf(false)}

                Image(
                    painter = painterResource(id = R.drawable.im_person_anonimo),
                    contentDescription = "Imagen del estudiante",
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = student.firstName + " " + student.lastName,
                        color = colorResource(R.color.red_p),
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row {
                        Button(
                            onClick = {
                                openDialogFriendRequest.value = true

                            },
                            shape = RoundedCornerShape(corner = CornerSize(24.dp)),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.naranja_p)),
                            modifier = Modifier
                                .padding(end = 10.dp)
                        ) {
                            Text(text = "Confirmar")
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Button(
                            onClick = {
                                openDialogFriendRequestRechazar.value = true
                            },
                            shape = RoundedCornerShape(corner = CornerSize(24.dp)),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.naranja_p)),
                            modifier = Modifier
                                .padding(end = 10.dp)
                        ) {
                            Text(text = "Rechazar")
                        }
                    }

                }

                val friendRequestService =RestApiFriendRequestService()

                if(openDialogFriendRequest.value) {
                    AlertDialog(
                        onDismissRequest = {
                            openDialogFriendRequest.value = false
                        },
                        text = {
                            Text("¿Deseas confirmar la solicitud de amistad a " + student.firstName + "?")
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    friendRequestService.acceptFriendRequest("accept", student.id, usuario.id!!) {
                                        if(it?.status == 1) {
                                            Log.d("FriendRequest Accept", "Solicitud aceptada")
                                        }
                                        else{
                                            Log.d("FriendRequest error", "No se aceptar la solicitud")
                                        }
                                    }
                                    openDialogFriendRequest.value = false
                                }) {
                                Text("Confirmar")
                            }
                        },
                        dismissButton = {
                            Button(
                                onClick = {
                                    openDialogFriendRequest.value = false
                                }) {
                                Text("Cancelar")
                            }
                        }
                    )
                }
                if(openDialogFriendRequestRechazar.value) {
                    AlertDialog(
                        onDismissRequest = {
                            openDialogFriendRequestRechazar.value = false
                        },
                        text = {
                            Text("¿Deseas rechazar la solicitud de amistad de " + student.firstName + "?")
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    friendRequestService.acceptFriendRequest("rechazar", student.id, usuario.id!!) {
                                        if(it?.status == 1) {
                                            Log.d("FriendRequest Accept", "Solicitud aceptada")
                                        }
                                        else{
                                            Log.d("FriendRequest error", "No se aceptar la solicitud")
                                        }
                                    }
                                    openDialogFriendRequestRechazar.value = false
                                }) {
                                Text("Confirmar")
                            }
                        },
                        dismissButton = {
                            Button(
                                onClick = {
                                    openDialogFriendRequestRechazar.value = false
                                }) {
                                Text("Cancelar")
                            }
                        }
                    )
                }
            }
        }
    }
}