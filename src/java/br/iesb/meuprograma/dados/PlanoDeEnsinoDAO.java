package br.iesb.meuprograma.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class PlanoDeEnsinoDAO implements DAO<PlanoDeEnsino>{

    @Override
    public void inserir(PlanoDeEnsino entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_planoensino (curso, ano, semestre, disciplina, cargaHoraria, periodoCurso, professor, ementa, competenciasHabilidades, metodologiaEnsino, avaliacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCurso());
            comando.setInt(2, entidade.getAno());
            comando.setInt(3, entidade.getSemestre());
            comando.setString(4, entidade.getDisciplina());
            comando.setInt(5, entidade.getCargaHoraria());
            comando.setString(6, entidade.getPeriodo());
            comando.setString(7, entidade.getProfessor());
            comando.setString(8, entidade.getEmenta());
            comando.setString(9, entidade.getCompetenciasHabilidades());
            comando.setString(10, entidade.getMetodologia());
            comando.setString(11, entidade.getAvaliacao());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(PlanoDeEnsino entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_planoensino SET curso=?, ano=?, semestre=?, disciplina=?, cargaHoraria=?, periodoCurso=?, professor=?, ementa=?, competenciasHabilidades=?, metodologiaEnsino=?, avaliacao=? WHERE id_plano=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCurso());
            comando.setInt(2, entidade.getAno());
            comando.setInt(3, entidade.getSemestre());
            comando.setString(4, entidade.getDisciplina());
            comando.setInt(5, entidade.getCargaHoraria());
            comando.setString(6, entidade.getPeriodo());
            comando.setString(7, entidade.getProfessor());
            comando.setString(8, entidade.getEmenta());
            comando.setString(9, entidade.getCompetenciasHabilidades());
            comando.setString(10, entidade.getMetodologia());
            comando.setString(11, entidade.getAvaliacao());
            comando.setInt(12, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(PlanoDeEnsino entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_planoensino WHERE id_plano=?";
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
    public PlanoDeEnsino consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_planoensino WHERE id_plano=?";
        PlanoDeEnsino planodeensino = new PlanoDeEnsino();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                planodeensino.setId(resultado.getInt(1));
                planodeensino.setCurso(resultado.getString(2));
                planodeensino.setAno(resultado.getInt(3));
                planodeensino.setSemestre(resultado.getInt(4));
                planodeensino.setDisciplina(resultado.getString(5));
                planodeensino.setCargaHoraria(resultado.getInt(6));
                planodeensino.setPeriodo(resultado.getString(7));
                planodeensino.setProfessor(resultado.getString(8));
                planodeensino.setEmenta(resultado.getString(9));
                planodeensino.setCompetenciasHabilidades(resultado.getString(10));
                planodeensino.setMetodologia(resultado.getString(11));
                planodeensino.setAvaliacao(resultado.getString(12));
                }conexao.close();
        } catch (SQLException ex) {
           throw new DadosException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return planodeensino;
    }

    @Override
    public List<PlanoDeEnsino> listar() throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_planoensino";
        List <PlanoDeEnsino> lista = new ArrayList<>();
        
        try{
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                PlanoDeEnsino planodeensino = new PlanoDeEnsino();
                planodeensino.setId(resultado.getInt(1));
                planodeensino.setCurso(resultado.getString(2));
                planodeensino.setAno(resultado.getInt(3));
                planodeensino.setSemestre(resultado.getInt(4));
                planodeensino.setDisciplina(resultado.getString(5));
                planodeensino.setCargaHoraria(resultado.getInt(6));
                planodeensino.setPeriodo(resultado.getString(7));
                planodeensino.setProfessor(resultado.getString(8));
                planodeensino.setEmenta(resultado.getString(9));
                planodeensino.setCompetenciasHabilidades(resultado.getString(10));
                planodeensino.setMetodologia(resultado.getString(11));
                planodeensino.setAvaliacao(resultado.getString(12));
                lista.add(planodeensino);
            }
            conexao.close();
       } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!\n" + ex.getMessage(), ex);
        } 
        return lista;
    }
    
}
