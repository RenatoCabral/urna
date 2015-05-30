package Servidor.Modelo.Entidade.Mesario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// CLASSE QUE RECEBE AS FUNÇÕES DA URNA, CONECTAR, BLOQUEAR, VOTOS E DUAS LISTAS CANDIDATOENTIDADE E ELEITORENTIDADE
public class UrnaEntidade implements Serializable{ 
    
    private static final long serialVersionUID = 1L;
    private boolean desconectar;
    private String nome;
    private boolean bloqueada;
    private List<CandidatoEntidade> candidatos;
    private List<EleitorEntidade> eleitores;
    private String voto;
    
    public UrnaEntidade(){ 
        candidatos = new ArrayList<CandidatoEntidade>();// OBJETO CANDIDATOS RECEBE UM ARRAYLIST DE CandidatoEntidade
        eleitores = new ArrayList<EleitorEntidade>(); // OBJETO ELEITORES RECEBE UM ARRAYLIST DE EleitorEntidade
        desconectar = false; // DESCONECTAR RECEBE FALSE
        bloqueada = true; // BLOQUEADA RECEBE TRUE OU VERDADEIRO
    }
    
    public UrnaEntidade (String nome){ // CONSTRUTOR APENAS DO ATRIBUTO NOME;
        this();
        this.nome = nome;
    }
    
    //GET E SET 
    public boolean isDesconectar() {
        return desconectar;
    }

    public void setDesconectar(boolean desconectar) {
        this.desconectar = desconectar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public List<CandidatoEntidade> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoEntidade> candidatos) {
        this.candidatos = candidatos;
    }

    public List<EleitorEntidade> getEleitores() {
        return eleitores;
    }

    public void setEleitores(List<EleitorEntidade> eleitores) {
        this.eleitores = eleitores;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
    
    
    
}
