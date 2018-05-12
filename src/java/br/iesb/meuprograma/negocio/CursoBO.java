package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;


public class CursoBO implements BO<CursoBean>{

    @Override
    public void validar(CursoBean entidade) throws NegocioException {
        if(entidade.getTipo().isEmpty()){
            throw new NegocioException("O campo Tipo de Curso é Obrigatório");
        }
        if(entidade.getModalidade().isEmpty()){
            throw new NegocioException("O campo Modalidade é Obrigatório");
        }
        if(entidade.getDenominacao().isEmpty()){
            throw new NegocioException("O campo Denominação (Nome do Curso) é Obrigatório");
        }
        if(entidade.getHabilitacao().isEmpty()){
            throw new NegocioException("O campo Habilitação é Obrigatório");
        }
        if(entidade.getLocalOferta().isEmpty()){
            throw new NegocioException("O campo Local de Oferta é Obrigatório");
        }
        if(entidade.getVagasTurno()== -1){
            throw new NegocioException("O campo Vagas por Turno é Obrigatório");
        } else if(entidade.getVagasTurno() == -2){
            throw new NegocioException("O campo Vagas por Turno aceita apenas Números");
        }
        if(entidade.getCargaHoraria()== -1){
            throw new NegocioException("O campo Carga Horária é Obrigatório");
        } else if(entidade.getCargaHoraria() == -2){
            throw new NegocioException("O campo Carga Horária aceita apenas Números");
        }
        if(entidade.getRegimeLetivo().isEmpty()){
            throw new NegocioException("O campo Regime Letivo é Obrigatório");
        }
        if(entidade.getPeriodo().isEmpty()){
            throw new NegocioException("O campo Período é Obrigatório");
        }
        if(entidade.getNomeProfessor().isEmpty()){
            throw new NegocioException("O campo Nome é Obrigatório");
        }
    }

    @Override
    public void inserir(CursoBean entidade) throws NegocioException {
        validar(entidade);
        CursoDAO dao = new CursoDAO(); 
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir dados!" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(CursoBean entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        CursoDAO dao = new CursoDAO(); 
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao alterar dados!" + ex.getMessage(), ex);
        }
        
    }

    @Override
    public void excluir(CursoBean entidade) throws NegocioException {
        consultar(entidade.getId());
        CursoDAO dao = new CursoDAO(); 
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao excluir dados!" + ex.getMessage(), ex);
        }
    }

    @Override
    public CursoBean consultar(int id) throws NegocioException {
        CursoBean curso = new CursoBean();
        CursoDAO dao = new CursoDAO(); 
        try {
            curso = dao.consultar(id);
            if(curso.getId() == 0){
                throw new NegocioException("Curso não encontrado!");
            }
        }catch(DadosException ex) {
            throw new NegocioException("Erro ao consultar dados!" + ex.getMessage(), ex);
        }
        return curso;
    }

    @Override
    public List<CursoBean> listar() throws NegocioException {
        List<CursoBean> lista = new ArrayList<>();
        CursoDAO dao = new CursoDAO();
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum curso cadastrado!");
            }
        }catch(DadosException ex) {
            throw new NegocioException("Erro ao listar dados!" + ex.getMessage(), ex);
        }
        return lista;
    }
    
}
