package br.iesb.meuprograma.negocio;
import br.iesb.meuprograma.dados.*;
import java.util.ArrayList;
import java.util.List;



public class CadBiblioBO implements BO<CadBiblio>{

    @Override
    public void validar(CadBiblio entidade) throws NegocioException {
        if(entidade.getTitulo().isEmpty()){
            throw new NegocioException("O Campo título não pode ser vazio!");
        }
        if(entidade.getAutor().isEmpty()){
            throw new NegocioException("O Campo autor não pode ser vazio!");
        }
        if(entidade.getAno()== -1){
            throw new NegocioException("O campo Ano é obrigatório!");
        }else {
        }
        if(entidade.getIsbn().isEmpty()){
            throw new NegocioException("O Campo ISBN não pode ser vazio!");
        }
        if(entidade.getEditora().isEmpty()){
            throw new NegocioException("O Campo editora não pode ser vazio!");
        }
        
    }

    @Override
    public void inserir(CadBiblio entidade) throws NegocioException {
        validar(entidade);
        CadBiblioDAO dao = new CadBiblioDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao inserir dados!", ex);
        }
    }

    @Override
    public void alterar(CadBiblio entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        DAO dao = new CadBiblioDAO();
        try{
            dao.alterar(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Alterar o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public void excluir(CadBiblio entidade) throws NegocioException {
        consultar(entidade.getId());
        DAO dao = new CadBiblioDAO();
        try{
            dao.excluir(entidade);
        }catch(DadosException ex){
            throw new NegocioException("Erro ao Excluir o Objeto\n" + ex.getMessage(),ex);
        }
    }

    @Override
    public CadBiblio consultar(int id) throws NegocioException {
        CadBiblioDAO dao = new CadBiblioDAO();
        CadBiblio cadBiblio = new CadBiblio();
        
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
    public List<CadBiblio> listar() throws NegocioException {
        List<CadBiblio> lista = new ArrayList<>();
        CadBiblioDAO dao = new CadBiblioDAO();       
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
