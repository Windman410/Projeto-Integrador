package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.Cronograma;
import br.iesb.meuprograma.dados.CronogramaDAO;
import br.iesb.meuprograma.dados.DadosException;
import java.util.ArrayList;
import java.util.List;

public class CronogramaBO implements BO<Cronograma>{

    @Override
    public void validar(Cronograma entidade) throws NegocioException {
        if(entidade.getAula()== -1){
            throw new NegocioException("O campo Aula é obrigatório!");
        }else {
        }
        if(entidade.getConteudo().isEmpty()){
            throw new NegocioException("O campo Conteúdo é Obrigatório");
        }
    }

    @Override
    public void inserir(Cronograma entidade) throws NegocioException {
        validar (entidade);
        CronogramaDAO dao = new CronogramaDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(Cronograma entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        CronogramaDAO dao = new CronogramaDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(Cronograma entidade) throws NegocioException {
        consultar(entidade.getId());
        CronogramaDAO dao = new CronogramaDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public Cronograma consultar(int id) throws NegocioException {
        CronogramaDAO dao = new CronogramaDAO();
        Cronograma cronograma = new Cronograma();
        
        try{
            cronograma = dao.consultar(id);
            if(cronograma.getId() == 0){
                throw new NegocioException("Cronograma não encontrado!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao consultar!\n"+ ex.getMessage(), ex);
        }
        return cronograma;
    }

    @Override
    public List<Cronograma> listar() throws NegocioException {
        List<Cronograma> lista = new ArrayList<>();
        CronogramaDAO dao = new CronogramaDAO();       
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenuma Cronograma encontrado!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao listar!\n"+ ex.getMessage(), ex);
        }
        return lista;
    }
    
}
