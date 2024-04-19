package br.com.codeleonel.conversormoedas.principal;

import br.com.codeleonel.conversormoedas.cli.ComandosCli;
import br.com.codeleonel.conversormoedas.modelos.Moeda;
import br.com.codeleonel.conversormoedas.estados.MoedaEstado;
import br.com.codeleonel.conversormoedas.repositorios.LeitorMoedas;
import br.com.codeleonel.conversormoedas.servicos.ConversorMoedas;

import java.util.List;
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
                ComandosCli.menuCompleto();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        System.out.print("Digite um valor: ");
                        conversorMoedas.setValor(scanner.nextDouble());
                        break;
                    case 2:
                        codigoBase = ComandosCli.escolhaMoeda(scanner);
                        break;
                    case 3:
                        codigoAlvo = ComandosCli.escolhaMoeda(scanner);
                        break;
                    case 4:
                        conversorMoedas.converterValorEntreMoedas(codigoBase, codigoAlvo);
                        System.out.println("O valor de " + conversorMoedas.getValor() + " [" + codigoBase + "] para [" + codigoAlvo + "] é " + conversorMoedas.getValorConversao());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            }

        }


    }

}
