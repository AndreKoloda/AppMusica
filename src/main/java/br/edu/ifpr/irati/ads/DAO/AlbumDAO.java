package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumDAO implements IAlbumDAO{

    @Override
    public void salvar(Album a) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (a.getAlbumID() == 0){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Album"
                        + "(Descricao, ArtistaID) VALUES (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, a.getDescricao());
                ps.setInt(2, a.getArtistaID());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
            } else {
                PreparedStatement ps = conn.prepareStatement("UPDATE Album"
                        + "SET Descricao = ?, ArtistaID = ? WHERE AlbumID = ?",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, a.getDescricao());
                ps.setInt(2, a.getArtistaID());
                ps.setInt(3, a.getAlbumID());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int albumID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (albumID > 0){
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Album WHERE AlbumID = ?");
                ps.setInt(1, albumID);
                ps.execute();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Album getOne(int albumID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (albumID > 0) {
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Album"
                        + "WHERE AlbumID = ?");
                ps.setInt(1, albumID);
                ps.execute();
                ResultSet rs = ps.getResultSet();
            }
        } catch (SQLException ex) {

        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Album> getAll() throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement 
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
