package br.iesb.meuprograma.dados;
public class Cronograma {
    private int id;
    private int aula;
    private String conteudo;

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
    public String toString(){
        return "Aula: " + aula + "  Conteudo: " + conteudo;
    }
    
}
