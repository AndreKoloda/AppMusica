package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements IUsuarioDAO{

    @Override
    public void salvar(Usuario u) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (u.getUsuarioID() == 0){
                PreparedStatement psPessoa = conn.prepareStatement("INSERT INTO Pessoa(Nome, Email, Senha)"
                        + "VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                psPessoa.setString(1, u.getNome());
                psPessoa.setString(2, u.getEmail());
                psPessoa.setString(3, u.getSenha());
                psPessoa.execute();
                ResultSet rsPessoa = psPessoa.getGeneratedKeys();
                //OBTER PESSOA ID
                PreparedStatement psUsuario = conn.prepareStatement("INSERT INTO Usuario(pessoaID)"
                        ,PreparedStatement.RETURN_GENERATED_KEYS);
                psUsuario.setInt(1, u.getPessoaID());
                psUsuario.execute();
                ResultSet rsUsuario = psUsuario.getGeneratedKeys();
            } else {
                PreparedStatement psPessoa = conn.prepareStatement("UPDATE Pessoa "
                        + "SET Nome = ?, Email = ?, Senha= ?)"
                        ,PreparedStatement.RETURN_GENERATED_KEYS);
                psPessoa.setString(1, u.getNome());
                psPessoa.setString(2, u.getEmail());
                psPessoa.setString(3, u.getSenha());
                psPessoa.execute();
                ResultSet rsPessoa = psPessoa.getGeneratedKeys();
                PreparedStatement psUsuario = conn.prepareStatement("UPDATE Usuario "
                        + "SET pessoaID = ?)"
                        ,PreparedStatement.RETURN_GENERATED_KEYS);
                psUsuario.setInt(1, u.getPessoaID());
                psUsuario.execute();
                ResultSet rsUsuario = psUsuario.getGeneratedKeys();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
       
    @Override
    public void excluir(int usuarioID) throws PersistenceException {
        try{
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        if (usuarioID > 0){
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Usuario WHERE "
                    + "UsuarioID = ?");
            ps.setInt(1, usuarioID);
        }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario getOne(int usuarioID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuario WHERE UsuarioID = ?");
            ps.setInt(1, usuarioID);
            ResultSet rs = ps.getResultSet();
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> getAll() throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuario");
            ResultSet rs = ps.getResultSet();
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
        
}
