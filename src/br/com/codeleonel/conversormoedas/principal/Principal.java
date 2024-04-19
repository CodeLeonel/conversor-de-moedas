package br.com.codeleonel.conversormoedas.principal;

import br.com.codeleonel.conversormoedas.cli.ComandosCli;
import br.com.codeleonel.conversormoedas.repositorios.LeitorMoedas;
import br.com.codeleonel.conversormoedas.servicos.ConversorMoedas;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        LeitorMoedas.lerArquivo("moedas.csv");
        ConversorMoedas conversorMoedas = new ConversorMoedas();
        Scanner scanner = new Scanner(System.in);
        String codigoBase = null, codigoAlvo = null;

        int opcao = -1;

        while (opcao != 0) {

            if (conversorMoedas.getValor() == 0.0) {
                ComandosCli.menuSimples();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        System.out.print("Digite um valor: ");
                        conversorMoedas.setValor(scanner.nextDouble());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            }

            if (opcao != 0 && conversorMoedas.getValor() != 0.0) {
                ComandosCli.menuCompleto(conversorMoedas.getValor(),codigoBase,codigoAlvo,conversorMoedas.getMensagemUltimaConversao());
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        System.out.print("Digite um valor: ");
                        conversorMoedas.setValor(scanner.nextDouble());
                        break;
                    case 2:
                        scanner.nextLine();
                        codigoBase = ComandosCli.escolhaMoeda(scanner);
                        break;
                    case 3:
                        scanner.nextLine();
                        codigoAlvo = ComandosCli.escolhaMoeda(scanner);
                        break;
                    case 4:
                        conversorMoedas.converterValorEntreMoedas(codigoBase, codigoAlvo);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            }

        }


    }

}
