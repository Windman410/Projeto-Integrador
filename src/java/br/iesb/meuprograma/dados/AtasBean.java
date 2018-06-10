    package br.iesb.meuprograma.dados;
    import br.iesb.meuprograma.negocio.AtasBO;
    import br.iesb.meuprograma.negocio.NegocioException;
    import java.io.Serializable;
    import java.util.Date;
    import java.util.List;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.faces.application.FacesMessage;
    import javax.faces.bean.ManagedBean;
    import javax.faces.bean.SessionScoped;
    import javax.faces.view.ViewScoped;
    import javax.faces.context.FacesContext;
    import org.primefaces.event.RowEditEvent;

    @ManagedBean(name = "AtasBean")
    @SessionScoped
    @ViewScoped
    public class AtasBean implements Serializable {

        private int id;
        private Date data;
        private String local;
        private String participantes;
        private String deliberacoes;
        private List<AtasBean> filtroAtas;
        private AtasBean atas;
        private List<AtasBean> carregarAtas;
        private List<AtasBean> listaTodasAtas;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
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
            public List<AtasBean> getFiltroAtas() {
            return filtroAtas;
        }

        public void setFiltroAtas(List<AtasBean> filtroAtas) {
            this.filtroAtas = filtroAtas;
        }
        public List<AtasBean> getCarregarAtas() {
            return carregarAtas;
        }

        public void setCarregarAtas(List<AtasBean> carregarAtas) {
            this.carregarAtas = carregarAtas;
        }
        public AtasBean getAtas() {
                this.atas = new AtasBean();
            
            return atas;
        }

        public void setAtas(AtasBean atas) {
            this.atas = atas;
        }

        public List<AtasBean> getListaTodasAtas() {
            AtasBO bo = new AtasBO();
                try {
                    listaTodasAtas = bo.listar();
                } catch (NegocioException ex) {
                    Logger.getLogger(AtasBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            return listaTodasAtas;
        }

        public void setListaTodasAtas(List<AtasBean> listaTodasAtas) {
            this.listaTodasAtas = listaTodasAtas;
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
            AtasBO bo = new AtasBO();
            try {
                bo.excluir(ata);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados excluídos com sucesso!"));

            } catch (NegocioException ex) {
                if (ex.getCause() != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                }
            }
        }    

        public void alterarAtas(RowEditEvent event) {
            AtasBO bo = new AtasBO();
            try {
                bo.alterar(this);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso!"));
            } catch (NegocioException ex) {
                if (ex.getCause() != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                }
            }

        }
    }
