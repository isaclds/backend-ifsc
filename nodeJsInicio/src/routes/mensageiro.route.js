import { Router } from "express";
import {
  acessaMensagem,
  publicaMensagem,
} from "../controller/mensageiro.controller.js";

const routes = Router();

routes.post("/publica/:chave", publicaMensagem);
routes.post("/acessa/:chave", acessaMensagem);

export default routes;
