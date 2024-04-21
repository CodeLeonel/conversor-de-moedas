package br.com.codeleonel.conversormoedas.principal;

public class TesteVariavelAmbiente {

    public static void main(String[] args) {

        String variavelAmbiente = System.getenv("apiKeyER");

        System.out.println(variavelAmbiente);

    }

}
