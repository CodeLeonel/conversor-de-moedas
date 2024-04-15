package br.com.codeleonel.conversormoedas.modelos;

public class Moeda {

    private String codigo;
    private String nome;
    private String pais;

    public Moeda(String codigo, String nome, String pais) {
        this.codigo = codigo;
        this.nome = nome;
        this.pais = pais;
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
}
