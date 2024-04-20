package br.com.codeleonel.conversormoedas.estados;

import br.com.codeleonel.conversormoedas.modelos.Conversao;
import br.com.codeleonel.conversormoedas.modelos.Historico;
import br.com.codeleonel.conversormoedas.repositorios.HistoricoRepositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoEstado {

    private static List<Historico> listaHistorico = new ArrayList<>();

    public static List<Historico> getListaHistorico() {

        return listaHistorico;

    }

    public static void adicionar(Conversao conversao, double valor, double valorConvertido) {

        listaHistorico.add(new Historico(conversao,valor,valorConvertido, LocalDateTime.now()));

        HistoricoRepositorio.persisteHistorico();

    }

    public static void adicionar(Historico historico) {

        listaHistorico.add(historico);

    }
}
