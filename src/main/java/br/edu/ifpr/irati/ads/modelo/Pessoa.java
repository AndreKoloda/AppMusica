package br.edu.ifpr.irati.ads.modelo;

public abstract class Pessoa {
    private int pessoaID;
    private String nome;
    private String email;
    private String senha;

    public Pessoa(String nome, String email, String senha) {
        this.pessoaID = 0;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }  

    public Pessoa() {
        this.pessoaID = 0;
        this.nome = "";
        this.email = "";
        this.senha = "";
    }

    public int getPessoaID() {
        return pessoaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
