package br.com.codeleonel.conversormoedas.modelos;

import java.time.LocalDateTime;

public class Historico {

    private Conversao conversao;
    private Double valor;
    private Double valorConversao;
    private LocalDateTime instante;

    public Historico(Conversao conversao, Double valor, Double valorConversao, LocalDateTime instante) {
        this.conversao = conversao;
        this.valor = valor;
        this.valorConversao = valorConversao;
        this.instante = instante;
    }

    @Override
    public String toString() {
        return "%.2f [%s] -> [%s] = %.2f ".formatted(
                valor,conversao.base_code(),conversao.target_code(),valorConversao)
                + " " + instante;
    }

    public String fichaCompleta() {
        return "Moeda base: " + conversao.base_code() + "\n"
                + "Moeda alvo: " + conversao.target_code() + "\n"
                + "Valor: %.2f".formatted(valor) + "\n"
                + "Valor convertido: %.2f".formatted(valorConversao) + "\n"
                + "Taxa de conversão: %s".formatted(conversao.conversion_rate()) + "\n"
                + "Horário da conversão: " + instante + "\n"
                + "Horário da última atualização da taxa: " + conversao.time_last_update_utc() + "\n"
                + "Horário da próxima atualização da taxa: " + conversao.time_next_update_utc();
    }

    public Conversao getConversao() {
        return conversao;
    }

    public Double getValor() {
        return valor;
    }

    public Double getValorConversao() {
        return valorConversao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
