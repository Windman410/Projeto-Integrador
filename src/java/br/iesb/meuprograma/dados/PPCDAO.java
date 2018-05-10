/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iesb.meuprograma.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mamãe
 */
public class PPCDAO implements DAO<PPC>{

    @Override
    public void inserir(PPC entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_ppc (cursoPPC,perfilCurso,perfilEgresso,formaAcesso,representacao,avaliacaoProcesso,avaliacaoProjeto,horasTCC,horasEstagio,politicaDeAtendimento) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCursoPPC());
            comando.setString(2, entidade.getPerfilCurso());
            comando.setString(3, entidade.getPerfilEgresso());
            comando.setString(4, entidade.getFormaAcesso());
            comando.setString(5, entidade.getRepresentacao());
            comando.setString(6, entidade.getAvaliacaoProcesso());
            comando.setString(7, entidade.getAvaliacaoProjeto());
            comando.setInt(8, entidade.getHorasTCC());
            comando.setInt(9, entidade.getHorasEstagio());
            comando.setString(10, entidade.getPoliticaDeAtendimento());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir no Banco de Dados!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(PPC entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_ppc SET cursoPPC=?, perfilCurso=?, perfilEgresso=?, formaAcesso=?, representacao=?, avaliacaoProcesso=?, avaliacaoProjeto=?, horasTCC=?, horasEstagio=?, politicaDeAtendimento=? WHERE id_ppc=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCursoPPC());
            comando.setString(2, entidade.getPerfilCurso());
            comando.setString(3, entidade.getPerfilEgresso());
            comando.setString(4, entidade.getFormaAcesso());
            comando.setString(5, entidade.getRepresentacao());
            comando.setString(6, entidade.getAvaliacaoProcesso());
            comando.setString(7, entidade.getAvaliacaoProjeto());
            comando.setInt(8, entidade.getHorasTCC());
            comando.setInt(9, entidade.getHorasEstagio());
            comando.setString(10, entidade.getPoliticaDeAtendimento());
            comando.setInt(11, entidade.getID());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(PPC entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_ppc WHERE id_ppc=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getID());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public PPC consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_ppc WHERE id_ppc=?";
        PPC ppc = new PPC();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                ppc.setID(resultado.getInt(1));
                ppc.setCursoPPC(resultado.getString(2));
                ppc.setPerfilCurso(resultado.getString(3));
                ppc.setPerfilEgresso(resultado.getString(4));
                ppc.setFormaAcesso(resultado.getString(5));
                ppc.setRepresentacao(resultado.getString(6));
                ppc.setAvaliacaoProcesso(resultado.getString(7));
                ppc.setAvaliacaoProjeto(resultado.getString(8));
                ppc.setHorasTCC(resultado.getInt(9));
                ppc.setHorasEstagio(resultado.getInt(10));
                ppc.setPoliticaDeAtendimento(resultado.getString(11));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return ppc;
    }

    @Override
    public List<PPC> listar() throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM tb_ppc";
        ArrayList<PPC> listaPPC = new ArrayList<PPC>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while (resultado.next()){
                PPC ppc = new PPC();
                ppc.setID(resultado.getInt(1));
                ppc.setCursoPPC(resultado.getString(2));
                ppc.setPerfilCurso(resultado.getString(3));
                ppc.setPerfilEgresso(resultado.getString(4));
                ppc.setFormaAcesso(resultado.getString(5));
                ppc.setRepresentacao(resultado.getString(6));
                ppc.setAvaliacaoProcesso(resultado.getString(7));
                ppc.setAvaliacaoProjeto(resultado.getString(8));
                ppc.setHorasTCC(resultado.getInt(9));
                ppc.setHorasEstagio(resultado.getInt(10));
                ppc.setPoliticaDeAtendimento(resultado.getString(11));
                listaPPC.add(ppc);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!\n"+ ex.getMessage(), ex);
        }
        return listaPPC;
    }

}
