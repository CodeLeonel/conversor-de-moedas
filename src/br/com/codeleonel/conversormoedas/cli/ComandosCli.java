package br.com.codeleonel.conversormoedas.cli;

import br.com.codeleonel.conversormoedas.estados.HistoricoEstado;
import br.com.codeleonel.conversormoedas.estados.MoedaEstado;
import br.com.codeleonel.conversormoedas.modelos.Moeda;

import java.util.Scanner;

public class ComandosCli {

    public static void titulo() {

        System.out.println("CONVERSOR DE MOEDAS");

    }

    public static void opcoesCompletas(double valor, String moedaBase, String moedaAlvo) {

        String menu = null;
        var historicoVazio = HistoricoEstado.getListaHistorico().isEmpty();

        if (valor == 0.0 && moedaBase == null && moedaAlvo == null && historicoVazio) {

            menu = """
                    1 - Insira um valor
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor == 0.0 && moedaBase == null && moedaAlvo == null && !historicoVazio) {

            menu = """
                    1 - Insira um valor
                    5 - Histórico de conversões
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor > 0.0 && moedaBase == null && moedaAlvo == null && historicoVazio) {

            menu = """
                    1 - Insira um valor
                    2 - Escolha a moeda base
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor > 0.0 && moedaBase == null && moedaAlvo == null && !historicoVazio) {

            menu = """
                    1 - Insira um valor
                    2 - Escolha a moeda base
                    5 - Histórico de conversões
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor > 0.0 && moedaBase != null && moedaAlvo == null && historicoVazio) {

            menu = """
                    1 - Insira um valor
                    2 - Escolha a moeda base
                    3 - Escolha a moeda alvo
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor > 0.0 && moedaBase != null && moedaAlvo == null && !historicoVazio) {

            menu = """
                    1 - Insira um valor
                    2 - Escolha a moeda base
                    3 - Escolha a moeda alvo
                    5 - Histórico de conversões
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor > 0.0 && moedaBase != null && moedaAlvo != null && historicoVazio) {

            menu = """
                    1 - Insira um valor
                    2 - Escolha a moeda base
                    3 - Escolha a moeda alvo
                    4 - Converter o valor
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        } else if (valor > 0.0 && moedaBase != null && moedaAlvo != null && !historicoVazio) {

            menu = """
                    1 - Insira um valor
                    2 - Escolha a moeda base
                    3 - Escolha a moeda alvo
                    4 - Converter o valor
                    5 - Histórico de conversões
                    6 - Sobre o programa
                    0 - Sair
                    Digite uma opção:  """;

        }


        System.out.print(menu);

    }

    public static void exibeVariaveis(double valor, String moedaBase, String moedaAlvo, String mensagemConversao) {

        System.out.println(" ");

        if (valor > 0.0) {
            System.out.printf("VALOR: %.2f%n", valor);
        }

        if (moedaBase != null && !moedaBase.isBlank()) {
            System.out.println("MOEDA BASE: [" + moedaBase + "]");
        }

        if (moedaAlvo != null && !moedaAlvo.isBlank()) {
            System.out.println("MOEDA ALVO: [" + moedaAlvo + "]");
        }

        if (mensagemConversao != null && !mensagemConversao.isBlank()) {
            System.out.println(mensagemConversao);
        }

        System.out.println(" ");

    }


    public static void menuCompleto(double valor, String moedaBase, String moedaAlvo, String mensagem) {

        limparConsole();
        titulo();
        exibeVariaveis(valor, moedaBase, moedaAlvo, mensagem);
        opcoesCompletas(valor, moedaBase, moedaAlvo);


    }

    public static String escolhaMoeda(Scanner scanner) {

        var listaMoedasFiltradas = MoedaEstado.getListaMoedas().stream().filter(Moeda::getAluraFilter).toList();

        String codigoMoeda = null;

        while (true) {

            for (int i = 0; i < listaMoedasFiltradas.size(); i++) {

                System.out.println((i + 1) + " - " + listaMoedasFiltradas.get(i));

            }

            System.out.print("Digite opção de uma moeda (ou M para mais moedas): ");
            String opcaoMenuMoedas = scanner.nextLine();

            if (opcaoMenuMoedas.equals("M")) {

                return escolhaMoedaListaCompleta(scanner);

            } else {

                try {

                    int opcaoIntMenuMoedas = Integer.parseInt(opcaoMenuMoedas) - 1;

                    var item = listaMoedasFiltradas.get(opcaoIntMenuMoedas);

                    codigoMoeda = item.getCodigo();
                    break;

                } catch (Exception e) {

                    System.out.println("Opção inserida apresentou erro: " + e.getMessage());

                }
            }

        }

        return codigoMoeda;

    }

    public static String escolhaMoedaListaCompleta(Scanner scanner) {

        var listaMoedas = MoedaEstado.getListaMoedas();

        String codigoMoeda = null;

        int i = 0;
        int max = 6;
        int opcaoIntSubMenu = 0;

        i = 1;

        while (true) {

            exibeListaEmParte(i, max);

            if (max == 6) {
                System.out.print("Digite a opção de uma moeda (ou A - Avançar): ");
            } else if (max > 6 && max < listaMoedas.size()) {
                System.out.print("Digite a opção de uma moeda (ou A - Avançar ou R - Recuar): ");
            } else if (max == listaMoedas.size()) {
                System.out.print("Digite a opção de uma moeda (ou R - Recuar): ");
            }

            String opcaoSubMenu = scanner.nextLine();

            if (opcaoSubMenu.equals("A")) {
                if (max < listaMoedas.size()) {
                    i += 6;
                    max += 6;
                }

            } else if (opcaoSubMenu.equals("R")) {
                if (max > 6 && max <= listaMoedas.size()) {
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


    public static void exibeListaEmParte(int inicio, int fim) {

        var lista = MoedaEstado.getListaMoedas();

        while (inicio < fim) {

            System.out.println(inicio + " - " + lista.get(inicio));

            inicio++;
        }

    }

    public static void limparConsole() {

        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("Ocorreu problema para limpar o console: " + e.getMessage());
        }
    }

}
