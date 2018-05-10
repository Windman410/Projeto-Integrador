package br.iesb.meuprograma.dados;

public class AvaliacaoMec {
    private int id;
    private int tipoCurso;
    private String modalidade;
    private String denominaçãoCurso;
    private int localOferta;
    private int notaFinal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(int tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getDenominaçãoCurso() {
        return denominaçãoCurso;
    }

    public void setDenominaçãoCurso(String denominaçãoCurso) {
        this.denominaçãoCurso = denominaçãoCurso;
    }

    public int getLocalOferta() {
        return localOferta;
    }

    public void setLocalOferta(int localOferta) {
        this.localOferta = localOferta;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getDimensaoIndicadores() {
        return DimensaoIndicadores;
    }

    public void setDimensaoIndicadores(String DimensaoIndicadores) {
        this.DimensaoIndicadores = DimensaoIndicadores;
    }

    public int getDimensaoConceito() {
        return dimensaoConceito;
    }

    public void setDimensaoConceito(int dimensaoConceito) {
        this.dimensaoConceito = dimensaoConceito;
    }

    public String getDimensaoComentario() {
        return dimensaoComentario;
    }

    public void setDimensaoComentario(String dimensaoComentario) {
        this.dimensaoComentario = dimensaoComentario;
    }

    public int getDimensaoNota() {
        return dimensaoNota;
    }

    public void setDimensaoNota(int dimensaoNota) {
        this.dimensaoNota = dimensaoNota;
    }
    
    // atributos dimensão provavelmente entrarão em uma classe separada.
    private String DimensaoIndicadores ;
    private int dimensaoConceito;
    private String dimensaoComentario;
    private int dimensaoNota;
}