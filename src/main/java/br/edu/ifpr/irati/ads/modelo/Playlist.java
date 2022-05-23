package br.edu.ifpr.irati.ads.modelo;

import java.util.List;

public class Playlist {
    private int playlistID;
    private String descricao;

    public Playlist() {
        this.playlistID = 0;
        this.descricao = "";
    }

    public Playlist(String descricao) {
        this.playlistID = 0;
        this.descricao = descricao;
    }

    public List<Playlist> getAll (){
        return null;
    }
    
    /**
     * @return the playlistID
     */
    public int getPlaylistID() {
        return playlistID;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
