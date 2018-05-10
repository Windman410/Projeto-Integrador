package br.iesb.meuprograma.dados;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
  
@ManagedBean    // Using ManagedBean annotation  
@RequestScoped  // Using Scope annotation  
public class Curso {
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
}
