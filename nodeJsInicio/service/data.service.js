export class DataService {
  constructor() {
    this.hoje = new Date();
  }

  data() {
    const hoje = new Date();
    const dataFormatada = hoje.toLocaleDateString("pt-BR", {
      month: "2-digit",
      day: "2-digit",
      year: "numeric",
    });
    return dataFormatada;
  }

  horario() {
    const hoje = new Date();
    const horarioFormatado = hoje.toLocaleTimeString("pt-BR", {
      hour12: false,
    });
    return horarioFormatado;
  }

  agora() {
    const agora = `${this.horario()} ${this.data()}`;
    return agora;
  }
}
