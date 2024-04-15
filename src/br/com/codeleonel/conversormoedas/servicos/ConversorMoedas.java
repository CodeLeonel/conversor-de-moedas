package br.com.codeleonel.conversormoedas.servicos;

import br.com.codeleonel.conversormoedas.estados.ConversaoEstado;
import br.com.codeleonel.conversormoedas.modelos.Conversao;

import java.util.ArrayList;
import java.util.List;

public class ConversorMoedas {

    private double valor;

    private double valorConversao;

    public double converterValorEntreMoedas(String codigoBase, String codigoAlvo) {

        try {

            var conversao = BuscaConversao.buscaTaxaConversaoPares(codigoBase, codigoAlvo);

            ConversaoEstado.adicionar(conversao);

            valorConversao = valor * Double.parseDouble(conversao.conversion_rate());

        } catch (Exception e) {

            System.out.println("Não foi possível realizar conversão das moedas");

        }
        return valorConversao;

    }

    public ConversorMoedas() {

        valor = 0.0;
        valorConversao = 0.0;

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorConversao() {
        return valorConversao;
    }
}
