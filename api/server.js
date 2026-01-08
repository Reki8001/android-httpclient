import express from "express";
import cors from "cors";
import tareasRouter from "./routes/tareas.routes.js";

const app = express();

// Para que Android (emulador) pueda llamar a la API sin problemas
app.use(cors());

// Parseo de JSON en body
app.use(express.json());

// Healthcheck (útil para comprobar que vive)
app.get("/api/health", (req, res) => {
  res.json({ ok: true, name: "tareas-api" });
});

// Rutas de tareas
app.use("/api/tareas", tareasRouter);

// 404 genérico
app.use((req, res) => {
  res.status(404).json({ error: "Ruta no encontrada" });
});

// Manejo de errores
app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).json({ error: "Error interno del servidor" });
});

const PORT = process.env.PORT ?? 3000;
app.listen(PORT, () => {
  console.log(`✅ API escuchando en http://localhost:${PORT}`);
  console.log(`✅ Health: http://localhost:${PORT}/api/health`);
});