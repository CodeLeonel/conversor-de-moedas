package br.com.codeleonel.conversormoedas.modelos;

public class Moeda {

    private String codigo;
    private String nome;
    private String pais;
    private Boolean aluraFilter;

    public Moeda(String codigo, String nome, String pais, Boolean aluraFilter) {
        this.codigo = codigo;
        this.nome = nome;
        this.pais = pais;
        this.aluraFilter = aluraFilter;
    }

    @Override
    public String toString() {
        return this.getCodigo() + " " + this.getNome();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public Boolean getAluraFilter() {
        return aluraFilter;
    }
}
