/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iesb.meuprograma.dados;

/**
 *
 * @author mamãe
 */
public class PPC {
    
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
    public String toString(){ return cursoPPC;}
    
}
