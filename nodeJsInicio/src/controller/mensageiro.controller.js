import { Mensageiro } from "../service/mensageiro.service.js";

const service = new Mensageiro();

export async function publicaMensagem(req, res) {
  try {
    const chave = req.params.chave;
    const mensagem = req.body.mensagem;
    const result = service.publica(chave, mensagem);
  } catch (error) {}
}

export async function acessaMensagem(req, res) {
  try {
    const chave = req.params.chave;
    const result = service.acessa(chave);
  } catch (error) {}
}
