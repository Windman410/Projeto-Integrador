package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorBO implements BO<ProfessorBean>{

    @Override
    public void validar(ProfessorBean entidade) throws NegocioException {
        if(entidade.getNome().isEmpty()){
            throw new NegocioException("O campo Nome é Obrigatório");
        }
        
        if(entidade.getCpf() == -1){
            throw new NegocioException("O campo CPF é Obrigatório");
        } else if(entidade.getCpf() == -2){
            throw new NegocioException("O campo CPF aceita apenas Números");
        } else if(entidade.getCpf() == -3){
            throw new NegocioException("Esse CPF é Ínvalido");
        }
        
        if(entidade.getMaiorTitulacao().isEmpty()){
            throw new NegocioException("O campo Maior Titulação é Obrigatório");
        }
        
        if(entidade.getCurriculo().isEmpty()){
            throw new NegocioException("O campo Currículo Lattes(Link) é Obrigatório");
        }
        
        if(entidade.getDataAtualizacao().isEmpty()){
            throw new NegocioException("O campo Data de Atualizacao é Obrigatório");
        }
        
        
        if(entidade.getMatricula() == -1){
            throw new NegocioException("O campo Matricula é Obrigatório");
        } else if(entidade.getMatricula() == -2){
            throw new NegocioException("O campo Matricula aceita apenas Números");
        } else if(entidade.getMatricula() == -3){
            throw new NegocioException("Essa Matricula é Ínvalido");
        }
        
        
        if(entidade.getDataAdimissao().isEmpty()){
            throw new NegocioException("O campo Data de Adimissão é Obrigatório");
        }
    }

    @Override
    public void inserir(ProfessorBean entidade) throws NegocioException {
        validar(entidade);
        DAO dao = new ProfessorDAO();
        try{
            dao.inserir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Inserir os dados\n"+ ex.getMessage(),ex);
        }
    }

    @Override
    public void alterar(ProfessorBean entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        DAO dao = new ProfessorDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n"+ ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(ProfessorBean entidade) throws NegocioException {
        consultar(entidade.getId());
        DAO dao = new ProfessorDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n"+ ex.getMessage(),ex);
        }
    }

    @Override
    public ProfessorBean consultar(int id) throws NegocioException {
        ProfessorDAO dao = new ProfessorDAO();
        ProfessorBean professor = new ProfessorBean();
        try{
            professor = dao.consultar(id);
            if(professor.getId() == 0){
                throw new NegocioException("Professor não encontrado");
            }
        }catch(DadosException ex){
            throw new NegocioException("Professor não encontrado\n"+ ex.getMessage(), ex);
        }        
        return professor;
    }

    @Override
    public List<ProfessorBean> listar() throws NegocioException {
        List<ProfessorBean> lista = new ArrayList<>();
        ProfessorDAO professor = new ProfessorDAO();        
        try{
            lista = professor.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum Professor cadastrado");        
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Listar\n"+ ex.getMessage(),ex);
        }
        return lista;
    }
    
}
