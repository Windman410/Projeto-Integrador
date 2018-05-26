package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;

public class PPCBO implements BO<PPCBean>{

    @Override
    public void validar(PPCBean entidade) throws NegocioException {
        if(entidade.getPerfilCurso().isEmpty()){
            throw new NegocioException("O campo Perfil do Curso é Obrigatório");
        }
        
        if(entidade.getPerfilEgresso().isEmpty()){
            throw new NegocioException("O campo Perfil do Egresso é Obrigatório");
        }
        
        if(entidade.getFormaAcesso().isEmpty()){
            throw new NegocioException("O campo Formas de Acesso é Obrigatório");
        }
        
        if(entidade.getRepresentacao().isEmpty()){
            throw new NegocioException("O campo Representação Gráfica de um Perfil de Formação é Obrigatório");
        }
        
        if(entidade.getAvaliacaoProcesso().isEmpty()){
            throw new NegocioException("O campo Sistema de Avaliação do Processo de Ensino e Aprendizagem é Obrigatório");
        }
        
        if(entidade.getAvaliacaoProjeto().isEmpty()){
            throw new NegocioException("O campo Sistema do Projeto de Curso é Obrigatório");
        }
        // Na camada de apresentação, caso não tenha sido digitado nenhum valor, envie o valor -1.
        if(entidade.getHorasTCC() == -1){
            throw new NegocioException("O campo Trabalho de Conclusão de Curso é Obrigatório");
        } else {
        }
        
        if(entidade.getHorasEstagio() == -1){
            throw new NegocioException("O campo Estágio Curricular é Obrigatório");
        }
        
        // Na camada de apresentação, caso tenha sido digitado um valor não numerico, envie o valor -2.        
        if(entidade.getHorasTCC() == -2){
            throw new NegocioException("O campo Trabalho de Conclusão de Curso aceita apenas Números");
        } else {
        }
        
        if(entidade.getHorasEstagio() == -2){
            throw new NegocioException("O campo Estágio Curricular aceita apenas Números");
        }
        
        if(entidade.getPoliticaDeAtendimento().isEmpty()){
            throw new NegocioException("O campo Política de Atendimento a Pessoas com Deficiencia e/ou Mobilidade Reduzida é Obrigatório");
        }
    }

    @Override
    public void inserir(PPCBean entidade) throws NegocioException {
        validar(entidade);
        DAO dao = new PPCDAO();
        try{
            dao.inserir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Inserir o dados!",ex);
        }
    }

    @Override
    public void alterar(PPCBean entidade) throws NegocioException {
        PPCBean ppc = consultar(entidade.getID());
        validar(entidade);
        DAO dao = new PPCDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(PPCBean entidade) throws NegocioException {
        PPCBean ppc = consultar(entidade.getID());
        DAO dao = new PPCDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public PPCBean consultar(int id) throws NegocioException {
        PPCDAO dao = new PPCDAO();
        PPCBean ppc = new PPCBean();
        try{
            ppc = dao.consultar(id);
            if(ppc.getID() == 0){
                throw new NegocioException("PCC não encontrado");
            }
        }catch(DadosException ex){
            throw new NegocioException("PCC não encontrado" + ex.getMessage(), ex);
        }        
        return ppc;
    }

    @Override
    public List<PPCBean> listar() throws NegocioException {
        List<PPCBean> lista = new ArrayList<PPCBean>();
        PPCDAO dao = new PPCDAO();        
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum PPC cadastrado");        
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Listar",ex);
        }
        return lista;
    }
    
}
