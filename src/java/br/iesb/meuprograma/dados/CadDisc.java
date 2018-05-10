package br.iesb.meuprograma.dados;

public class CadDisc {
    private int id;
    private String nome;
    private int cod;
    private String descricao;
    private int semestre;
    private int cargaHoraria;

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
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    @Override
    public String toString(){ 
        return nome;}
    
}
