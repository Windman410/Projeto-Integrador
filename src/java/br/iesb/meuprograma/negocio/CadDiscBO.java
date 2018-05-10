package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;


public class CadDiscBO implements BO<CadDisc>{

    @Override
    public void validar(CadDisc entidade) throws NegocioException {
        if(entidade.getNome().isEmpty()){
            throw new NegocioException("O Nome é obrigatório!");
        }
        
        if(entidade.getCod()== -1){
            throw new NegocioException("O campo Código é obrigatório!");
        }else {
        }
                
        if(entidade.getDescricao().isEmpty()){
            throw new NegocioException("O campo Descrição é Obrigatório");
        }
        if(entidade.getSemestre()== -1){
            throw new NegocioException("O campo Semestre é Obrigatório");
        }
        
        if(entidade.getCargaHoraria()== -1){
            throw new NegocioException("O campo Carga Horária é Obrigatório");
        }
        // Na camada de apresentação, caso tenha sido digitado um valor não numerico, envie o valor -2.        
        if(entidade.getCod()== -2){
            throw new NegocioException("O campo Código aceita apenas números!");
        } else {
        }
        if(entidade.getSemestre()== -2){
            throw new NegocioException("O campo Semestre aceita apenas números!");
        } else {
        }
        if(entidade.getCargaHoraria()== -2){
            throw new NegocioException("O campo Carga Horária aceita apenas números!");
        } else {
        }
    }

    @Override
    public void inserir(CadDisc entidade) throws NegocioException {
        validar (entidade);
        CadDiscDAO dao = new CadDiscDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(CadDisc entidade) throws NegocioException {
        consultar(entidade.getCod());
        validar (entidade);
        CadDiscDAO dao = new CadDiscDAO();
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao alterar!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(CadDisc entidade) throws NegocioException {
        consultar(entidade.getCod());
        CadDiscDAO dao = new CadDiscDAO();
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao excluir!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public CadDisc consultar(int id) throws NegocioException {
        CadDiscDAO dao = new CadDiscDAO();
        CadDisc caddisc = new CadDisc();
        
        try{
            caddisc = dao.consultar(id);
            if(caddisc.getCod() == 0){
                throw new NegocioException("Disciplina não encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao consultar!\n"+ ex.getMessage(), ex);
        }
        return caddisc;
    }

    @Override
    public List<CadDisc> listar() throws NegocioException {
        List<CadDisc> lista = new ArrayList<>();
        CadDiscDAO dao = new CadDiscDAO();       
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenuma disciplina encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao listar!\n"+ ex.getMessage(), ex);
        }
        return lista;
    }
    
}
