/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoMecBO implements BO<AvaliacaoMec>{

    
    
    @Override
    public void validar(AvaliacaoMec entidade) throws NegocioException {
        if(entidade.getTipoCurso()== -1){
            throw new NegocioException("O campo Tipo de Curso é obrigatório!");
        }else if(entidade.getTipoCurso()== -2){
            throw new NegocioException("Valor Invalido para o campo Tipo de Curso");
        }
        else if(entidade.getLocalOferta() == -1){
            throw new NegocioException("O campo Local de Oferta é obrigatório!");
        }else if(entidade.getLocalOferta()== -2){
            throw new NegocioException("Valor Invalido para o campo Local de Oferta");
        }
        else if(entidade.getDenominaçãoCurso().isEmpty()){
            throw new NegocioException("O campo Denominação de Curso é Obrigatório");
        }
        else if(entidade.getModalidade().isEmpty()){
            throw new NegocioException("O campo Modalidade é Obrigatório");
        }
         
    }

    @Override
    public void inserir(AvaliacaoMec entidade) throws NegocioException {
        validar (entidade);
        AvaliacaoMecDAO dao = new AvaliacaoMecDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(AvaliacaoMec entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        DAO dao = new AvaliacaoMecDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(AvaliacaoMec entidade) throws NegocioException {
        consultar(entidade.getId());
        DAO dao = new AvaliacaoMecDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public AvaliacaoMec consultar(int id) throws NegocioException {
        AvaliacaoMecDAO dao = new AvaliacaoMecDAO();
        AvaliacaoMec avaliacaoMec = new AvaliacaoMec();
        
        try{
            avaliacaoMec = dao.consultar(id);
            if(avaliacaoMec.getId() == 0){
                throw new NegocioException("Nota não encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao consultar!\n" + ex.getMessage(), ex);
        }
        return avaliacaoMec;
    }

    @Override
    public List<AvaliacaoMec> listar() throws NegocioException {
        List<AvaliacaoMec> lista = new ArrayList<>();
        AvaliacaoMecDAO dao = new AvaliacaoMecDAO();       
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenuma nota encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao listar!\n" + ex.getMessage(), ex);
        }
        return lista;
    }
    
    
}
