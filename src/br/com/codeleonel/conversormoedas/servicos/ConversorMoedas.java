package br.com.codeleonel.conversormoedas.servicos;

import br.com.codeleonel.conversormoedas.estados.HistoricoEstado;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class ConversorMoedas {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private double valor = 0;

    private double valorConversao = 0;

    private String mensagemUltimaConversao = null;

    public void converterValorEntreMoedas(String codigoBase, String codigoAlvo) {

        try {

            validaRequisicao(codigoBase, codigoAlvo);

            var conversao = BuscaConversao.buscaTaxaConversaoPares(codigoBase, codigoAlvo);

            setValorConversao(valor * Double.parseDouble(conversao.conversion_rate()));

            mensagemUltimaConversao = "O valor de %.2f [%s] para [%s] é %.2f".formatted(valor,codigoBase,codigoAlvo,valorConversao);

            HistoricoEstado.adicionar(conversao,valor,valorConversao);

        } catch (Exception e) {

            System.out.println("Não foi possível realizar conversão das moedas: " + e.getMessage());

        }

    }

    private void validaRequisicao(String codigoBase, String codigoAlvo) {

        validaParametros(codigoBase,codigoAlvo);

        verificaHistorico(codigoBase, codigoAlvo);

    }

    private void verificaHistorico(String codigoBase, String codigoAlvo) {

        var historicoConversoes = HistoricoEstado.getListaHistorico();

        if(!historicoConversoes.isEmpty()) {
            for(var historico : historicoConversoes) {

                if(historico.getConversao().base_code().equals(codigoBase)
                        && historico.getConversao().target_code().equals(codigoAlvo)
                        && historico.getValor() == valor
                        && historico.getValorConversao() == valorConversao
                        && historico.getInstante().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                    throw new RuntimeException("Já foi realizado uma mesma conversão anteriomente, consulte o histórico de conversões");
                }

            }
        }

    }

    private void validaParametros(String codigoBase, String codigoAlvo) {

        if(codigoBase == null || codigoAlvo == null) {
            throw new RuntimeException("É necessário selecionar as duas moedas para a conversão");
        }

    }

    public ConversorMoedas() {

        valor = 0.0;
        valorConversao = 0.0;

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {

        this.valor = Double.parseDouble(decimalFormat.format(valor));

    }

    private void setValorConversao(double valorConversao) {

        this.valorConversao =  Double.parseDouble(decimalFormat.format(valorConversao).replace(",","."));

    }

    public String getMensagemUltimaConversao() {
        return mensagemUltimaConversao;
    }
}
