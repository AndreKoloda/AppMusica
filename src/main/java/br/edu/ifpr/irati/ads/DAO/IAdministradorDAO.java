package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Administrador;
import java.util.List;

public interface IAdministradorDAO  {
    public void salvar(Administrador a) throws PersistenceException;
    
    public void excluir(int administradorID) throws PersistenceException;
    
    public Administrador getOne(int administradorID) throws PersistenceException;
    
    public List<Administrador> getAll() throws PersistenceException;
    
}
