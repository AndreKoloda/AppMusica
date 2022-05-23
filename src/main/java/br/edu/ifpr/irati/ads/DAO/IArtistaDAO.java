package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Artista;
import java.util.List;

public interface IArtistaDAO {
    public void save(Artista a) throws PersistenceException;
    
    public void excluir(int artistaID) throws PersistenceException;
    
    public Artista getOne(int artistaID) throws PersistenceException;
    
    public List<Artista> getAll() throws PersistenceException;
}
