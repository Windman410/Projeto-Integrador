package br.iesb.meuprograma.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public final class ConexaoBD {

    public static Connection getConexao() throws DadosException {
        String usuario = "root";
        String senha = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/sistemappc",usuario,senha);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro JDBC", JOptionPane.ERROR_MESSAGE);
            throw new DadosException("Erro ao carregar JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro SGDB", JOptionPane.ERROR_MESSAGE);
            throw new DadosException("Erro ao conectar com SGBD: " + e.getMessage());
        }
    }
}
