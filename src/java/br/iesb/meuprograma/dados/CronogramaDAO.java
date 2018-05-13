package br.iesb.meuprograma.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CronogramaDAO implements DAO<CronogramaBean>{

    @Override
    public void inserir(CronogramaBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_cronograma (aula, conteudo) VALUES (?, ?)";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getAula());
            comando.setString(2, entidade.getConteudo());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(CronogramaBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_cronograma SET aula=?, conteudo=? WHERE id_cronograma=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getAula());
            comando.setString(2, entidade.getConteudo());
            comando.setInt(3, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(CronogramaBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_cronograma WHERE id_cronograma=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public CronogramaBean consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_cronograma WHERE id_cronograma=?";
                CronogramaBean cronograma = new CronogramaBean();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                cronograma.setId(resultado.getInt(1));
                cronograma.setAula(resultado.getInt(2));
                cronograma.setConteudo(resultado.getString(3));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return cronograma;
    }

    @Override
    public List<CronogramaBean> listar() throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_cronograma";
        List <CronogramaBean> lista = new ArrayList<>();
                
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                CronogramaBean cronograma = new CronogramaBean();
                cronograma.setId(resultado.getInt(1));
                cronograma.setAula(resultado.getInt(2));
                cronograma.setConteudo(resultado.getString(3));
                lista.add(cronograma);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!\n" + ex.getMessage(), ex);
        }
        return lista;
    }
    
}
