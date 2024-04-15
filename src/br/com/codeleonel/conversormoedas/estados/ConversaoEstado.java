package br.com.codeleonel.conversormoedas.estados;

import br.com.codeleonel.conversormoedas.modelos.Conversao;

import java.util.ArrayList;
import java.util.List;

public class ConversaoEstado {

    private static List<Conversao> listaConversoes = new ArrayList<>();

    public static List<Conversao> getListaConversoes() {

        return listaConversoes;

    }

    public static void adicionar(Conversao conversao) {

        listaConversoes.add(conversao);

    }

}
