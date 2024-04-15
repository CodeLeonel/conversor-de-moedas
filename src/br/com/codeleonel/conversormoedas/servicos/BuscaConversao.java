package br.com.codeleonel.conversormoedas.servicos;

import br.com.codeleonel.conversormoedas.modelos.Conversao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BuscaConversao {

    private static Gson gson = new Gson();

    public static Conversao buscaTaxaConversaoPares(String codigoBase, String codigoAlvo) {

        try {

            String resposta = ConsultaHTTP.viaHttp(MontadorURI.taxaConversaoPares(codigoBase, codigoAlvo));

            var conversao = gson.fromJson(resposta, Conversao.class);

            return conversao;

        } catch (Exception e) {
            
            System.out.println("Não foi possível buscar a taxa de conversão das moedas: " + e.getMessage());
        
        }

        return null;

    }


}
