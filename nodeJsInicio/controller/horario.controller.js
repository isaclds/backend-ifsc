import { DataService } from "../service/data.service.js";

const service = new DataService();

export function data(req, res) {
  const data = service.data();
  return res.status(200).send({ data: data });
}

export function horario(req, res) {
  const horario = service.horario();
  return res.status(200).send({ horario: horario });
}

export function agora(req, res) {
  const agora = service.agora();
  return res.status(200).send({ agora: agora });
}
