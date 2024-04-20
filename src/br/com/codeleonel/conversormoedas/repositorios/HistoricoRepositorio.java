package br.com.codeleonel.conversormoedas.repositorios;

import br.com.codeleonel.conversormoedas.estados.HistoricoEstado;
import br.com.codeleonel.conversormoedas.estados.MoedaEstado;
import br.com.codeleonel.conversormoedas.modelos.Conversao;
import br.com.codeleonel.conversormoedas.modelos.Historico;
import br.com.codeleonel.conversormoedas.modelos.Moeda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class HistoricoRepositorio {

    public static void persisteHistorico() {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedWriter bf = new BufferedWriter(new FileWriter("historico.csv"))) {

            var listaHistorico = HistoricoEstado.getListaHistorico();

            for (var historico : listaHistorico) {
                stringBuilder.append("%s;%s;%s;%s;%s;%.2f;%.2f;%s\n".formatted(
                        historico.getConversao().base_code(),
                        historico.getConversao().target_code(),
                        historico.getConversao().conversion_rate(),
                        historico.getConversao().time_last_update_utc(),
                        historico.getConversao().time_next_update_utc(),
                        historico.getValor(),
                        historico.getValorConversao(),
                        historico.getInstante()
                ));
            }

            bf.write(stringBuilder.toString());

        } catch (Exception e) {
            System.out.println("Não foi possível persistir o histórico de conversões: " + e.getMessage());
        }

    }

    public static void leituraHistorico(String nomeArquivo) {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bfr = new BufferedReader(new FileReader(nomeArquivo))) {

            String linha = bfr.readLine();

            while (linha != null) {

                String[] colunas = linha.split(";");

                var historico = new Historico(
                        new Conversao(colunas[0],
                        colunas[1],
                        colunas[2],
                        colunas[3],
                        colunas[4]),
                        Double.parseDouble(colunas[5].replace(",",".")),
                        Double.parseDouble(colunas[6].replace(",",".")),
                        LocalDateTime.parse(colunas[7]));

                HistoricoEstado.adicionar(historico);

                linha = bfr.readLine();
            }

        } catch (Exception e) {
            System.out.println("Não foi possível persistir o histórico de conversões: " + e.getMessage());
        }

    }

}
