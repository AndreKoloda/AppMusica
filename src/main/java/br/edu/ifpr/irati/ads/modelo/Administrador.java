package br.edu.ifpr.irati.ads.modelo;

public class Administrador extends Pessoa {
    private int administradorID;
    private boolean permissaoAlterar;
    private boolean permissaoExcluir;
    
    public Administrador() {
        super();
        this.administradorID = 0;
        this.permissaoAlterar = false;
        this.permissaoExcluir = false;
    }

    public Administrador(int administradorID, boolean permissaoAlterar, boolean permissaoExcluir, String nome, String email, String senha, boolean isAdministrador) {
        super();
        this.administradorID = administradorID;
        this.permissaoAlterar = permissaoAlterar;
        this.permissaoExcluir = permissaoExcluir;
    }   

    public int getAdministradorID() {
        return administradorID;
    }

    public boolean isPermissaoAlterar() {
        return permissaoAlterar;
    }

    public void setPermissaoAlterar(boolean permissaoAlterar) {
        this.permissaoAlterar = permissaoAlterar;
    }

    public boolean isPermissaoExcluir() {
        return permissaoExcluir;
    }

    public void setPermissaoExcluir(boolean permissaoExcluir) {
        this.permissaoExcluir = permissaoExcluir;
    }
    
    
}
