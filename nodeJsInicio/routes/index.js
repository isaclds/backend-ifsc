import { Router } from "express";

import { helloWorld } from "../controller/index.js";
import { data, horario, agora } from "../controller/horario.controller.js";

const routes = Router();

routes.get("/", helloWorld);

routes.get("/data", data);
routes.get("/horario", horario);
routes.get("/agora", agora);

export default routes;
