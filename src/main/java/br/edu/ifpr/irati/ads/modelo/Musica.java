package br.edu.ifpr.irati.ads.modelo;

import java.util.List;

public class Musica {
    private int musicaID;
    private String descricao;
    private int albumID;
    private int playlistID;
    private int duracaoSegundos;
    private int artistaID;
    private String generoMusical;

    public Musica() {
        this.musicaID = 0;
        this.albumID = 0;
        this.artistaID = 0;
        this.playlistID = 0;
        this.descricao = "";
        this.generoMusical = "";
        this.duracaoSegundos = 0;
    }

    public Musica(String descricao, int albumID, int playlistID, int duracaoSegundos, int artistaID, String generoMusical) {
        this.musicaID = 0;
        this.descricao = descricao;
        this.albumID = albumID;
        this.playlistID = playlistID;
        this.duracaoSegundos = duracaoSegundos;
        this.artistaID = artistaID;
        this.generoMusical = generoMusical;
    }
    
    public List<Musica> getAll(){
        return null;
    }
    
    /**
     * @return the musicaID
     */
    public int getMusicaID() {
        return musicaID;
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

    /**
     * @return the albumID
     */
    public int getAlbumID() {
        return albumID;
    }

    /**
     * @param albumID the albumID to set
     */
    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    /**
     * @return the playlistID
     */
    public int getPlaylistID() {
        return playlistID;
    }

    /**
     * @param playlistID the playlistID to set
     */
    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    /**
     * @return the duracaoSegundos
     */
    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    /**
     * @param duracaoSegundos the duracaoSegundos to set
     */
    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    /**
     * @return the artistaID
     */
    public int getArtistaID() {
        return artistaID;
    }

    /**
     * @param artistaID the artistaID to set
     */
    public void setArtistaID(int artistaID) {
        this.artistaID = artistaID;
    }

    /**
     * @return the generoMusical
     */
    public String getGeneroMusical() {
        return generoMusical;
    }

    /**
     * @param generoMusical the generoMusical to set
     */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    
    
}
