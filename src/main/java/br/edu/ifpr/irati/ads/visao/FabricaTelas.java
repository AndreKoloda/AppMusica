package br.edu.ifpr.irati.ads.visao;

import br.edu.ifpr.irati.ads.controle.Controle;
import javax.swing.JFrame;

/**
 *
 * @author felip
 */
public class FabricaTelas {

    public JFrame novaTela(String tela, Controle controle){
        JFrame jf;
        if (tela.equals("telaLogin")){
            jf = new TelaLogin(controle);
        } else if (tela.equals("telaCadastroPessoa")){
            jf = new TelaCadastroPessoa(controle);
        } else if (tela.equals("telaAlbum")){
            jf = new TelaAlbum(controle);
        } else if (tela.equals("telaPlaylist")){
            jf = new TelaPlaylist(controle);
        } else if (tela.equals("telaMusica")){
            jf = new TelaMusica(controle);
        } else if (tela.equals("telaArtista")){
            jf = new TelaArtista(controle);
        } else if (tela.equals("telaInicial")){
            jf = new TelaInicial(controle);
        } else {
            jf = new JFrame();
        }
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        return jf;
    }
    
}
