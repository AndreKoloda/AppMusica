package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MusicaDAO implements IMusicaDAO{

    @Override
    public void salvar(Musica m) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (m.getMusicaID() == 0){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Musica(Descricao, "
                        + "AlbumID, PlaylistID, DuracaoSegundos, ArtistaID, GeneroMusical) "
                        + "values (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, m.getDescricao());
                ps.setInt(2, m.getAlbumID());
                ps.setInt(3, m.getPlaylistID());
                ps.setInt(4, m.getDuracaoSegundos());
                ps.setInt(5, m.getArtistaID());
                ps.setString(6, m.getGeneroMusical());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
            } else {
                PreparedStatement ps = conn.prepareStatement("UPDATE Musica SET "
                        + "Descricao = ?, AlbumID = ?, PlaylistID = ?, DuracaoSegundos = ?,"
                        + "ArtistaID = ?, GeneroMusical = ? WHERE MusicaID = ?"
                        ,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, m.getDescricao());
                ps.setInt(2, m.getAlbumID());
                ps.setInt(3, m.getPlaylistID());
                ps.setInt(4, m.getDuracaoSegundos());
                ps.setInt(5, m.getArtistaID());
                ps.setString(6, m.getGeneroMusical());
                ps.setInt(7, m.getMusicaID());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
            }
        } catch (SQLException ex){
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int musicaID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (musicaID > 0){
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Musica WHERE MusicaID = ?");
                ps.setInt(1, musicaID);
                ps.execute();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Musica getOne(int musicaID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (musicaID > 0){
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Musica WHERE MusicaID = ?");
                ps.setInt(1, musicaID);
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Musica> getAll() throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Musica");
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
