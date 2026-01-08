package es.fpsumma.dam2.api.ui.screen.tareas

import es.fpsumma.dam2.api.model.Tarea

data class TareasUIState(
    val tareas: List<Tarea> = emptyList(), // listado tareas ahora vacio
    val loading: Boolean = false, //cargando
    val error: String? = null //errores
)
