package br.edu.ifpr.irati.ads.modelo;

public class Usuario extends Pessoa {
    private int usuarioID;
    private int pessoaID;

    public Usuario() {
        super();
        this.usuarioID = 0;
        this.pessoaID = 0;
    }
    
    public int getUsuarioID() {
        return usuarioID;
    }

    public int getPessoaID() {
        return pessoaID;
    }
}
