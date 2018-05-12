package br.iesb.meuprograma.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

public final class ConexaoBD {

    public static Connection getConexao() throws DadosException {
        String usuario = "root";
        String senha = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/sistemappc",usuario,senha);
        } catch (ClassNotFoundException e) {
            throw new DadosException("Erro ao carregar JDBC: " + e.getMessage());
        } catch (SQLException e) {
            throw new DadosException("Erro ao conectar com SGBD: " + e.getMessage());
        }
    }
}
