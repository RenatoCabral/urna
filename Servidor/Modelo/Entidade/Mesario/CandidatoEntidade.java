package Servidor.Modelo.Entidade.Mesario;

import java.io.Serializable;


public class CandidatoEntidade implements Serializable{
    
    private static final long serialVerionUID = 1L;
    private int id;
    private String nome;
    private String codigo;
    private String partido;
    private int votos;

    //construtor
    public CandidatoEntidade() {
    }

    //CONSTRUTOR
    public CandidatoEntidade(int id, String nome, String codigo, String partido) {
        this();
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.partido = partido;
        //this.votos = votos;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return nome + "  " + codigo + "  " + partido + "  " + votos;
    }
      
}
