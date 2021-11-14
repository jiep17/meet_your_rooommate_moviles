package pe.edu.upc.meetyourroommate.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pe.edu.upc.meetyourroommate.R

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    TopAppBar(
        title = { Text(LocalContext.current.getString(R.string.app_name))},
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    // Ejecuta esta tarea en una tarea de fondo y no este relacinado a la interfaz de usuario y no se lagee
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")
            }
        },
        actions = {
            IconButton(onClick = {
                // TODO: Display SnackBar
            }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
            }
        },
        backgroundColor = colorResource(R.color.red_p)
    )
}