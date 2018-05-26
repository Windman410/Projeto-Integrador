    package br.iesb.meuprograma.dados;

    import br.iesb.meuprograma.negocio.NegocioException;
    import br.iesb.meuprograma.negocio.ProfessorBO;
    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;
    import javax.faces.application.FacesMessage;
    import javax.faces.bean.ManagedBean;
    import javax.faces.bean.RequestScoped;
    import javax.faces.bean.SessionScoped;
    import javax.faces.context.FacesContext;

    @ManagedBean(name = "ProfessorBean")    // Using ManagedBean annotation  
    @RequestScoped  // Using Scope annotation
    @SessionScoped
    public class ProfessorBean implements Serializable {

        private int id;
        private String nome;
        private long cpf;
        private String maiorTitulacao;
        private String areaFormacao;
        private String curriculo;
        private String dataAtualizacao;

        private int matricula;
        private String dataAdimissao;
        private int horasNDE;
        private int horasOrientacaoTCC;
        private int horasCordenacaoCurso;
        private int horasCordenacaoOutrosCurso;
        private int horasPesquisa;
        private int horasExtraClasseCurso;
        private int horasExtraClasseOutrosCurso;
        private int horasCurso;
        private int horasOutrosCurso;
        private int disciplinaCurso;
        private int cargaHorariaCurso;
        private int disciplinaOutrosCurso;
        private int cargaHorariaOutrosCurso;

        private boolean membroNDE;
        private boolean membroColegiado;
        private boolean experienciaPedagogia;

        private String tempoVinculoCurso;
        private int dataInicialVinculoCurso;

        private String experienciaMagisterioSuperior;
        private int dataInicialMagisterioSuperior;

        private String experienciaCursoDistancia;
        private int dataInicialCursoDistancia;

        private String experienciaProfissional;
        private int dataInicialExperienciaProfissional;

        private int participacaoEventos;

        private int artigoCientificoArea;
        private int artigoCientificoOutrasArea;

        private int livrosCapitulosArea;
        private int livrosCapitulosOutrasArea;

        private int trabalhoAnaisArea;
        private int trabalhoAnaisOutrasArea;

        private int propriedadeIntelectualArea;
        private int propriedadeIntelectualOutrasArea;

        private int traducoesPublicadas;
        private int projetoTecnicaArtisticaCultural;
        private int producoesDidaticoPedagogico;
        private List<ProfessorBean> carregarProfessor;

        public int getDataInicialVinculoCurso() {
            return dataInicialVinculoCurso;
        }

        public void setDataInicialVinculoCurso(int dataInicialVinculoCurso) {
            this.dataInicialVinculoCurso = dataInicialVinculoCurso;
        }

        public int getDataInicialMagisterioSuperior() {
            return dataInicialMagisterioSuperior;
        }

        public void setDataInicialMagisterioSuperior(int dataInicialMagisterioSuperior) {
            this.dataInicialMagisterioSuperior = dataInicialMagisterioSuperior;
        }

        public int getDataInicialCursoDistancia() {
            return dataInicialCursoDistancia;
        }

        public void setDataInicialCursoDistancia(int dataInicialCursoDistancia) {
            this.dataInicialCursoDistancia = dataInicialCursoDistancia;
        }

        public int getDataInicialExperienciaProfissional() {
            return dataInicialExperienciaProfissional;
        }

        public void setDataInicialExperienciaProfissional(int dataInicialExperienciaProfissional) {
            this.dataInicialExperienciaProfissional = dataInicialExperienciaProfissional;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public long getCpf() {
            return cpf;
        }

        public void setCpf(long cpf) {
            this.cpf = cpf;
        }

        public String getMaiorTitulacao() {
            return maiorTitulacao;
        }

        public void setMaiorTitulacao(String maiorTitulacao) {
            this.maiorTitulacao = maiorTitulacao;
        }

        public String getAreaFormacao() {
            return areaFormacao;
        }

        public void setAreaFormacao(String areaFormacao) {
            this.areaFormacao = areaFormacao;
        }

        public String getCurriculo() {
            return curriculo;
        }

        public void setCurriculo(String curriculo) {
            this.curriculo = curriculo;
        }

        public String getDataAtualizacao() {
            return dataAtualizacao;
        }

        public void setDataAtualizacao(String dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
        }

        public int getMatricula() {
            return matricula;
        }

        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }

        public String getDataAdimissao() {
            return dataAdimissao;
        }

        public void setDataAdimissao(String dataAdimissao) {
            this.dataAdimissao = dataAdimissao;
        }

        public int getHorasNDE() {
            return horasNDE;
        }

        public void setHorasNDE(int horasNDE) {
            this.horasNDE = horasNDE;
        }

        public int getHorasOrientacaoTCC() {
            return horasOrientacaoTCC;
        }

        public void setHorasOrientacaoTCC(int horasOrientacaoTCC) {
            this.horasOrientacaoTCC = horasOrientacaoTCC;
        }

        public int getHorasCordenacaoCurso() {
            return horasCordenacaoCurso;
        }

        public void setHorasCordenacaoCurso(int horasCordenacaoCurso) {
            this.horasCordenacaoCurso = horasCordenacaoCurso;
        }

        public int getHorasCordenacaoOutrosCurso() {
            return horasCordenacaoOutrosCurso;
        }

        public void setHorasCordenacaoOutrosCurso(int horasCordenacaoOutrosCurso) {
            this.horasCordenacaoOutrosCurso = horasCordenacaoOutrosCurso;
        }

        public int getHorasPesquisa() {
            return horasPesquisa;
        }

        public void setHorasPesquisa(int horasPesquisa) {
            this.horasPesquisa = horasPesquisa;
        }

        public int getHorasExtraClasseCurso() {
            return horasExtraClasseCurso;
        }

        public void setHorasExtraClasseCurso(int horasExtraClasseCurso) {
            this.horasExtraClasseCurso = horasExtraClasseCurso;
        }

        public int getHorasExtraClasseOutrosCurso() {
            return horasExtraClasseOutrosCurso;
        }

        public void setHorasExtraClasseOutrosCurso(int horasExtraClasseOutrosCurso) {
            this.horasExtraClasseOutrosCurso = horasExtraClasseOutrosCurso;
        }

        public int getHorasCurso() {
            return horasCurso;
        }

        public void setHorasCurso(int horasCurso) {
            this.horasCurso = horasCurso;
        }

        public int getHorasOutrosCurso() {
            return horasOutrosCurso;
        }

        public void setHorasOutrosCurso(int horasOutrosCurso) {
            this.horasOutrosCurso = horasOutrosCurso;
        }

        public int getDisciplinaCurso() {
            return disciplinaCurso;
        }

        public void setDisciplinaCurso(int disciplinaCurso) {
            this.disciplinaCurso = disciplinaCurso;
        }

        public int getCargaHorariaCurso() {
            return cargaHorariaCurso;
        }

        public void setCargaHorariaCurso(int cargaHorariaCurso) {
            this.cargaHorariaCurso = cargaHorariaCurso;
        }

        public int getDisciplinaOutrosCurso() {
            return disciplinaOutrosCurso;
        }

        public void setDisciplinaOutrosCurso(int disciplinaOutrosCurso) {
            this.disciplinaOutrosCurso = disciplinaOutrosCurso;
        }

        public int getCargaHorariaOutrosCurso() {
            return cargaHorariaOutrosCurso;
        }

        public void setCargaHorariaOutrosCurso(int cargaHorariaOutrosCurso) {
            this.cargaHorariaOutrosCurso = cargaHorariaOutrosCurso;
        }

        public boolean isMembroNDE() {
            return membroNDE;
        }

        public void setMembroNDE(boolean membroNDE) {
            this.membroNDE = membroNDE;
        }

        public boolean isMembroColegiado() {
            return membroColegiado;
        }

        public void setMembroColegiado(boolean membroColegiado) {
            this.membroColegiado = membroColegiado;
        }

        public boolean isExperienciaPedagogia() {
            return experienciaPedagogia;
        }

        public void setExperienciaPedagogia(boolean experienciaPedagogia) {
            this.experienciaPedagogia = experienciaPedagogia;
        }

        public String getTempoVinculoCurso() {
            return tempoVinculoCurso;
        }

        public void setTempoVinculoCurso(String tempoVinculoCurso) {
            this.tempoVinculoCurso = tempoVinculoCurso;
        }

        public String getExperienciaMagisterioSuperior() {
            return experienciaMagisterioSuperior;
        }

        public void setExperienciaMagisterioSuperior(String experienciaMagisterioSuperior) {
            this.experienciaMagisterioSuperior = experienciaMagisterioSuperior;
        }

        public String getExperienciaCursoDistancia() {
            return experienciaCursoDistancia;
        }

        public void setExperienciaCursoDistancia(String experienciaCursoDistancia) {
            this.experienciaCursoDistancia = experienciaCursoDistancia;
        }

        public String getExperienciaProfissional() {
            return experienciaProfissional;
        }

        public void setExperienciaProfissional(String experienciaProfissional) {
            this.experienciaProfissional = experienciaProfissional;
        }

        public int getParticipacaoEventos() {
            return participacaoEventos;
        }

        public void setParticipacaoEventos(int participacaoEventos) {
            this.participacaoEventos = participacaoEventos;
        }

        public int getArtigoCientificoArea() {
            return artigoCientificoArea;
        }

        public void setArtigoCientificoArea(int artigoCientificoArea) {
            this.artigoCientificoArea = artigoCientificoArea;
        }

        public int getArtigoCientificoOutrasArea() {
            return artigoCientificoOutrasArea;
        }

        public void setArtigoCientificoOutrasArea(int artigoCientificoOutrasArea) {
            this.artigoCientificoOutrasArea = artigoCientificoOutrasArea;
        }

        public int getLivrosCapitulosArea() {
            return livrosCapitulosArea;
        }

        public void setLivrosCapitulosArea(int livrosCapitulosArea) {
            this.livrosCapitulosArea = livrosCapitulosArea;
        }

        public int getLivrosCapitulosOutrasArea() {
            return livrosCapitulosOutrasArea;
        }

        public void setLivrosCapitulosOutrasArea(int livrosCapitulosOutrasArea) {
            this.livrosCapitulosOutrasArea = livrosCapitulosOutrasArea;
        }

        public int getTrabalhoAnaisArea() {
            return trabalhoAnaisArea;
        }

        public void setTrabalhoAnaisArea(int trabalhoAnaisArea) {
            this.trabalhoAnaisArea = trabalhoAnaisArea;
        }

        public int getTrabalhoAnaisOutrasArea() {
            return trabalhoAnaisOutrasArea;
        }

        public void setTrabalhoAnaisOutrasArea(int trabalhoAnaisOutrasArea) {
            this.trabalhoAnaisOutrasArea = trabalhoAnaisOutrasArea;
        }

        public int getPropriedadeIntelectualArea() {
            return propriedadeIntelectualArea;
        }

        public void setPropriedadeIntelectualArea(int propriedadeIntelectualArea) {
            this.propriedadeIntelectualArea = propriedadeIntelectualArea;
        }

        public int getPropriedadeIntelectualOutrasArea() {
            return propriedadeIntelectualOutrasArea;
        }

        public void setPropriedadeIntelectualOutrasArea(int propriedadeIntelectualOutrasArea) {
            this.propriedadeIntelectualOutrasArea = propriedadeIntelectualOutrasArea;
        }

        public int getTraducoesPublicadas() {
            return traducoesPublicadas;
        }

        public void setTraducoesPublicadas(int traducoesPublicadas) {
            this.traducoesPublicadas = traducoesPublicadas;
        }

        public int getProjetoTecnicaArtisticaCultural() {
            return projetoTecnicaArtisticaCultural;
        }

        public void setProjetoTecnicaArtisticaCultural(int projetoTecnicaArtisticaCultural) {
            this.projetoTecnicaArtisticaCultural = projetoTecnicaArtisticaCultural;
        }

        public int getProducoesDidaticoPedagogico() {
            return producoesDidaticoPedagogico;
        }

        public void setProducoesDidaticoPedagogico(int producoesDidaticoPedagogico) {
            this.producoesDidaticoPedagogico = producoesDidaticoPedagogico;
        }

        @Override
        public String toString() {
            return nome;
        }

        public List<ProfessorBean> carregarProfessor() {
            ProfessorBO bo = new ProfessorBO();
            try {
                List<ProfessorBean> lista = bo.listar();
                return lista;
            } catch (NegocioException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
                return null;
            }
        }

        public void cadastrarProfessor() {
            ProfessorBO bo = new ProfessorBO();
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
    }
