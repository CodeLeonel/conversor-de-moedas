package br.com.codeleonel.conversormoedas.estados;

import br.com.codeleonel.conversormoedas.modelos.Moeda;

import java.util.ArrayList;
import java.util.List;

public class MoedaEstado {

    private static List<Moeda> listaMoedas = new ArrayList<>();

    public static List<Moeda> getListaMoedas() {

        return listaMoedas;

    }

    public static void adicionar(Moeda moeda) {

        listaMoedas.add(moeda);

    }

}
