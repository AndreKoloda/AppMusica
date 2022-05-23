package br.edu.ifpr.irati.ads.controle;

import br.edu.ifpr.irati.ads.DAO.AdministradorDAO;
import br.edu.ifpr.irati.ads.DAO.UsuarioDAO;
import br.edu.ifpr.irati.ads.exception.HashGenerationException;
import br.edu.ifpr.irati.ads.exception.PersistenceException;
import br.edu.ifpr.irati.ads.modelo.Administrador;
import br.edu.ifpr.irati.ads.modelo.Usuario;
import br.edu.ifpr.irati.ads.util.Digest;
import br.edu.ifpr.irati.ads.visao.FabricaTelas;
import br.edu.ifpr.irati.ads.visao.TelaLogin;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Controle {

    private FabricaTelas fabricaTelas;
    private Map<String, JFrame> telas;
    private Usuario usuario;
    private Administrador administrador;
    
    public Controle () {
        this.fabricaTelas = new FabricaTelas();
        this.telas = new HashMap<>();
    }
    
    public void iniciarAplicacao () {
        telas.put("telaLogin", fabricaTelas.novaTela("telaLogin", this));
        telas.get("telaLogin").setVisible(true);
        this.usuario = new Usuario();
        this.administrador = new Administrador();
    }
    
    public void fazerLogin (String login, String senha) throws HashGenerationException {
        try{
            boolean loginValidado = false;
            UsuarioDAO userDAO = new UsuarioDAO();
            this.usuario = userDAO.validarLogin(login, Digest.hashString(senha, "SHA-256"));
            if (this.usuario.getUsuarioID() > 0){
                loginValidado = true;
            } else {
                AdministradorDAO adminDAO = new AdministradorDAO();
                this.administrador = adminDAO.validarLogin(login, Digest.hashString(senha, "SHA-256"));
                if (this.administrador.getAdministradorID() > 0) {
                    loginValidado = true;
                }
            }
            if (loginValidado){
                telas.put("telaInicial", fabricaTelas.novaTela("telaInicial", this));
                telas.get("telaInicial").setVisible(true);
                telas.get("telalogin").dispose();
            }
        } catch (PersistenceException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecharTelas(){
        if(telas.get("telaMusica").isVisible()){
            telas.get("telaMusica").dispose();
        }
        if(telas.get("telaAlbum").isVisible()){
            telas.get("telaAlbum").dispose();
        }
        if(telas.get("telaPlaylist").isVisible()){
            telas.get("telaPlaylist").dispose();
        }
        if(telas.get("telaArtista").isVisible()){
            telas.get("telaArtista").dispose();
        }
        if(telas.get("telaLogin").isVisible()){
            telas.get("telaLogin").dispose();
        }
        if(telas.get("telaCadastroPessoa").isVisible()){
            telas.get("telaCadastroPessoa").dispose();
        }
        if(telas.get("telaInicial").isVisible()){
            telas.get("telaInicial").dispose();
        }
    }
    
    public void abrirTelaMusica (){
        System.out.println("Entrou");
        fecharTelas();
        telas.put("telaMusica", fabricaTelas.novaTela("telaMusica", this));
        telas.get("telaMusica").setVisible(true);
    }
    
    public void abrirTelaAlbum(){
        telas.put("telaAlbum", fabricaTelas.novaTela("telaAlbum", this));
        fecharTelas();
        telas.get("telaAlbum").setVisible(true);
    }
    
    public void abrirTelaPlaylist(){
        telas.put("telaPlaylist", fabricaTelas.novaTela("telaPlaylist", this));
        fecharTelas();
        telas.get("telaPlaylist").setVisible(true);
    }
    
    public void abrirTelaArtista(){
        telas.put("telaTelaArtista", fabricaTelas.novaTela("telaTelaArtista", this));
        fecharTelas();
        telas.get("telaTelaArtista").setVisible(true);
    }
    
    public static void main(String[] args) {
        Controle controle = new Controle();
        controle.iniciarAplicacao();
    }
    
}
