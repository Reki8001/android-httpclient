package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import es.fpsumma.dam2.api.model.Tarea
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel


@Composable
fun ListadoTareasRoomRoute(
    navController: NavController,
    vm: TareasViewModel,
    modifier: Modifier = Modifier,
) {
    val state by vm.state.collectAsState() //<- Porque solo se usa en listar? Que hace esto?

    ListadoTareasContent(
        state = state, // si x= algo falla es porque debe pasarse como x=x como en el examen vm=vm
        onBack = {
            navController.popBackStack()
        },
        onAdd = {
            navController.navigate(Routes.TAREA_ADD)
        },
        onOpenDetalle = { id ->
            navController.navigate(Routes.tareaView(id))
        },
        onDelete = { id ->
            vm.deleteTareaById(id)
        },
        modifier = Modifier
    )
}
