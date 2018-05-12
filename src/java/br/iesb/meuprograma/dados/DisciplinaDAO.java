package br.iesb.meuprograma.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaDAO implements DAO<DisciplinaBean> {

    @Override
    public void inserir(DisciplinaBean entidade) throws DadosException {
        Connection conexao;
        try {
            conexao = ConexaoBD.getConexao();
        } catch(DadosException e){
            throw new DadosException(e.getMessage());
        }
        String sql = "INSERT INTO tb_disciplinas (nome, cod, descricao, semestre, cargaHoraria) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNome());
            comando.setInt(2, entidade.getCod());
            comando.setString(3, entidade.getDescricao());
            comando.setInt(4, entidade.getSemestre());
            comando.setInt(5, entidade.getCargaHoraria());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(DisciplinaBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_disciplinas SET nome=?, cod=?, descricao=?, semestre=?, cargaHoraria=? WHERE id_disciplinas=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNome());
            comando.setInt(2, entidade.getCod());
            comando.setString(3, entidade.getDescricao());
            comando.setInt(4, entidade.getSemestre());
            comando.setInt(5, entidade.getCargaHoraria());
            comando.setInt(6, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(DisciplinaBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_disciplinas WHERE id_disciplinas=?";
        
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
    public DisciplinaBean consultar(int id) throws DadosException {
                Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_disciplinas WHERE id_disciplinas=?";
                DisciplinaBean caddisc = new DisciplinaBean();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                caddisc.setId(resultado.getInt(1));
                caddisc.setNome(resultado.getString(2));
                caddisc.setCod(resultado.getInt(3));
                caddisc.setDescricao(resultado.getString(4));
                caddisc.setSemestre(resultado.getInt(5));
                caddisc.setCargaHoraria(resultado.getInt(6));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return caddisc;
    }

    @Override
    public List<DisciplinaBean> listar() throws DadosException {
                Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_disciplinas";
                List <DisciplinaBean> lista = new ArrayList<>();
                
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                DisciplinaBean caddisc = new DisciplinaBean();
                caddisc.setId(resultado.getInt(1));
                caddisc.setNome(resultado.getString(2));
                caddisc.setCod(resultado.getInt(3));
                caddisc.setDescricao(resultado.getString(4));
                caddisc.setSemestre(resultado.getInt(5));
                caddisc.setCargaHoraria(resultado.getInt(6));
                lista.add(caddisc);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!\n" + ex.getMessage(), ex);
        }
                return lista;
    }
    
}
