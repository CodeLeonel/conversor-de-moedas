package br.com.codeleonel.conversormoedas.principal;

import br.com.codeleonel.conversormoedas.cli.ComandosCli;
import br.com.codeleonel.conversormoedas.estados.HistoricoEstado;
import br.com.codeleonel.conversormoedas.repositorios.HistoricoRepositorio;
import br.com.codeleonel.conversormoedas.repositorios.MoedaRepositorio;
import br.com.codeleonel.conversormoedas.servicos.ConversorMoedas;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        MoedaRepositorio.lerArquivo("moedas.csv");
        HistoricoRepositorio.leituraHistorico("historico.csv");
        ConversorMoedas conversorMoedas = new ConversorMoedas();
        Scanner scanner = new Scanner(System.in);
        String codigoBase = null, codigoAlvo = null;

        int opcao = -1;

        while (opcao != 0) {

            ComandosCli.menuCompleto(conversorMoedas.getValor(), codigoBase, codigoAlvo, conversorMoedas.getMensagemUltimaConversao());
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
                    if (conversorMoedas.getValor() > 0.0) {
                        codigoBase = ComandosCli.escolhaMoeda(scanner);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    if (conversorMoedas.getValor() > 0.0 && codigoBase != null) {
                        codigoAlvo = ComandosCli.escolhaMoeda(scanner);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 4:
                    if (conversorMoedas.getValor() > 0.0 && codigoBase != null && codigoAlvo != null) {
                        conversorMoedas.converterValorEntreMoedas(codigoBase, codigoAlvo);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 5:
                    var listaHistorico = HistoricoEstado.getListaHistorico();
                    if (!listaHistorico.isEmpty()) {

                        while (true) {

                            for (int i = 0; i < listaHistorico.size(); i++) {
                                System.out.println((i + 1) + " - " + listaHistorico.get(i));
                            }

                            System.out.print("Escolha um histórico (ou 0 - Sair): ");

                            int indice = scanner.nextInt();

                            if (indice != 0) {

                                System.out.println(listaHistorico.get(indice - 1).fichaCompleta());

                            } else {

                                break;

                            }

                        }

                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 6:

                    while (true) {

                        System.out.print("""
                                Conversor de Moedas
                                
                                Trata-se de um programa de interface de linha comando que realiza cálculos de conversçao de moedas.
                                Parte desse processo ocorre por consultas de uma WEB API de taxa de conversão.
                                
                                Desenvolvido por: Hugo Leonel
                                Projeto motivado pela: Alura ONE
                                Portólio: https://hl-portfolio.vercel.app/
                                
                                0 - Sair
                                Digite a opção: """);

                        int opcaoSobre = scanner.nextInt();

                        if(opcaoSobre == 0) {
                            break;
                        } else {
                            System.out.println("Opção inválida");
                        }

                    }

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        }


    }

}
