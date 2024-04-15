package br.com.codeleonel.conversormoedas.servicos;

import java.net.URI;

public class MontadorURI {

    public static URI taxaConversaoPares(String codBase, String codAlvo) {

        String chave = null;
        String novoUri = null;
        URI uri = null;

        try {

            chave = System.getenv("apiKeyER");

            novoUri = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s".formatted(chave, codBase, codBase);

            uri = URI.create(novoUri);

        } catch (Exception e) {

            System.out.println("Não foi possíel montar a URI: " + e.getMessage());

        }

        return uri;

    }

}
