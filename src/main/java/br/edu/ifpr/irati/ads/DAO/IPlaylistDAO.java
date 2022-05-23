package br.edu.ifpr.irati.ads.DAO;

import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Playlist;
import java.util.List;

public interface IPlaylistDAO {
    public void salvar(Playlist p) throws PersistenceException;
    
    public void excluir(int playlistID) throws PersistenceException;
    
    public Playlist getOne(int playlistID) throws PersistenceException;
    
    public List<Playlist> getAll() throws PersistenceException;
}
