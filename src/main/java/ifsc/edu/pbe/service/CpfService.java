package ifsc.edu.pbe.service;

import org.springframework.stereotype.Service;

@Service
public class CpfService {
    public boolean isValido(String cpf) {
        if (cpf == null) {
            return false;
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        if (cpfLimpo.length() != 11) {
            return false;
        }

        if (cpfLimpo.chars().distinct().count() == 1) {
            return false;
        }

        int[] digitos = cpfLimpo.chars()
                .map(c -> c - '0')
                .toArray();

        int primeiroDigito = calcularDigito(digitos, 9, 10);
        if (primeiroDigito != digitos[9]) {
            return false;
        }

        int segundoDigito = calcularDigito(digitos, 10, 11);
        return segundoDigito == digitos[10];
    }

    private int calcularDigito(int[] digitos, int quantidade, int pesoInicial) {
        int soma = 0;
        int peso = pesoInicial;

        for (int i = 0; i < quantidade; i++) {
            soma += digitos[i] * peso;
            peso--;
        }

        int resto = (soma * 10) % 11;
        return (resto == 10) ? 0 : resto;
    }
}
