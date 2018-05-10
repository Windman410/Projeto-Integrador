/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.iesb.meuprograma.dados;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoMecDAO implements DAO<AvaliacaoMec> {

    @Override
    public void inserir(AvaliacaoMec entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO AvaliacaoMec (nome) VALUES (?)";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getDenominaçãoCurso());
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir no banco de Dados", ex);
        }
    }

    @Override
    public void alterar(AvaliacaoMec entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE AvaliacaoMec SET nome=? WHERE cod=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getDenominaçãoCurso());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!", ex);
        }
    }

    @Override
    public void excluir(AvaliacaoMec entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM AvaliacaoMec WHERE id=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir!", ex);
        }
    }

    @Override
    public AvaliacaoMec consultar(int id) throws DadosException {
                Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM AvaliacaoMec WHERE id=?";
                AvaliacaoMec avaliacaoMec = new AvaliacaoMec();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                avaliacaoMec.setDenominaçãoCurso(resultado.getString(2));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!", ex);
        }
        return avaliacaoMec;
    }

    @Override
    public List<AvaliacaoMec> listar() throws DadosException {
                Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM AvaliacaoMec";
                List <AvaliacaoMec> lista = new ArrayList<AvaliacaoMec>();
                
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                AvaliacaoMec avaliacaoMec = new AvaliacaoMec();
                avaliacaoMec.setDenominaçãoCurso(resultado.getString(2));
                lista.add(avaliacaoMec);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!", ex);
        }
                return lista;
    }
    
}
