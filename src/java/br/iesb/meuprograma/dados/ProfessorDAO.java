package br.iesb.meuprograma.dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAO implements DAO<ProfessorBean> {

    @Override
    public void inserir(ProfessorBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO tb_professor (nome,cpf,maiorTitulacao,areaFormacao,curriculo,dataAtualizacao,matricula,dataAdimissao,horasNDE"
                + ",horasOrientacaoTCC,horasCordenacaoCurso,horasCordenacaoOutrosCurso,horasPesquisa,horasExtraClasseCurso,horasExtraClasseOutrosCurso"
                + ",horasCurso,horasOutrosCurso,disciplinaCurso,cargaHorariaCurso,disciplinaOutrosCurso,cargaHorariaOutrosCurso"
                + ",membroNDE,membroColegiado,experienciaPedagogia,tempoVinculoCurso,dataInicialVinculoCurso,experienciaMagisterioSuperior,dataInicialMagisterioSuperior,experienciaCursoDistancia,dataInicialCursoDistancia,experienciaProfissional"
                + ",dataInicialExperienciaProfissional, participacaoEventos,artigoCientificoArea,artigoCientificoOutrasArea,livrosCapitulosArea,livrosCapitulosOutrasArea,trabalhoAnaisArea"
                + ",trabalhoAnaisOutrasArea,propriedadeIntelectualArea,propriedadeIntelectualOutrasArea,traducoesPublicadas"
                + ",projetoTecnicaArtisticaCultural,producoesDidaticoPedagogico) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNome());
            comando.setLong(2, entidade.getCpf());
            comando.setString(3, entidade.getMaiorTitulacao());
            comando.setString(4, entidade.getAreaFormacao());
            comando.setString(5, entidade.getCurriculo());
            comando.setString(6, entidade.getDataAtualizacao());
            comando.setInt(7, entidade.getMatricula());
            comando.setString(8, entidade.getDataAdimissao());
            comando.setInt(9, entidade.getHorasNDE());
            comando.setInt(10, entidade.getHorasOrientacaoTCC());
            comando.setInt(11, entidade.getHorasCordenacaoCurso());
            comando.setInt(12, entidade.getHorasCordenacaoOutrosCurso());
            comando.setInt(13, entidade.getHorasPesquisa());
            comando.setInt(14, entidade.getHorasExtraClasseCurso());
            comando.setInt(15, entidade.getHorasExtraClasseOutrosCurso());
            comando.setInt(16, entidade.getHorasCurso());
            comando.setInt(17, entidade.getHorasOutrosCurso());
            comando.setInt(18, entidade.getDisciplinaCurso());
            comando.setInt(19, entidade.getCargaHorariaCurso());
            comando.setInt(20, entidade.getDisciplinaOutrosCurso());
            comando.setInt(21, entidade.getCargaHorariaOutrosCurso());
            comando.setBoolean(22, entidade.isMembroNDE());
            comando.setBoolean(23, entidade.isMembroColegiado());
            comando.setBoolean(24, entidade.isExperienciaPedagogia());
            
            comando.setString(25, entidade.getTempoVinculoCurso());        
            comando.setInt(26, entidade.getDataInicialVinculoCurso());
            
            comando.setString(27, entidade.getExperienciaMagisterioSuperior());
            comando.setInt(28, entidade.getDataInicialMagisterioSuperior());
            
            comando.setString(29, entidade.getExperienciaCursoDistancia());
            comando.setInt(30, entidade.getDataInicialCursoDistancia());
            
            comando.setString(31, entidade.getExperienciaProfissional());
            comando.setInt(32, entidade.getDataInicialExperienciaProfissional());
            
            comando.setInt(33, entidade.getParticipacaoEventos());
            comando.setInt(34, entidade.getArtigoCientificoArea());
            comando.setInt(35, entidade.getArtigoCientificoOutrasArea());
            comando.setInt(36, entidade.getLivrosCapitulosArea());
            comando.setInt(37, entidade.getLivrosCapitulosOutrasArea());
            comando.setInt(38, entidade.getTrabalhoAnaisArea());
            comando.setInt(39, entidade.getTrabalhoAnaisOutrasArea());
            comando.setInt(40, entidade.getPropriedadeIntelectualArea());
            comando.setInt(41, entidade.getPropriedadeIntelectualOutrasArea());
            comando.setInt(42, entidade.getTraducoesPublicadas());
            comando.setInt(43, entidade.getProjetoTecnicaArtisticaCultural());
            comando.setInt(44, entidade.getProducoesDidaticoPedagogico());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro DAO", JOptionPane.ERROR_MESSAGE);
            throw new DadosException("Erro ao inserir no banco de Dados", ex);
        }
    }
    
    
    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    @Override
    public void alterar(ProfessorBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE tb_professor SET nome=?,cpf=?,maiorTitulacao=?,areaFormacao=?,curriculo=?,dataAtualizacao=?,matricula=?,dataAdimissao=?,horasNDE=?"
                + ",horasOrientacaoTCC=?,horasCordenacaoCurso=?,horasCordenacaoOutrosCurso=?,horasPesquisa=?,horasExtraClasseCurso=?,horasExtraClasseOutrosCurso=?"
                + ",horasCurso=?,horasOutrosCurso=?,disciplinaCurso=?,cargaHorariaCurso=?,disciplinaOutrosCurso=?,cargaHorariaOutrosCurso=?"
                + ",membroNDE=?,membroColegiado=?,experienciaPedagogia=?,tempoVinculoCurso=?,experienciaMagisterioSuperior=?,experienciaCursoDistancia=?,experienciaProfissional=?"
                + ",participacaoEventos=?,artigoCientificoArea=?,artigoCientificoOutrasArea=?,livrosCapitulosArea=?,livrosCapitulosOutrasArea=?,trabalhoAnaisArea=?"
                + ",trabalhoAnaisOutrasArea=?,propriedadeIntelectualArea=?,propriedadeIntelectualOutrasArea=?,traducoesPublicadas=?"
                + ",projetoTecnicaArtisticaCultural=?,producoesDidaticoPedagogico=? WHERE id_professor=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNome());
            comando.setLong(2, entidade.getCpf());
            comando.setString(3, entidade.getMaiorTitulacao());
            comando.setString(4, entidade.getAreaFormacao());
            comando.setString(5, entidade.getCurriculo());
            comando.setString(6, entidade.getDataAtualizacao());
            comando.setInt(7, entidade.getMatricula());
            comando.setString(8, entidade.getDataAdimissao());
            comando.setInt(9, entidade.getHorasNDE());
            comando.setInt(10, entidade.getHorasOrientacaoTCC());
            comando.setInt(11, entidade.getHorasCordenacaoCurso());
            comando.setInt(12, entidade.getHorasCordenacaoOutrosCurso());
            comando.setInt(13, entidade.getHorasPesquisa());
            comando.setInt(14, entidade.getHorasExtraClasseCurso());
            comando.setInt(15, entidade.getHorasExtraClasseOutrosCurso());
            comando.setInt(16, entidade.getHorasCurso());
            comando.setInt(17, entidade.getHorasOutrosCurso());
            comando.setInt(18, entidade.getDisciplinaCurso());
            comando.setInt(19, entidade.getCargaHorariaCurso());
            comando.setInt(20, entidade.getDisciplinaOutrosCurso());
            comando.setInt(21, entidade.getCargaHorariaOutrosCurso());
            comando.setBoolean(22, entidade.isMembroNDE());
            comando.setBoolean(23, entidade.isMembroColegiado());
            comando.setBoolean(24, entidade.isExperienciaPedagogia());
            comando.setString(25, entidade.getTempoVinculoCurso());
            comando.setString(26, entidade.getExperienciaMagisterioSuperior());
            comando.setString(27, entidade.getExperienciaCursoDistancia());
            comando.setString(28, entidade.getExperienciaProfissional());
            comando.setInt(29, entidade.getParticipacaoEventos());
            comando.setInt(30, entidade.getArtigoCientificoArea());
            comando.setInt(31, entidade.getArtigoCientificoOutrasArea());
            comando.setInt(32, entidade.getLivrosCapitulosArea());
            comando.setInt(33, entidade.getLivrosCapitulosOutrasArea());
            comando.setInt(34, entidade.getTrabalhoAnaisArea());
            comando.setInt(35, entidade.getTrabalhoAnaisOutrasArea());
            comando.setInt(36, entidade.getPropriedadeIntelectualArea());
            comando.setInt(37, entidade.getPropriedadeIntelectualOutrasArea());
            comando.setInt(38, entidade.getTraducoesPublicadas());
            comando.setInt(39, entidade.getProjetoTecnicaArtisticaCultural());
            comando.setInt(40, entidade.getProducoesDidaticoPedagogico());
            comando.setInt(41, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar!", ex);
        }
    }
    
    
    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    @Override
    public void excluir(ProfessorBean entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM tb_professor WHERE id_professor=?";
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir!", ex);
        }
    }

    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    @Override
    public ProfessorBean consultar(int id) throws DadosException {
                Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_professor WHERE id_professor=?";
                ProfessorBean professor = new ProfessorBean();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                professor.setId(resultado.getInt(1));
                professor.setNome(resultado.getString(2));
                professor.setCpf(resultado.getLong(3));
                professor.setMaiorTitulacao(resultado.getString(4));
                professor.setAreaFormacao(resultado.getString(5));
                professor.setCurriculo(resultado.getString(6));
                professor.setDataAtualizacao(resultado.getString(7));
                professor.setMatricula(resultado.getInt(8));
                professor.setDataAdimissao(resultado.getString(9));
                professor.setHorasNDE(resultado.getInt(10));
                professor.setHorasOrientacaoTCC(resultado.getInt(11));
                professor.setHorasCordenacaoCurso(resultado.getInt(12));
                professor.setHorasCordenacaoOutrosCurso(resultado.getInt(13));
                professor.setHorasPesquisa(resultado.getInt(14));
                professor.setHorasExtraClasseCurso(resultado.getInt(15));
                professor.setHorasExtraClasseOutrosCurso(resultado.getInt(16));
                professor.setHorasCurso(resultado.getInt(17));
                professor.setHorasOutrosCurso(resultado.getInt(18));
                professor.setDisciplinaCurso(resultado.getInt(19));
                professor.setCargaHorariaCurso(resultado.getInt(20));
                professor.setDisciplinaOutrosCurso(resultado.getInt(21));
                professor.setCargaHorariaOutrosCurso(resultado.getInt(22));
                professor.setMembroNDE(resultado.getBoolean(23));
                professor.setMembroColegiado(resultado.getBoolean(24));
                professor.setExperienciaPedagogia(resultado.getBoolean(25));
                professor.setTempoVinculoCurso(resultado.getString(26));
                professor.setExperienciaMagisterioSuperior(resultado.getString(27));
                professor.setExperienciaCursoDistancia(resultado.getString(28));
                professor.setExperienciaProfissional(resultado.getString(29));
                professor.setParticipacaoEventos(resultado.getInt(30));
                professor.setArtigoCientificoArea(resultado.getInt(31));
                professor.setArtigoCientificoOutrasArea(resultado.getInt(32));
                professor.setLivrosCapitulosArea(resultado.getInt(33));
                professor.setLivrosCapitulosOutrasArea(resultado.getInt(34));
                professor.setTrabalhoAnaisArea(resultado.getInt(35));
                professor.setTrabalhoAnaisOutrasArea(resultado.getInt(36));
                professor.setPropriedadeIntelectualArea(resultado.getInt(37));
                professor.setPropriedadeIntelectualOutrasArea(resultado.getInt(38));
                professor.setTraducoesPublicadas(resultado.getInt(39));
                professor.setProjetoTecnicaArtisticaCultural(resultado.getInt(40));
                professor.setProducoesDidaticoPedagogico(resultado.getInt(41));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar!", ex);
        }
        return professor;
    }

    /* Adicionar dataInicialVinculoCurso, dataInicialMagisterioSuperior, dataInicialCursoDistancia, dataInicialExperienciaProfissional */
    
    @Override
    public List<ProfessorBean> listar() throws DadosException {
                Connection conexao = ConexaoBD.getConexao();
                String sql = "SELECT * FROM tb_professor";
                List <ProfessorBean> lista = new ArrayList<>();
                
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                ProfessorBean professor = new ProfessorBean();
                professor.setId(resultado.getInt(1));
                professor.setNome(resultado.getString(2));
                professor.setCpf(resultado.getLong(3));
                professor.setMaiorTitulacao(resultado.getString(4));
                professor.setAreaFormacao(resultado.getString(5));
                professor.setCurriculo(resultado.getString(6));
                professor.setDataAtualizacao(resultado.getString(7));
                professor.setMatricula(resultado.getInt(8));
                professor.setDataAdimissao(resultado.getString(9));
                professor.setHorasNDE(resultado.getInt(10));
                professor.setHorasOrientacaoTCC(resultado.getInt(11));
                professor.setHorasCordenacaoCurso(resultado.getInt(12));
                professor.setHorasCordenacaoOutrosCurso(resultado.getInt(13));
                professor.setHorasPesquisa(resultado.getInt(14));
                professor.setHorasExtraClasseCurso(resultado.getInt(15));
                professor.setHorasExtraClasseOutrosCurso(resultado.getInt(16));
                professor.setHorasCurso(resultado.getInt(17));
                professor.setHorasOutrosCurso(resultado.getInt(18));
                professor.setDisciplinaCurso(resultado.getInt(19));
                professor.setCargaHorariaCurso(resultado.getInt(20));
                professor.setDisciplinaOutrosCurso(resultado.getInt(21));
                professor.setCargaHorariaOutrosCurso(resultado.getInt(22));
                professor.setMembroNDE(resultado.getBoolean(23));
                professor.setMembroColegiado(resultado.getBoolean(24));
                professor.setExperienciaPedagogia(resultado.getBoolean(25));
                professor.setTempoVinculoCurso(resultado.getString(26));
                professor.setExperienciaMagisterioSuperior(resultado.getString(27));
                professor.setExperienciaCursoDistancia(resultado.getString(28));
                professor.setExperienciaProfissional(resultado.getString(29));
                professor.setParticipacaoEventos(resultado.getInt(30));
                professor.setArtigoCientificoArea(resultado.getInt(31));
                professor.setArtigoCientificoOutrasArea(resultado.getInt(32));
                professor.setLivrosCapitulosArea(resultado.getInt(33));
                professor.setLivrosCapitulosOutrasArea(resultado.getInt(34));
                professor.setTrabalhoAnaisArea(resultado.getInt(35));
                professor.setTrabalhoAnaisOutrasArea(resultado.getInt(36));
                professor.setPropriedadeIntelectualArea(resultado.getInt(37));
                professor.setPropriedadeIntelectualOutrasArea(resultado.getInt(38));
                professor.setTraducoesPublicadas(resultado.getInt(39));
                professor.setProjetoTecnicaArtisticaCultural(resultado.getInt(40));
                professor.setProducoesDidaticoPedagogico(resultado.getInt(41));
                lista.add(professor);
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar!", ex);
        }
        return lista;
    }
}

