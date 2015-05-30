package Servidor.Modelo.Entidade.Mesario;

import java.io.Serializable;

public class EleitorEntidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private boolean votou;

    public EleitorEntidade() {
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

    public boolean isVotou() {
        return votou;
    }

    public void setVotou(boolean votou) {
        this.votou = votou;
    }
    
    
    
}
