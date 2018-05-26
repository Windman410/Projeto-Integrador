package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;



public class BibliografiaBO implements BO<BibliografiaBean>{

    @Override
    public void validar(BibliografiaBean entidade) throws NegocioException {
        if(entidade.getTitulo().isEmpty()){
            throw new NegocioException("O Campo Título é Obrigatório!");
        }
        if(entidade.getAutor().isEmpty()){
            throw new NegocioException("O Campo Autor é Obrigatório!");
        }
        if(entidade.getAno()== -1){
            throw new NegocioException("O Campo Ano é obrigatório!");
        }else {
        }
        if(entidade.getIsbn().isEmpty()){
            throw new NegocioException("O Campo ISBN é Obrigatório!");
        }
        if(entidade.getEditora().isEmpty()){
            throw new NegocioException("O Campo Editora é Obrigatório!");
        }
        
    }

    @Override
    public void inserir(BibliografiaBean entidade) throws NegocioException {
        validar(entidade);
        BibliografiaDAO dao = new BibliografiaDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir dados!", ex);
        }
    }

    @Override
    public void alterar(BibliografiaBean entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        DAO dao = new BibliografiaDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(BibliografiaBean entidade) throws NegocioException {
        consultar(entidade.getId());
        DAO dao = new BibliografiaDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public BibliografiaBean consultar(int id) throws NegocioException {
        BibliografiaDAO dao = new BibliografiaDAO();
        BibliografiaBean cadBiblio = new BibliografiaBean();
        
        try{
            cadBiblio = dao.consultar(id);
            if(cadBiblio.getId() == 0){
                throw new NegocioException("Bibliografia não encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao consultar!\n"+ ex.getMessage(), ex);
        }
        return cadBiblio;
    }

    @Override
    public List<BibliografiaBean> listar() throws NegocioException {
        List<BibliografiaBean> lista = new ArrayList<>();
        BibliografiaDAO dao = new BibliografiaDAO();       
        try{
            lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhuma Bibliografia encontrada!");
            }
        }catch(DadosException ex){
            throw new NegocioException("Erro ao listar!\n"+ ex.getMessage(), ex);
        }
        return lista;
    }
}
