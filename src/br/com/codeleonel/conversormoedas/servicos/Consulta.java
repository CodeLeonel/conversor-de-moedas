package br.com.codeleonel.conversormoedas.servicos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    private HttpClient cliente;

    public Consulta() {

        cliente = HttpClient.newHttpClient();

    }

    public String viaHttp(URI uri) {

        try{

            HttpRequest requisicao = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> resposta = cliente.send(requisicao,
                    HttpResponse.BodyHandlers.ofString());

            return resposta.body();

        } catch (Exception e) {
            System.out.println("Não foi possível realizar requisição: " + e.getMessage());
        }

        return null;

    }


}
