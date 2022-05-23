package br.edu.ifpr.irati.ads.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class Conexao {
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/AppMusica";
            String usuario = "root";
            String senha = "mysql";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrei o Driver");
            System.out.println(ex);
            System.exit(0);
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o banco de dados");
            System.out.println(ex);
        }
        return null;
    }
}
