package br.com.codeleonel.conversormoedas.servicos;

import br.com.codeleonel.conversormoedas.estados.ConversaoEstado;
import br.com.codeleonel.conversormoedas.modelos.Conversao;

import java.util.ArrayList;
import java.util.List;

public class ConversorMoedas {

    private double valor = 0;

    private double valorConversao = 0;

    public double converterValorEntreMoedas(String codigoBase, String codigoAlvo) {

        try {

            var conversao = BuscaConversao.buscaTaxaConversaoPares(codigoBase, codigoAlvo);

            ConversaoEstado.adicionar(conversao);

            System.out.println(conversao.conversion_rate());

            valorConversao = valor * Double.parseDouble(conversao.conversion_rate());

            System.out.println(valorConversao);

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
