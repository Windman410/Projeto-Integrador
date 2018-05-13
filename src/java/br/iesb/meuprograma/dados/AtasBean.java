package br.iesb.meuprograma.dados;
import br.iesb.meuprograma.negocio.AtasBO;
import br.iesb.meuprograma.negocio.DisciplinaBO;
import br.iesb.meuprograma.negocio.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

@ManagedBean(name = "AtasBean")
@SessionScoped
public class AtasBean implements Serializable{
    private int id;
    private int data;
    private String local;
    private String participantes;
    private String deliberacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    } 
    
    public String getDeliberacoes() {
        return deliberacoes;
    }

    public void setDeliberacoes(String deliberacoes) {
        this.deliberacoes = deliberacoes;
    }
    
    public Integer toInteger(){ 
        return data;}
    
    public List<AtasBean> carregarAtas(){
    AtasBO bo = new AtasBO();
        try {
            List<AtasBean> lista = bo.listar();
            return lista;
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
            return null;
        }
    }
    
    public void cadastrarAtas() {
        AtasBO bo = new AtasBO(); 
        
        try{
            bo.inserir(this);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Dados inseridos com sucesso!")); 
        }catch(NegocioException ex){
            if(ex.getCause() != null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage())); 
            }
        }
    }
}
