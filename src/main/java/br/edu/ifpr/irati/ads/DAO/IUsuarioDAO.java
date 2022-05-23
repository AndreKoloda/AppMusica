package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    public void salvar(Usuario u) throws PersistenceException;
    
    public void excluir(int usuarioID) throws PersistenceException;
    
    public Usuario getOne(int usuarioID) throws PersistenceException;
    
    public List<Usuario> getAll() throws PersistenceException;
}
