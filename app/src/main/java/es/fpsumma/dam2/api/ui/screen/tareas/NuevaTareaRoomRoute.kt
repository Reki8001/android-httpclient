package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel,
    modifier: Modifier = Modifier,
) {
    val state by vm.state.collectAsState()

    NuevaTareaContent(
        state = state, // si x= algo falla es porque debe pasarse como x=x como en el examen vm=vm
        onBack = {
            navController.popBackStack()
        },
        onSave = {titulo: String, descripcion: String ->
            vm.addTarea(titulo, descripcion)
            navController.navigate(Routes.TAREA_LISTADO)
        },
        modifier = Modifier
    )
}