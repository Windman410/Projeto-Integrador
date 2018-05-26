    package br.iesb.meuprograma.dados;

    import br.iesb.meuprograma.negocio.NegocioException;
    import br.iesb.meuprograma.negocio.PPCBO;
    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.faces.application.FacesMessage;
    import javax.faces.bean.ManagedBean;
    import javax.faces.bean.SessionScoped;
    import javax.faces.context.FacesContext;
    import org.primefaces.event.RowEditEvent;

    @ManagedBean(name = "PPCBean")    // Using ManagedBean annotation  
    @SessionScoped

    public class PPCBean implements Serializable {

        private int ID;
        private String cursoPPC;
        private String perfilCurso;
        private String perfilEgresso;
        private String formaAcesso;
        private String representacao;
        private String avaliacaoProcesso;
        private String avaliacaoProjeto;
        private int horasTCC;
        private int horasEstagio;
        private String politicaDeAtendimento;
        private List<PPCBean> carregarPPC;
        private List<PPCBean> filtroPPC;

        public List<PPCBean> getFiltroPPC() {
            return filtroPPC;
        }

        public void setFiltroPPC(List<PPCBean> filtroPPC) {
            this.filtroPPC = filtroPPC;
        }
        private List<PPCBean> listaTodasPPC;

        public List<PPCBean> getListaTodasPPC() {
            PPCBO bo = new PPCBO();
            if (listaTodasPPC == null) {
                try {
                    listaTodasPPC = bo.listar();
                } catch (NegocioException ex) {
                    Logger.getLogger(PPCBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return listaTodasPPC;
        }

        public void setListaTodasPPC(List<PPCBean> listaTodasPPC) {
            this.listaTodasPPC = listaTodasPPC;
        }

        public List<PPCBean> getCarregarPPC() {
            return carregarPPC;
        }

        public void setCarregarPPC(List<PPCBean> carregarPPC) {
            this.carregarPPC = carregarPPC;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCursoPPC() {
            return cursoPPC;
        }

        public void setCursoPPC(String cursoPPC) {
            this.cursoPPC = cursoPPC;
        }

        public String getPerfilCurso() {
            return perfilCurso;
        }

        public void setPerfilCurso(String perfilCurso) {
            this.perfilCurso = perfilCurso;
        }

        public String getPerfilEgresso() {
            return perfilEgresso;
        }

        public void setPerfilEgresso(String perfilEgresso) {
            this.perfilEgresso = perfilEgresso;
        }

        public String getFormaAcesso() {
            return formaAcesso;
        }

        public void setFormaAcesso(String formaAcesso) {
            this.formaAcesso = formaAcesso;
        }

        public String getRepresentacao() {
            return representacao;
        }

        public void setRepresentacao(String representacao) {
            this.representacao = representacao;
        }

        public String getAvaliacaoProcesso() {
            return avaliacaoProcesso;
        }

        public void setAvaliacaoProcesso(String avaliacaoProcesso) {
            this.avaliacaoProcesso = avaliacaoProcesso;
        }

        public String getAvaliacaoProjeto() {
            return avaliacaoProjeto;
        }

        public void setAvaliacaoProjeto(String avaliacaoProjeto) {
            this.avaliacaoProjeto = avaliacaoProjeto;
        }

        public int getHorasTCC() {
            return horasTCC;
        }

        public void setHorasTCC(int horasTCC) {
            this.horasTCC = horasTCC;
        }

        public int getHorasEstagio() {
            return horasEstagio;
        }

        public void setHorasEstagio(int horasEstagio) {
            this.horasEstagio = horasEstagio;
        }

        public String getPoliticaDeAtendimento() {
            return politicaDeAtendimento;
        }

        public void setPoliticaDeAtendimento(String politicaDeAtendimento) {
            this.politicaDeAtendimento = politicaDeAtendimento;
        }

        @Override
        public String toString() {
            return cursoPPC;
        }

        public List<PPCBean> carregarPPC() {
            PPCBO bo = new PPCBO();
            try {
                List<PPCBean> lista = bo.listar();
                return lista;
            } catch (NegocioException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
                return null;
            }
        }

        public void cadastrarPPC() {
            PPCBO bo = new PPCBO();
            try {
                bo.inserir(this);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados inseridos com sucesso!"));
            } catch (NegocioException ex) {
                if (ex.getCause() != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", ex.getMessage()));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                }
            }
        }

        public void excluirPPC(PPCBean ppc) {
            PPCBO bo = new PPCBO();
            try {
                bo.excluir(ppc);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados excluídos com sucesso!"));
            } catch (NegocioException ex) {
                if (ex.getCause() != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                }
            }

        }
        private PPCBean ppc;

        public PPCBean getPpc() {
            if (this.ppc == null) {
                this.ppc = new PPCBean();
            }
            return ppc;
        }

        public void setPpc(PPCBean ppc) {
            this.ppc = ppc;
        }

        public void alterarPPC(RowEditEvent event) {
            PPCBO bo = new PPCBO();
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


