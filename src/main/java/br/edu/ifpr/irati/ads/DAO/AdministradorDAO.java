package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.conexao.Conexao;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdministradorDAO implements IAdministradorDAO{

    @Override
    public void salvar(Administrador a) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            int administradorID = a.getAdministradorID();
            if (administradorID == 0){
                PreparedStatement psPeople = conn.prepareStatement("INSERT INTO Pessoa "
                        + "(nome,email,senha) VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                psPeople.setString(1, a.getNome());
                psPeople.setString(2, a.getEmail());
                psPeople.setString(3, a.getSenha());
                psPeople.execute();
                ResultSet rsPeople = psPeople.getGeneratedKeys();
                rsPeople.next();
                
                PreparedStatement psAdmin = conn.prepareStatement("INSERT INTO Administrador(pessoaID) "
                        + "VALUES (?)",PreparedStatement.RETURN_GENERATED_KEYS);
                psAdmin.setInt(1, a.getPessoaID());
                psAdmin.execute();
                ResultSet rsAdmin = psAdmin.getGeneratedKeys();
                if (rsAdmin.next()) {
                    //a.setAdministradorI(rs.getInt(1));
                }

                conn.close();
            } else {
                PreparedStatement psPeople = conn.prepareStatement("UPDATE Pessoa SET nome = ?, "
                        + "email = ?, senha = ? WHERE AdministradorID = ?",PreparedStatement.RETURN_GENERATED_KEYS);
                psPeople.setInt(1, a.getAdministradorID());
                psPeople.execute();
                ResultSet rsPeople = psPeople.getGeneratedKeys();
                rsPeople.next();
                
                PreparedStatement psAdmin = conn.prepareStatement("UPDATE Administrador SET "
                        + "nome = ?, email = ?, senha = ? WHERE AdministradorID = ?",PreparedStatement.RETURN_GENERATED_KEYS);
                psAdmin.setString(1, a.getNome());
                psAdmin.setString(2, a.getEmail());
                psAdmin.setString(3, a.getSenha());
                psAdmin.setInt(4, a.getAdministradorID());
                psAdmin.execute();
                ResultSet rsAdmin = psAdmin.getGeneratedKeys();
            }
        } catch (SQLException ex){
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int administradorID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (administradorID > 1){
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Administrador "
                        + "WHERE AdministradorID = ?");
                ps.setInt(1, administradorID);
                ps.execute();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Administrador getOne(int administradorID) throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            if (administradorID > 0){
                PreparedStatement ps = conn.prepareStatement("SELECT a.AdministradorID,"
                        + "p.PessoaID, p.Nome, p.Email, p.Senha FROM Pessoa p INNER JOIN"
                        + "Administrador a ON a.PessoaID = p.PessoaID "
                        + "WHERE Administrador ID = ?");
                ps.setInt(1, administradorID);
                ResultSet rs = ps.executeQuery();
            }
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Administrador> getAll() throws PersistenceException {
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT a.AdministradorID,"
                    + "p.PessoaID, p.Nome, p.Email, p.Senha FROM Pessoa p INNER JOIN"
                    + "Administrador a ON a.PessoaID = p.PessoaID ");
            ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
}
