package br.iesb.meuprograma.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AtasDAO implements DAO<Atas>{
    
    
    @Override
    public void inserir(Atas entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_atas (data, local, participantes, deliberacoes) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getData());
            comando.setString(2, entidade.getLocal());
            comando.setString(3, entidade.getParticipantes());
            comando.setString(4, entidade.getDeliberacoes());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir!", ex);
        }
    }

    @Override
    public void alterar(Atas entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_atas SET data=?, local=?, participantes=?, deliberacoes=? WHERE id_atas=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getData());
            comando.setString(2, entidade.getLocal());
            comando.setString(3, entidade.getParticipantes());
            comando.setString(4, entidade.getDeliberacoes());
            comando.setInt(5, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(Atas entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_atas WHERE id_atas=?";
        
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
    public Atas consultar(int id) throws DadosException {
         Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_atas WHERE id_atas=?";
                Atas atas = new Atas();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                atas.setId(resultado.getInt(1));
                atas.setData(resultado.getInt(2));
                atas.setLocal(resultado.getString(3));
                atas.setParticipantes(resultado.getString(4));
                atas.setDeliberacoes(resultado.getString(5));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return atas;
    }

    @Override
    public List<Atas> listar() throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_atas";
        List <Atas> lista = new ArrayList<>();
                
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                Atas atas = new Atas();
                atas.setId(resultado.getInt(1));
                atas.setData(resultado.getInt(2));
                atas.setLocal(resultado.getString(3));
                atas.setParticipantes(resultado.getString(4));
                atas.setDeliberacoes(resultado.getString(5));
                lista.add(atas);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!\n" + ex.getMessage(), ex);
        }
        return lista;
    }
}
