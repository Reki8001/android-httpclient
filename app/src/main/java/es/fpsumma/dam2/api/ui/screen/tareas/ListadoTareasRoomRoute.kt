package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun ListadoTareasRoomRoute(navController: NavController) {
    val vm: TareasViewModel = viewModel()
    val state by vm.state.collectAsState()

    ListadoRoutes(
        tareas = state.tareas,
        onAgregar = { navController.navigate(Routes.ADD) },           // ← Aquí SÍ se navega
        onVerDetalle = { id -> navController.navigate(Routes.detalle(id)) } // ← Aquí SÍ se navega
    )
}

@Composable
fun ListadoRoutes(tareas: List<Tarea>, onAgregar: () -> ERROR, onVerDetalle: (ERROR) -> ERROR) {
    TODO("Not yet implemented")
}