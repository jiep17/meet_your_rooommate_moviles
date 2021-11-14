package pe.edu.upc.meetyourroommate.presentation.screens.register

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import pe.edu.upc.meetyourroommate.data.model.Student
import pe.edu.upc.meetyourroommate.data.model.saving.SaveStudent
import pe.edu.upc.meetyourroommate.data.remote.ApiClient
import pe.edu.upc.meetyourroommate.data.remote.responses.StudentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun StudentRegister(
    navigateHome: () -> Unit,
) {
    val name = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val dni = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val birthdate = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val hobbies = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val campusId = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    var smoker = false
    var premium = false
    var searching = true

    val studentService = ApiClient.buildStudent()


    Scaffold {
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            item {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Name") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = lastName.value,
                    onValueChange = { lastName.value = it },
                    label = { Text("Last name") }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = dni.value,
                    onValueChange = { dni.value = it },
                    label = { Text("Dni") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = phoneNumber.value,
                    onValueChange = { phoneNumber.value = it },
                    label = { Text("Phone Number") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = gender.value,
                    onValueChange = { gender.value = it },
                    label = { Text("Gender") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = birthdate.value,
                    onValueChange = { birthdate.value = it },
                    label = { Text("Birthdate") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = address.value,
                    onValueChange = { address.value = it },
                    label = { Text("Address") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = description.value,
                    onValueChange = { description.value = it },
                    label = { Text("Description") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = hobbies.value,
                    onValueChange = { hobbies.value = it },
                    label = { Text("Hobbies") }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Email") }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password.value,
                    onValueChange = { password.value = it },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text("Password") }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = confirmPassword.value,
                    onValueChange = { confirmPassword.value = it },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text("Password") }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = campusId.value,
                    onValueChange = { campusId.value = it },
                    label = { Text("Campus Id") }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    onClick =
                    {
                        val createStudent = studentService.createStudent(
                        SaveStudent(
                            name.value,
                            lastName.value,
                            dni.value,
                            phoneNumber.value,
                            gender.value,
                            birthdate.value,
                            address.value,
                            description.value,
                            hobbies.value,
                            smoker,
                            searching,
                            premium,
                            email.value,
                            password.value),
                            campusId.value.toInt()
                        )

                        createStudent.enqueue(object: Callback<Student> {

                            override fun onFailure(call: Call<Student>, t: Throwable) {
                                Log.d("StudentComposeError", t.toString())
                            }

                            override fun onResponse(call: Call<Student>, response: Response<Student>) {
                                if(response.isSuccessful) {
                                    navigateHome()
                                }
                            }

                        })
                    }) {
                    Text("Sign up")
                }
            }
        }
    }
}