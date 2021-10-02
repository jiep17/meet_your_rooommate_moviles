package pe.edu.upc.meetyourroommate.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.edu.upc.meetyourroommate.R
import pe.edu.upc.meetyourroommate.data.useful.EmailState
import pe.edu.upc.meetyourroommate.data.useful.PasswordState

@Composable
fun SignIn(
    navigateHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.sign_in),
        style = MaterialTheme.typography.h4,
        fontWeight= FontWeight.Bold
        )
        SignInScreen(modifier= Modifier.fillMaxWidth()) {
            SignInContent(navigateHome)
        }
    }
}

@Composable
fun SignInContent(
    navigateHome: () -> Unit
) {
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
                navigateHome()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            enabled = emailState.isValid && passwordState.isValid
        ) {
            Text(text = stringResource(id = R.string.sign_in))
        }
    }
}