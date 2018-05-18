package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;

public class PlanoDeEnsinoBO implements BO<PlanoDeEnsinoBean>{

    @Override
    public void validar(PlanoDeEnsinoBean entidade) throws NegocioException {
        if(entidade.getCurso().isEmpty()){
            throw new NegocioException("O campo  Curso é Obrigatório");
        }
        if(entidade.getAno()== -1){
            throw new NegocioException("O campo Ano é Obrigatório");
        } else if(entidade.getAno()== -2){
            throw new NegocioException("O campo Ano aceita apenas Números");
        }
        if(entidade.getSemestre()== -1){
            throw new NegocioException("O campo Semestre é Obrigatório");
        } else if(entidade.getSemestre()== -2){
            throw new NegocioException("O campo Semestre aceita apenas Números");
        }
        if(entidade.getDisciplinas().isEmpty()){
            throw new NegocioException("O campo Disciplina é Obrigatório");
        }
        if(entidade.getCargaHoraria()== -1){
            throw new NegocioException("O campo Carga Horária é Obrigatório");
        } else if(entidade.getCargaHoraria()== -2){
            throw new NegocioException("O campo Carga Horária aceita apenas Números");
        }
        if(entidade.getPeriodo().isEmpty()){
            throw new NegocioException("O campo Período é Obrigatório");
        }
        if(entidade.getProfessor().isEmpty()){
            throw new NegocioException("O campo Professor é Obrigatório");
        }
        if(entidade.getEmenta().isEmpty()){
            throw new NegocioException("O campo Ementa é Obrigatório");
        }
        if(entidade.getCompetenciasHabilidades().isEmpty()){
            throw new NegocioException("O campo Competências e Habilidades é Obrigatório");
        }
        if(entidade.getMetodologia().isEmpty()){
            throw new NegocioException("O campo Metodologia é Obrigatório");
        }
        if(entidade.getAvaliacao().isEmpty()){
            throw new NegocioException("O campo Avaliação é Obrigatório");
        }   
    }

    @Override
    public void inserir(PlanoDeEnsinoBean entidade) throws NegocioException {
        validar(entidade);
        PlanoDeEnsinoDAO dao = new PlanoDeEnsinoDAO(); 
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir dados!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(PlanoDeEnsinoBean entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        PlanoDeEnsinoDAO dao = new PlanoDeEnsinoDAO();  
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao alterar dados!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void excluir(PlanoDeEnsinoBean entidade) throws NegocioException {
        consultar(entidade.getId());
        PlanoDeEnsinoDAO dao = new PlanoDeEnsinoDAO();  
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao excluir dados!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public PlanoDeEnsinoBean consultar(int id) throws NegocioException {
        PlanoDeEnsinoBean planodeensino = new PlanoDeEnsinoBean();
        PlanoDeEnsinoDAO dao = new PlanoDeEnsinoDAO(); 
        try {
            planodeensino = dao.consultar(id);
            if(planodeensino.getId() == 0){
                throw new NegocioException("Plano de Ensino não encontrado!");
            }
        }catch(DadosException ex) {
            throw new NegocioException("Erro ao consultar dados!\n"+ ex.getMessage(), ex);
        }
        return planodeensino;
    }

    @Override
    public List<PlanoDeEnsinoBean> listar() throws NegocioException {
        List<PlanoDeEnsinoBean> lista = new ArrayList<>();
        PlanoDeEnsinoDAO dao = new PlanoDeEnsinoDAO();
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum plano de ensino cadastrado!");
            }
        }catch(DadosException ex) {
            throw new NegocioException("Erro ao listar dados!\n"+ ex.getMessage(), ex);
        }
        return lista;
    }
    
}
