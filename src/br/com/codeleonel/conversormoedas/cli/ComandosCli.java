package br.com.codeleonel.conversormoedas.cli;

import br.com.codeleonel.conversormoedas.estados.MoedaEstado;

import java.util.Scanner;

public class ComandosCli {

    public static void titulo() {

        System.out.println("CONVERSOR DE MOEDAS");

    }

    public static void primeirasOpcoes() {

        System.out.println("""
                            1 - Insira um valor
                            0 - Sair
                            Digite uma opção: """);

    }

    public static void opcoesCompletas() {

        System.out.println("""
                            1 - Insira um valor
                            2 - Escolha a moeda base
                            3 - Escolha a moeda alvo
                            4 - Converter o valor
                            0 - Sair
                            Digite uma opção: """);

    }



    public static void menuSimples() {

        limparConsole();
        titulo();
        primeirasOpcoes();

    }

    public static void menuCompleto() {

        limparConsole();
        titulo();
        opcoesCompletas();

    }

    public static String escolhaMoeda(Scanner scanner) {

        var listaMoedas = MoedaEstado.getListaMoedas();

        String codigoMoeda = null;

        int i = 0;
        int max = 6;
        int opcaoIntSubMenu = 0;

        i = 1;

        while(true) {

            exibeListaEmParte(i,max);

            if(max == 6) {
                System.out.println("Digite a opção de uma moeda (ou A - Avançar): ");
            } else if(max > 6 && max < listaMoedas.size()) {
                System.out.println("Digite a opção de uma moeda (ou A - Avançar ou R - Recuar): ");
            } else if(max == listaMoedas.size()) {
                System.out.println("Digite a opção de uma moeda (ou R - Recuar): ");
            }

            String opcaoSubMenu = scanner.nextLine();

            if(opcaoSubMenu.equals("A")) {
                if(max < listaMoedas.size()) {
                    i += 6;
                    max += 6;
                }

            } else if(opcaoSubMenu.equals("R")) {
                if(max > 6 && max <= listaMoedas.size()) {
                    i -= 6;
                    max -= 6;
                }

            } else {

                try {

                    opcaoIntSubMenu = Integer.parseInt(opcaoSubMenu);

                    var item = listaMoedas.get(opcaoIntSubMenu);

                    codigoMoeda = item.getCodigo();
                    break;

                } catch (Exception e) {

                    System.out.println("Opção inserida apresentou erro: " + e.getMessage());

                }
            }

        }


        return codigoMoeda;
    }


    public static void exibeListaEmParte(int inicio, int fim){

        var lista = MoedaEstado.getListaMoedas();

        while (inicio < fim) {

            System.out.println(inicio + " - " + lista.get(inicio));

            inicio++;
        }

    }

    public static void limparConsole() {

        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            System.out.println("Ocorreu problema para limpar o console: " + e.getMessage());
        }
    }

}
