package es.fpsumma.dam2.api.ui.screen.tareas

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import es.fpsumma.dam2.api.model.Tarea
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalleTareaContent(
    id:Int,
    tarea: Tarea?,
    state: TareasUIState,
    onBack: () -> Unit,
    onSave: (String, String) -> Unit,
    modifier: Modifier
) {

}