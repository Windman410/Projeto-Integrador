package br.iesb.meuprograma.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadBiblioDAO implements DAO<CadBiblio> {

    @Override
    public void inserir(CadBiblio entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_bibliografia (cursos, disciplinas, titulo, autor, ano, isbn, editora) VALUES (?, ?, ?, ?, ?, ?, ?)";
       
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCursos());
            comando.setString(2, entidade.getDisciplinas());
            comando.setString(3, entidade.getTitulo());
            comando.setString(4, entidade.getAutor());
            comando.setInt(5, entidade.getAno());
            comando.setString(6, entidade.getIsbn());
            comando.setString(7, entidade.getEditora());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir dados!", ex);
        }       
    }	

    @Override
    public void alterar(CadBiblio entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_bibliografia SET cursos=?, disciplinas=?, titulo=?, autor=?, ano=?, isbn=?, editora=? WHERE id_bibliografia=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCursos());
            comando.setString(2, entidade.getDisciplinas());
            comando.setString(3, entidade.getTitulo());
            comando.setString(4, entidade.getAutor());
            comando.setInt(5, entidade.getAno());
            comando.setString(6, entidade.getIsbn());
            comando.setString(7, entidade.getEditora());
            comando.setInt(8, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(CadBiblio entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_bibliografia WHERE id_bibliografia=?";
        
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
    public CadBiblio consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_bibliografia WHERE id_bibliografia=?";
        CadBiblio cadBiblio = new CadBiblio();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                cadBiblio.setId(resultado.getInt(1));
                cadBiblio.setCursos(resultado.getString(2));
                cadBiblio.setDisciplinas(resultado.getString(3));
                cadBiblio.setTitulo(resultado.getString(4));
                cadBiblio.setAutor(resultado.getString(5));
                cadBiblio.setAno(resultado.getInt(6));
                cadBiblio.setIsbn(resultado.getString(7));
                cadBiblio.setEditora(resultado.getString(8));
            
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return cadBiblio;
    }

    @Override
    public List<CadBiblio> listar() throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_bibliografia";
        List <CadBiblio> lista = new ArrayList<>();
                
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                CadBiblio cadBiblio = new CadBiblio();
                cadBiblio.setId(resultado.getInt(1));
                cadBiblio.setCursos(resultado.getString(2));
                cadBiblio.setDisciplinas(resultado.getString(3));
                cadBiblio.setTitulo(resultado.getString(4));
                cadBiblio.setAutor(resultado.getString(5));
                cadBiblio.setAno(resultado.getInt(6));
                cadBiblio.setIsbn(resultado.getString(7));
                cadBiblio.setEditora(resultado.getString(8));
                lista.add(cadBiblio);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!\n" + ex.getMessage(), ex);
        }
        return lista;
    }

    
    
}
