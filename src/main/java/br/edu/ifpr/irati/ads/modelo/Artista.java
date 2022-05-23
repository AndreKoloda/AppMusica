package br.edu.ifpr.irati.ads.modelo;

import java.util.List;

  public class Artista {
    private int artistaID;
    private String nome;

    public Artista() {
        this.artistaID = 0;
        this.nome = "";
    }

    public Artista(String nome) {
        this.artistaID = 0;
        this.nome = nome;
    }

    public List<Artista> getAll(){
        return null;
    }

    public int getArtistaID() {
        return artistaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
      
}