package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Playlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistDAO implements IPlaylistDAO{

    @Override
    public void salvar(Playlist p) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (p.getPlaylistID() == 0){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Playlist"
                        + "(PlaylistID) VALUES (?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, p.getDescricao());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
            } else {
                PreparedStatement ps = conn.prepareStatement("UPDATE Playlist"
                        + "SET Descricao = ? WHERE Playlist = ?"
                        ,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, p.getDescricao());
                ps.setInt(2, p.getPlaylistID());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int playlistID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (playlistID > 0){
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Playlist"
                        + "WHERE PlaylistID = ?");
                ps.setInt(1, playlistID);
                ps.execute();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Playlist getOne(int playlistID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (playlistID > 0){
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Playlist "
                        + "WHERE PlaylistID = ?");
                ps.setInt(1, playlistID);
                ps.execute();
                ResultSet rs = ps.getResultSet();
                
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Playlist> getAll() throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Playlist");
            ps.execute();
            ResultSet rs = ps.getResultSet();
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
