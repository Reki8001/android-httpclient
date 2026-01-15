package es.fpsumma.dam2.api.ui.screen.tareas

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalleTareaRoomRoute(
    id:Int,
    navController: NavController,
    vm: TareasViewModel,
    modifier: Modifier=Modifier,
) {
    val tareaFlow = remember(id) { vm.getTarea(id) }
    val tarea by tareaFlow.collectAsStateWithLifecycle(initialValue = null)
    DetalleTareaContent(
         // si x= algo falla es porque debe pasarse como x=x como en el examen vm=vm
        onBack = {
            navController.popBackStack()
        },
        onSave = { titulo: String, descripcion: String ->
            vm.updateTarea(id, titulo, descripcion)
            navController.navigate(Routes.TAREA_LISTADO)
        },
        tarea = tarea,
        modifier = Modifier,
    )
}