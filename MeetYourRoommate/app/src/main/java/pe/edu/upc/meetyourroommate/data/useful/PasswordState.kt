package pe.edu.upc.meetyourroommate.data.useful

class PasswordState
    :TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError)

// :: metodo de referencia que usa kotlin

private fun isPasswordValid(password: String) = password.length>8

@Suppress("UNUSED_PARAMETER")
private fun passwordValidationError(password: String) = "Invalid Password"