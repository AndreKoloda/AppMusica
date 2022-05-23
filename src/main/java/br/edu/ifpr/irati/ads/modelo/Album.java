package br.edu.ifpr.irati.ads.modelo;

import java.util.List;

public class Album {
    private int albumID;
    private String descricao;
    private int artistaID;

    public Album() {
        this.albumID = 0;
        this.artistaID = 0;
        this.descricao = "";
    }

    public Album(String descricao, int artistaID) {
        this.albumID = 0;
        this.descricao = descricao;
        this.artistaID = artistaID;
    }

    public List<Album> getAll(){
        return null;
    }

    public int getAlbumID() {
        return albumID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getArtistaID() {
        return artistaID;
    }

    public void setArtistaID(int artistaID) {
        this.artistaID = artistaID;
    }
    
    
}
