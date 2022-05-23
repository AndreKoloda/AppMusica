package br.edu.ifpr.irati.ads.QuerySQL;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDBOApp {
    public void criarDataBase (){
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement psDboPessoa = conn.prepareStatement("CREATE TABLE Pessoa("
                    + "PessoaID INT AUTO_INCREMENT,"
                    + "Nome VARCHAR(100),"
                    + "Email VARCHAR(100),"
                    + "Senha VARCHAR(100),"
                    + "CONSTRAINT PK_Pessoa PRIMARY KEY (PessoaID)");
            
            PreparedStatement psDboAdministrador = conn.prepareStatement("CREATE TABLE Administrador("
                    + "AdministradorID int,"
                    + "PessoaID int,"
                    + "CONSTRAINT PK_Administrador PRIMARY KEY (AdministradorID),"
                    + "CONSTRINT FK_Administrador_Pessoa FOREIGN KEY (PessoaID)"
                    + "REFERENCES Pessoa(PessoaID))");
            
            PreparedStatement psDboUsuario = conn.prepareStatement("CREATE TABLE Usuario("
                    + "UsuarioID int,"
                    + "PessoaID int,"
                    + "CONSTRAINT PK_Usuario PRIMARY KEY (UsuarioID),"
                    + "CONSTRAINT FK_Usuario_Pessoa FOREIGN KEY (PessoaID)"
                    + "REFERENCES Pessoa(PessoaID));");
            
            PreparedStatement psDboMusica = conn.prepareStatement("CREATE TABLE Musica("
                    + "MusicaID int,"
                    + "Descricao varchar(100),"
                    + "AlbumID int,"
                    + "PlaylistID int,"
                    + "DuracaoSegundos int,"
                    + "ArtistaID int,"
                    + "GeneroMusical varchar(100),"
                    + "CONSTRAINT PK_Musica PRIMARY KEY (MusicaID),"
                    + "CONSTRAINT FK_Musica_Album FOREIGN KEY (AlbumID)"
                    + "REFERENCES Album(AlbumID),"
                    + "CONSTRAINT FK_Musica_Playlist FOREIGN KEY (PlaylistID)"
                    + "REFERENCES Playlist(PlaylistID),"
                    + "CONSTRAINT FK_Musica_Artista FOREIGN KEY (ArtistaID)"
                    + "REFERENCES Artista(ArtistaID))");
            
            PreparedStatement psDboAlbum = conn.prepareStatement("CREATE TABLE Album("
                    + "AlbumID int,"
                    + "Descricao varchar(100),"
                    + "ArtistaID int,"
                    + "CONSTRAINT PK_Album PRIMARY KEY (AlbumID),"
                    + "CONSTRAINT FK_Album_Artista FOREIGN KEY (ArtistaID)"
                    + "REFERENCES Artista(ArtistaID))");
            
            PreparedStatement psDboPlaylist = conn.prepareStatement("CREATE TABLE Playlist("
                    + "PlaylistID int,"
                    + "Descricao varchar(100),"
                    + "CONSTRAINT PK_Playlist (PlaylistID))");
            
            PreparedStatement psDboAlbumItem = conn.prepareStatement("CREATE TABLE AlbumItem("
                    + "AlbumID int,"
                    + "MusicaID int,"
                    + "CONSTRAINT FK_AlbumItem_Musica FOREIGN KEY (MusicaID)"
                    + "REFERENCES Musica(MusicaID),"
                    + "CONSTRAINT FK_AlbumItem_Album FOREIGN KEY (AlbumID)"
                    + "REFERENCES Album(AlbumID))");
            
            PreparedStatement psDboPlaylistItem = conn.prepareStatement("CREATE TABLE PlaylistItem("
                    + "PlaylistID int,"
                    + "MusicaID int,"
                    + "CONSTRAINT FK_PlaylistItem_Playlist PRIMARY KEY PlaylistID,"
                    + "CONSTRAINT FK_MusicaItem_Musica FOREIGN KEY MusicaID"
                    + "REFERENCES Musica(MusicaID))");
            
            PreparedStatement psDboArtista = conn.prepareStatement("CREATE TABLE Artista("
                    + "ArtistaID int,"
                    + "Nome varchar(100),"
                    + "CONSTRAINT PK_Artista PRIMARY KEY ArtistaID)");
            
            
        } catch (SQLException ex) {

        }
    }
}
