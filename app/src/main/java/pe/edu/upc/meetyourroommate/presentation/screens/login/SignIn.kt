package pe.edu.upc.meetyourroommate.presentation.screens.login

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.model.User
import pe.edu.upc.meetyourroommate.data.remote.rest_api.RestApiUserService
import pe.edu.upc.meetyourroommate.data.useful.EmailState
import pe.edu.upc.meetyourroommate.data.useful.PasswordState

@Composable
fun SignIn(
    navigateHome: () -> Unit,
    navigateRegister: () ->Unit,
    changeUser: (usuario: User) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.sign_in),
            style = MaterialTheme.typography.h4,
            fontWeight= FontWeight.Bold
        )
        SignInScreen(modifier= Modifier.fillMaxWidth()) {
            SignInContent(navigateHome,navigateRegister, changeUser)
        }
    }
}

@Composable
fun SignInContent(
    navigateHome: () -> Unit,
    navigateRegister: () -> Unit,
    changeUser: (usuario: User) -> Unit
) {
    val apiService = RestApiUserService()
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val focusRequester = remember { FocusRequester() }
        val emailState = remember { EmailState() }
        Email(emailState = emailState, onImeAction = {focusRequester.requestFocus()})
        
        Spacer(modifier = Modifier.height(16.dp))

        val passwordState = remember { PasswordState() }
        Password(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            modifier = Modifier.focusRequester(focusRequester),
            onImeAction = {  } // una funcion cuando password y mail sean validos
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                apiService.loginUser(emailState.text, passwordState.text) {
                    if (it?.id != null) {
                        changeUser(it)
                        navigateHome()
                    }
                    else {
                        Log.d("Error al logear", "error al logear ")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            enabled = emailState.isValid && passwordState.isValid
        ) {
            Text(text = stringResource(id = R.string.sign_in))
        }

        Button(
            onClick = {
                navigateRegister()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            Text(text = "Register")
        }

    }
}
