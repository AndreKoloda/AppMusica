package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Musica;
import java.util.List;

public interface IMusicaDAO {
    public void salvar(Musica m) throws PersistenceException;
    
    public void excluir(int musicaID) throws PersistenceException;
    
    public Musica getOne(int musicaID) throws PersistenceException;
    
    public List<Musica> getAll() throws PersistenceException;
}
