import { Router } from "express";
import {
  listarTareas,
  obtenerTarea,
  crearTarea,
  actualizarTarea,
  eliminarTarea
} from "../controllers/tareas.controller.js";

const router = Router();

router.get("/", listarTareas);
router.get("/:id", obtenerTarea);
router.post("/", crearTarea);
router.put("/:id", actualizarTarea);
router.delete("/:id", eliminarTarea);

export default router;