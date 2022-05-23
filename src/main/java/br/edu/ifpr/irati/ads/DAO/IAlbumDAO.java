package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Album;
import java.util.List;


public interface IAlbumDAO {
    public void salvar(Album a) throws PersistenceException;
    
    public void excluir(int albumID) throws PersistenceException;
    
    public Album getOne(int albumID) throws PersistenceException;
    
    public List<Album> getAll() throws PersistenceException;
}
