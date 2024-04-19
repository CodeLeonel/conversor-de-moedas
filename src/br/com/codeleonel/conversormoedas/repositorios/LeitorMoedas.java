package br.com.codeleonel.conversormoedas.repositorios;

import br.com.codeleonel.conversormoedas.estados.MoedaEstado;
import br.com.codeleonel.conversormoedas.modelos.Moeda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorMoedas {

    public static void lerArquivo(String arquivo) {

        try(BufferedReader bfr = new BufferedReader(new FileReader(arquivo))) {

            String linha = bfr.readLine();

            while (linha != null) {

                String[] colunas = linha.split(";");
                var moeda = new Moeda(colunas[0],colunas[1],colunas[2]);
                MoedaEstado.adicionar(moeda);

                linha = bfr.readLine();
            }

        } catch (IOException e) {

            System.out.println("Não foi possível realizar a leitura: " + e.getMessage());
        }

    }

}
