package br.com.codeleonel.conversormoedas.principal;

public class Teste {

    public static void main(String[] args) {

        String variavelAmbiente = System.getenv("apiKeyER");

        System.out.println(variavelAmbiente);

        String texto = "1000.00";

        double numero = Double.valueOf(texto);

    }

}
