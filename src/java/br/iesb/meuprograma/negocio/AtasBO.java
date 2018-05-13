
package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;

public class AtasBO implements BO<AtasBean>{

    
    
    @Override
    public void validar(AtasBean entidade) throws NegocioException {
         if(entidade.getData()== -1){
            throw new NegocioException("O campo Data é obrigatório!");
        }else {
        }
        if(entidade.getLocal().isEmpty()){
            throw new NegocioException("O campo Local da reunião é Obrigatório");
        }
        if(entidade.getDeliberacoes().isEmpty()){
            throw new NegocioException("O campo Deliberações é Obrigatório");
        } 
         
          if(entidade.getData()== -2){
            throw new NegocioException("O campo Data aceita apenas números!");
        } else {
        }
    }

    @Override
    public void inserir(AtasBean entidade) throws NegocioException {
        validar (entidade);
        AtasDAO dao = new AtasDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir!\n"+ ex.getMessage(), ex);
        }
    }

    @Override
    public void alterar(AtasBean entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        DAO dao = new AtasDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(AtasBean entidade) throws NegocioException {
        consultar(entidade.getId());
        DAO dao = new AtasDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public AtasBean consultar(int id) throws NegocioException {
        AtasDAO dao = new AtasDAO();
        AtasBean atas = new AtasBean();
        
        try{
            atas = dao.consultar(id);
            if(atas.getId() == 0){
                throw new NegocioException("Ata não encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao consultar!\n"+ ex.getMessage(), ex);
        }
        return atas;
    }

    @Override
    public List<AtasBean> listar() throws NegocioException {
        List<AtasBean> lista = new ArrayList<>();
        AtasDAO dao = new AtasDAO();       
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenuma ata encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao listar!\n"+ ex.getMessage(), ex);
        }
        return lista;
    }
    
    
}
