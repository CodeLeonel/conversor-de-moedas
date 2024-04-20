package br.com.codeleonel.conversormoedas.principal;

public class TesteVariaelAmbiente {

    public static void main(String[] args) {

        String variavelAmbiente = System.getenv("apiKeyER");

        System.out.println(variavelAmbiente);

    }

}
