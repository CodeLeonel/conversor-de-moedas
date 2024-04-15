package br.com.codeleonel.conversormoedas.servicos;

import br.com.codeleonel.conversormoedas.modelos.Conversao;

import java.util.ArrayList;
import java.util.List;

public class ConversorMoedas {

    private List<Conversao> conversoes = new ArrayList<>();

    private double valor;

    public double converterMoedas(String codigoBase, String codigoAlvo) {

        var conversao = BuscaConversao.buscaTaxaConversaoPares(codigoBase,codigoAlvo);

        conversoes.add(conversao);

        return valor * Double.parseDouble(conversao.conversion_rate());

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
