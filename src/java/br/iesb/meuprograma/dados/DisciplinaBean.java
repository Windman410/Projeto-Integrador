package br.iesb.meuprograma.dados;

import br.iesb.meuprograma.negocio.DisciplinaBO;
import br.iesb.meuprograma.negocio.NegocioException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "DisciplinaBean")
@SessionScoped
public class DisciplinaBean implements Serializable{
    private int id;
    private String nome;
    private int cod;
    private String descricao;
    private int semestre;
    private int cargaHoraria;
    
    public DisciplinaBean(){
        nome = "";
        cod = -1;
        descricao = "";
        semestre = -2;
        cargaHoraria = -2;
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
    
    public void cadastrarDisciplina() {
        System.out.println("in the Bean");
        FacesContext context = FacesContext.getCurrentInstance();
        DisciplinaBO bo = new DisciplinaBO(); 
        
        System.out.println("after BO");
        try{
            System.out.println("inside try");
            bo.inserir(this);
            System.out.println("after inserir");
            System.out.println("Sucesso, Dados inseridos com sucesso");
            context.addMessage(null, new FacesMessage("Sucesso", "Dados inseridos com sucesso!")); 
        }catch(NegocioException ex){
            if(ex.getCause() != null){
                System.out.println("Erro" + ex.getMessage());
                context.addMessage(null, new FacesMessage("Erro", ex.getMessage())); 
 ;
            }else{
                System.out.println("Erro" + ex.getMessage());
                context.addMessage(null, new FacesMessage("Erro", ex.getMessage())); 
 ;}
        }
    }                                        
    
}
