package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO implements IArtistaDAO{

    @Override
    public void save(Artista a) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if(a.getArtistaID() > 0){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Artista(Nome) "
                        + "VALUES (?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, a.getNome());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    a.setArtistaID(rs.getInt(1));
                }
                rs.close();
                ps.close();
            } else {
                PreparedStatement ps = conn.prepareStatement("UPDATE Artista SET "
                        + "Nome = ? WHERE ArtistaID = ?"
                        ,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, a.getNome());
                ps.setInt(2, a.getArtistaID());
                ps.execute();
                ps.close();
            }
            conn.close();
        } catch (SQLException e){
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int artistaID) throws PersistenceException {
        try {
            if (artistaID > 0){
                Conexao conexao = new Conexao();
                Connection conn = conexao.conectar();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Artista "
                        + "WHERE ArtistaID = ?");
                ps.setInt(1, artistaID);
                ps.execute();
                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Artista getOne(int artistaID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (artistaID > 0) {
                PreparedStatement ps = conn.prepareStatement("SELECT "
                        + "a.ArtistaID, a.Nome FROM Artista a WHERE ArtistaID = ?");
                ps.setInt(1,artistaID);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    Artista artista = new Artista();
                    artista.setArtistaID(rs.getInt(1));
                    artista.setNome(rs.getString(2));
                    return artista;
                } else {
                    return null;
                }
            } else{
                return null;
            }
        } catch (SQLException e) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Artista> getAll() throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT "
                    + "a.ArtistaID, a.Nome FROM Artista a");
            ResultSet rs = ps.executeQuery();
            List<Artista> artistas = new ArrayList<>();
            while(rs.next()){
                Artista artista = new Artista();
                artista.setArtistaID(rs.getInt(1));
                artista.setNome(rs.getString(2));
                artistas.add(artista);
            }
            ps.close();
            rs.close();
            conn.close();
            return artistas;
        } catch (SQLException e) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
