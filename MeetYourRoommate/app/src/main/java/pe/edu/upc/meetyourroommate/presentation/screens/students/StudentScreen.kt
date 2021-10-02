package pe.edu.upc.meetyourroommate.presentation.screens.students

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StudentScreen(
    studentId: Int
) {
    Text(text = studentId.toString())
}