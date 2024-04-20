package br.com.codeleonel.conversormoedas.modelos;

public record Conversao(String base_code, String target_code, String conversion_rate, String time_last_update_utc, String time_next_update_utc) {
}
