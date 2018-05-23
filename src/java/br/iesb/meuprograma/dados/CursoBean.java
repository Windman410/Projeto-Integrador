package br.iesb.meuprograma.dados;
import br.iesb.meuprograma.negocio.CursoBO;
import br.iesb.meuprograma.negocio.NegocioException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
  
@ManagedBean(name = "CursoBean")    // Using ManagedBean annotation  
@SessionScoped // Using Scope annotation

public class CursoBean implements Serializable{
    private int id;
    private String tipo;
    private String modalidade;
    private String denominacao;
    private String habilitacao;
    private String localOferta;
    private boolean matutino;
    private boolean vespertino;
    private boolean noturno;
    private int vagasTurno;
    private int cargaHoraria;
    private String regimeLetivo;
    private String periodo;
    private String nomeProfessor;
    private long cpf;
    private String titulacao;
    private String tempoDedicacao;
    private List<CursoBean> carregarCurso = new ArrayList<>();
    private List<CursoBean> filtroCurso;

    public List<CursoBean> getCarregarCurso() {
        return carregarCurso;
    }

    public void setCarregarCurso(List<CursoBean> carregarCurso) {
        this.carregarCurso = carregarCurso;
    }

    public List<CursoBean> getFiltroCurso() {
        return filtroCurso;
    }

    public void setFiltroCurso(List<CursoBean> filtroCurso) {
        this.filtroCurso = filtroCurso;
    }
    
    private List<CursoBean> listaTodasCurso;

    public List<CursoBean> getListaTodasCurso() {
        CursoDAO dao = new CursoDAO();
                if(listaTodasCurso == null){
            try {
                listaTodasCurso = dao.listar();
            } catch (DadosException ex) {
                Logger.getLogger(PPCBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaTodasCurso;      
    }

    public void setListaTodasCurso(List<CursoBean> listaTodasCurso) {
        this.listaTodasCurso = listaTodasCurso;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public String getLocalOferta() {
        return localOferta;
    }

    public void setLocalOferta(String localOferta) {
        this.localOferta = localOferta;
    }

    public boolean isMatutino() {
        return matutino;
    }

    public void setMatutino(boolean matutino) {
        this.matutino = matutino;
    }

    public boolean isVespertino() {
        return vespertino;
    }

    public void setVespertino(boolean vespertino) {
        this.vespertino = vespertino;
    }

    public boolean isNoturno() {
        return noturno;
    }

    public void setNoturno(boolean noturno) {
        this.noturno = noturno;
    }

    public int getVagasTurno() {
        return vagasTurno;
    }

    public void setVagasTurno(int vagasTurno) {
        this.vagasTurno = vagasTurno;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getRegimeLetivo() {
        return regimeLetivo;
    }

    public void setRegimeLetivo(String regimeLetivo) {
        this.regimeLetivo = regimeLetivo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTempoDedicacao() {
        return tempoDedicacao;
    }

    public void setTempoDedicacao(String tempoDedicacao) {
        this.tempoDedicacao = tempoDedicacao;
    }
    
    @Override
    public String toString(){
        return denominacao;
    }
    
    public List<CursoBean> carregarCurso(){
    CursoBO bo = new CursoBO();
        try {
            List<CursoBean> lista = bo.listar();
            return lista;
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
            return null;
        }
    }
    
    
    public void cadastrarCurso() {
        CursoBO bo = new CursoBO(); 
        
        try{
            bo.inserir(this);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados inseridos com sucesso!")); 
        }catch(NegocioException ex){
            if(ex.getCause() != null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage())); 
            }
        }
    }
    
    
    public void excluirCurso(CursoBean curso) {
        CursoDAO dao = new CursoDAO();       
        try {
            dao.excluir(curso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados excluídos com sucesso!"));
        } catch (DadosException ex) {
            Logger.getLogger(CursoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private CursoBean curso;

    public CursoBean getCurso() {
        if (this.curso == null) {  
                    this.curso = new CursoBean();  
                }  
        return curso;
    }

    public void setCurso(CursoBean curso) {
        this.curso = curso;
    }
    
                public void alterarCurso(RowEditEvent event){
                CursoDAO dao = new CursoDAO();
            try {
                dao.alterar(this);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso!"));
            } catch (DadosException ex) {
                Logger.getLogger(CronogramaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    
}
