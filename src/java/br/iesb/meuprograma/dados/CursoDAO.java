package br.iesb.meuprograma.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CursoDAO implements DAO<CursoBean>{

    @Override
    public void inserir(CursoBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_curso (tipo, modalidade, denominacao, habilitacao, localOferta, matutino, vespertino, noturno, vagasTurno, cargaHoraria, regimeLetivo, periodo, nomeProfessor, cpf, titulacao, tempoDedicacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTipo());
            comando.setString(2, entidade.getModalidade());
            comando.setString(3, entidade.getDenominacao());
            comando.setString(4, entidade.getHabilitacao());
            comando.setString(5, entidade.getLocalOferta());
            comando.setBoolean(6, entidade.isMatutino());
            comando.setBoolean(7, entidade.isVespertino());
            comando.setBoolean(8, entidade.isNoturno());
            comando.setInt(9, entidade.getVagasTurno());
            comando.setInt(10, entidade.getCargaHoraria());
            comando.setString(11, entidade.getRegimeLetivo());
            comando.setString(12, entidade.getPeriodo());
            comando.setString(13, entidade.getNomeProfessor());
            comando.setLong(14, entidade.getCpf());
            comando.setString(15, entidade.getTitulacao());
            comando.setString(16, entidade.getTempoDedicacao());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir!" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(CursoBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_curso SET tipo=?, modalidade=?, denominacao=?, habilitacao=?, localOferta=?, matutino=?, vespertino=?, noturno=?, vagasTurno=?, cargaHoraria=?, regimeLetivo=?, periodo=?, nomeProfessor=?, cpf=?, titulacao=?, tempoDedicacao=? WHERE id_curso=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTipo());
            comando.setString(2, entidade.getModalidade());
            comando.setString(3, entidade.getDenominacao());
            comando.setString(4, entidade.getHabilitacao());
            comando.setString(5, entidade.getLocalOferta());
            comando.setBoolean(6, entidade.isMatutino());
            comando.setBoolean(7, entidade.isVespertino());
            comando.setBoolean(8, entidade.isNoturno());
            comando.setInt(9, entidade.getVagasTurno());
            comando.setInt(10, entidade.getCargaHoraria());
            comando.setString(11, entidade.getRegimeLetivo());
            comando.setString(12, entidade.getPeriodo());
            comando.setString(13, entidade.getNomeProfessor());
            comando.setLong(14, entidade.getCpf());
            comando.setString(15, entidade.getTitulacao());
            comando.setString(16, entidade.getTempoDedicacao());
            comando.setInt(17, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(CursoBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_curso WHERE id_curso=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir!" + ex.getMessage(), ex);
        }

    }

    @Override
    public CursoBean consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_curso WHERE id_curso=?";
        CursoBean curso = new CursoBean();
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                
                curso.setId(resultado.getInt(1));
                curso.setTipo(resultado.getString(2));
                curso.setModalidade(resultado.getString(3));
                curso.setDenominacao(resultado.getString(4));
                curso.setHabilitacao(resultado.getString(5));
                curso.setLocalOferta(resultado.getString(6));
                curso.setMatutino(resultado.getBoolean(7));
                curso.setVespertino(resultado.getBoolean(8));
                curso.setNoturno(resultado.getBoolean(9));
                curso.setVagasTurno(resultado.getInt(10));
                curso.setCargaHoraria(resultado.getInt(11));
                curso.setRegimeLetivo(resultado.getString(12));
                curso.setPeriodo(resultado.getString(13));
                curso.setNomeProfessor(resultado.getString(14));
                curso.setCpf(resultado.getLong(15));
                curso.setTitulacao(resultado.getString(16));
                curso.setTempoDedicacao(resultado.getString(17));
            }
            
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!" + ex.getMessage(), ex);
        }
        return curso;
    }

    @Override
    public List<CursoBean> listar() throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_curso";
                List <CursoBean> lista = new ArrayList<>();
                
                 try{
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                CursoBean curso = new CursoBean();
                curso.setId(resultado.getInt(1));
                curso.setTipo(resultado.getString(2));
                curso.setModalidade(resultado.getString(3));
                curso.setDenominacao(resultado.getString(4));
                curso.setHabilitacao(resultado.getString(5));
                curso.setLocalOferta(resultado.getString(6));
                curso.setMatutino(resultado.getBoolean(7));
                curso.setVespertino(resultado.getBoolean(8));
                curso.setNoturno(resultado.getBoolean(9));
                curso.setVagasTurno(resultado.getInt(10));
                curso.setCargaHoraria(resultado.getInt(11));
                curso.setRegimeLetivo(resultado.getString(12));
                curso.setPeriodo(resultado.getString(13));
                curso.setNomeProfessor(resultado.getString(14));
                curso.setCpf(resultado.getLong(15));
                curso.setTitulacao(resultado.getString(16));
                curso.setTempoDedicacao(resultado.getString(17));
                lista.add(curso);
            }
            
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!" + ex.getMessage(), ex);
        }             
            return lista;
    }
    
    
}
