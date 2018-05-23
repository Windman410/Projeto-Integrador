package br.iesb.meuprograma.dados;

import br.iesb.meuprograma.negocio.AtasBO;
import br.iesb.meuprograma.negocio.NegocioException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "AtasBean")
@ViewScoped
public class AtasBean implements Serializable {

    private int id;
    private int data;
    private String local;
    private String participantes;
    private String deliberacoes;

    private List<AtasBean> filtroAtas;

    public List<AtasBean> getFiltroAtas() {
        return filtroAtas;
    }

    public void setFiltroAtas(List<AtasBean> filtroAtas) {
        this.filtroAtas = filtroAtas;
    }
    private List<AtasBean> carregarAtas = new ArrayList<>();

    public List<AtasBean> getCarregarAtas() {
        return carregarAtas;
    }

    public void setCarregarAtas(List<AtasBean> carregarAtas) {
        this.carregarAtas = carregarAtas;
    }

    private List<AtasBean> listaTodasAtas;

    public List<AtasBean> getListaTodasAtas() {
        AtasDAO dao = new AtasDAO();
        if (listaTodasAtas == null) {
            try {
                listaTodasAtas = dao.listar();
            } catch (DadosException ex) {
                Logger.getLogger(PPCBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTodasAtas;
    }

    public void setListaTodasAtas(List<AtasBean> listaTodasAtas) {
        this.listaTodasAtas = listaTodasAtas;
    }

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

    public Integer toInteger() {
        return data;
    }

    public List<AtasBean> carregarAtas() {
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

        try {
            bo.inserir(this);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados inseridos com sucesso!"));
        } catch (NegocioException ex) {
            if (ex.getCause() != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
            }
        }
    }

    public void excluirAtas(AtasBean ata) {
        AtasDAO dao = new AtasDAO();
        try {
            dao.excluir(ata);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados excluídos com sucesso!"));
        } catch (DadosException ex) {
            Logger.getLogger(AtasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private AtasBean atas;

    public AtasBean getAtas() {
        if (this.atas == null) {
            this.atas = new AtasBean();
        }
        return atas;
    }

    public void setAtas(AtasBean atas) {
        this.atas = atas;
    }
    
    public void alterarAtas(RowEditEvent event){
                AtasDAO dao = new AtasDAO();
            try {
                dao.alterar(this);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso!"));
            } catch (DadosException ex) {
                Logger.getLogger(CronogramaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

}
