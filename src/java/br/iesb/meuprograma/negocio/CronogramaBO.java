package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.CronogramaBean;
import br.iesb.meuprograma.dados.CronogramaDAO;
import br.iesb.meuprograma.dados.DadosException;
import java.util.ArrayList;
import java.util.List;

public class CronogramaBO implements BO<CronogramaBean>{

    @Override
    public void validar(CronogramaBean entidade) throws NegocioException {
        if(entidade.getAula()== -1){
            throw new NegocioException("O Campo Aula é Obrigatório!");
        }else {
        }
        if(entidade.getConteudo().isEmpty()){
            throw new NegocioException("O Campo Conteúdo é Obrigatório!");
        }
    }

    @Override
    public void inserir(CronogramaBean entidade) throws NegocioException {
        validar (entidade);
        CronogramaDAO dao = new CronogramaDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir dados!\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(CronogramaBean entidade) throws NegocioException {
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
    public void excluir(CronogramaBean entidade) throws NegocioException {
        consultar(entidade.getId());
        CronogramaDAO dao = new CronogramaDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public CronogramaBean consultar(int id) throws NegocioException {
        CronogramaDAO dao = new CronogramaDAO();
        CronogramaBean cronograma = new CronogramaBean();
        
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
    public List<CronogramaBean> listar() throws NegocioException {
        List<CronogramaBean> lista = new ArrayList<>();
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
