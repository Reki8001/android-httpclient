// “BD” en memoria (para clase)
let tareas = [
  { id: 1, titulo: "Comprar pan", descripcion: "Pasar por la panadería" },
  { id: 2, titulo: "Estudiar Retrofit", descripcion: "GET/POST/PUT/DELETE" }
];

let nextId = 3;

// Validaciones sencillas
function validarTarea({ titulo, descripcion }) {
  const errores = [];

  if (titulo === undefined || titulo === null) errores.push("titulo es obligatorio");
  if (descripcion === undefined || descripcion === null) errores.push("descripcion es obligatoria");

  if (typeof titulo !== "string") errores.push("titulo debe ser string");
  if (typeof descripcion !== "string") errores.push("descripcion debe ser string");

  const t = (titulo ?? "").trim();
  const d = (descripcion ?? "").trim();

  if (t.length < 3 || t.length > 60) errores.push("titulo debe tener 3..60 caracteres");
  if (d.length < 3 || d.length > 200) errores.push("descripcion debe tener 3..200 caracteres");

  return { ok: errores.length === 0, errores, titulo: t, descripcion: d };
}

/**
 * GET /api/tareas
 * Opcional: ?q=texto (filtra por titulo/descripcion)
 */
export const listarTareas = (req, res) => {
  const { q } = req.query;

  if (!q) return res.json(tareas);

  const query = String(q).toLowerCase();
  const filtradas = tareas.filter(
    (t) =>
      t.titulo.toLowerCase().includes(query) ||
      t.descripcion.toLowerCase().includes(query)
  );

  res.json(filtradas);
};

/**
 * GET /api/tareas/:id
 */
export const obtenerTarea = (req, res) => {
  const id = Number(req.params.id);
  if (Number.isNaN(id)) return res.status(400).json({ error: "ID no válido" });

  const tarea = tareas.find((t) => t.id === id);
  if (!tarea) return res.status(404).json({ error: "Tarea no encontrada" });

  res.json(tarea);
};

/**
 * POST /api/tareas
 * Body: { titulo, descripcion }
 */
export const crearTarea = (req, res) => {
  const check = validarTarea(req.body);
  if (!check.ok) return res.status(400).json({ error: "Validación", details: check.errores });

  const nueva = {
    id: nextId++,
    titulo: check.titulo,
    descripcion: check.descripcion
  };

  tareas.push(nueva);
  res.status(201).json(nueva);
};

/**
 * PUT /api/tareas/:id
 * Body: { titulo, descripcion }
 */
export const actualizarTarea = (req, res) => {
  const id = Number(req.params.id);
  if (Number.isNaN(id)) return res.status(400).json({ error: "ID no válido" });

  const idx = tareas.findIndex((t) => t.id === id);
  if (idx === -1) return res.status(404).json({ error: "Tarea no encontrada" });

  const check = validarTarea(req.body);
  if (!check.ok) return res.status(400).json({ error: "Validación", details: check.errores });

  tareas[idx] = { id, titulo: check.titulo, descripcion: check.descripcion };
  res.json(tareas[idx]);
};

/**
 * DELETE /api/tareas/:id
 */
export const eliminarTarea = (req, res) => {
  const id = Number(req.params.id);
  if (Number.isNaN(id)) return res.status(400).json({ error: "ID no válido" });

  const idx = tareas.findIndex((t) => t.id === id);
  if (idx === -1) return res.status(404).json({ error: "Tarea no encontrada" });

  tareas.splice(idx, 1);
  res.status(204).end();
};