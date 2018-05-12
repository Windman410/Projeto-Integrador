package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaBO implements BO<DisciplinaBean>{

    @Override
    public void validar(DisciplinaBean entidade) throws NegocioException {
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
    public void inserir(DisciplinaBean entidade) throws NegocioException {
        try {
            //validar(entidade);
            DisciplinaDAO dao = new DisciplinaDAO();
                dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(DisciplinaBean entidade) throws NegocioException {
        consultar(entidade.getCod());
        validar(entidade);
        DisciplinaDAO dao = new DisciplinaDAO();
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao alterar!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(DisciplinaBean entidade) throws NegocioException {
        consultar(entidade.getCod());
        DisciplinaDAO dao = new DisciplinaDAO();
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao excluir!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public DisciplinaBean consultar(int id) throws NegocioException {
        DisciplinaDAO dao = new DisciplinaDAO();
        DisciplinaBean caddisc = new DisciplinaBean();
        
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
    public List<DisciplinaBean> listar() throws NegocioException {
        List<DisciplinaBean> lista = new ArrayList<>();
        DisciplinaDAO dao = new DisciplinaDAO();       
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
