    package br.iesb.meuprograma.dados;

    import br.iesb.meuprograma.negocio.CronogramaBO;
    import br.iesb.meuprograma.negocio.NegocioException;
    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.faces.application.FacesMessage;
    import javax.faces.bean.ManagedBean;
    import javax.faces.bean.SessionScoped;
    import javax.faces.context.FacesContext;
    import javax.faces.view.ViewScoped;
    import org.primefaces.event.RowEditEvent;
    import org.primefaces.event.SelectEvent;

    @ManagedBean(name = "CronogramaBean")
    @ViewScoped
    @SessionScoped
    public class CronogramaBean implements Serializable {

        private int id;
        private int aula;
        private String conteudo;
        private List<CronogramaBean> carregarCronograma;
        private List<CronogramaBean> filtroCronograma;

        public List<CronogramaBean> getFiltroCronograma() {
            return filtroCronograma;
        }

        public void setFiltroCronograma(List<CronogramaBean> filtroCronograma) {
            this.filtroCronograma = filtroCronograma;
        }

        private List<CronogramaBean> listaTodasCronograma;

        public List<CronogramaBean> getListaTodasCronograma() {
            CronogramaDAO dao = new CronogramaDAO();
            if (listaTodasCronograma == null) {
                try {
                    listaTodasCronograma = dao.listar();
                } catch (DadosException ex) {
                    Logger.getLogger(PPCBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return listaTodasCronograma;
        }

        public void setListaTodasCronograma(List<CronogramaBean> listaTodasCronograma) {
            this.listaTodasCronograma = listaTodasCronograma;
        }

        public List<CronogramaBean> getCarregarCronograma() {
            return carregarCronograma;
        }

        public void setCarregarCronograma(List<CronogramaBean> carregarCronograma) {
            this.carregarCronograma = carregarCronograma;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAula() {
            return aula;
        }

        public void setAula(int aula) {
            this.aula = aula;
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        @Override
        public String toString() {
            return "Aula: " + aula + "  Conteudo: " + conteudo;
        }

        public List<CronogramaBean> carregarCronograma() {
            CronogramaBO bo = new CronogramaBO();
            try {
                List<CronogramaBean> lista = bo.listar();
                return lista;
            } catch (NegocioException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
                return null;
            }
        }

        public void cancelarCronograma() {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancelado com sucesso"));
        }

        public void cadastrarCronograma() {
            CronogramaBO bo = new CronogramaBO();

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

        public void onRowSelect(SelectEvent event) {
            CronogramaBean cronograma = ((CronogramaBean) event.getObject());
            int i = 1 + 1;
        }

        public void excluirCronograma(CronogramaBean cronograma) {
            CronogramaBO bo = new CronogramaBO();
            try {
                bo.excluir(cronograma);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados excluídos com sucesso!"));
            } catch (NegocioException ex) {
                if (ex.getCause() != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                }
            }
        }
        private CronogramaBean cronograma;

        public CronogramaBean getCronograma() {
            if (this.cronograma == null) {
                this.cronograma = new CronogramaBean();
            }
            return cronograma;
        }

        public void setCronograma(CronogramaBean cronograma) {
            this.cronograma = cronograma;
        }

        public void alterarCronograma(RowEditEvent event) {
            CronogramaBO bo = new CronogramaBO();
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
