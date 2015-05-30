package Servidor.Modelo.Entidade.Mesario;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*CLASSE RECEBE TRES LITAS CANDIDATOENTIDADE, URNAENTIDADE E UMA LISTA DE SOCKET DE CLIENTES, MAIS OS TIPO DE VOTOS
BRANCOS, NULOS E O TOTAL*/
public class UrnasEntidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private List<CandidatoEntidade> candidatos;
    private List<UrnaEntidade> urnas;
    private List<Socket> clientes;
    private int votosBrancos = 0; // INICIALIZANDO EM ZERO
    private int votosNulos = 0; // INICIALIZANDO EM ZERO
    private int votosTotalGeral = 0; // INICIALIZANDO EM ZERO
    
    public UrnasEntidade(){//CONSTRUTOR ONDE OS OBJETOS RECEBEM ARRAYLIST
        urnas = new ArrayList<UrnaEntidade>(); // OBJETO URNA QUE RECEBE ARRAYLIST DE URNAENTIDADE
        candidatos = new ArrayList<CandidatoEntidade>(); // OBJETO CANDIDATOS QUE RECEBE ARRAYLIST DE CANDIDATOENTIDADE
        clientes = new ArrayList<Socket>(); // OBJETO CLIENTES QUE RECEBE ARRAYLIST DE SOCKET
    }
    
    /* GET E SET*/

    public List<CandidatoEntidade> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoEntidade> candidatos) {
        this.candidatos = candidatos;
    }

    public List<UrnaEntidade> getUrnas() {
        return urnas;
    }

    public void setUrnas(List<UrnaEntidade> urnas) {
        this.urnas = urnas;
    }

    public List<Socket> getClientes() {
        return clientes;
    }

    public void setClientes(List<Socket> clientes) {
        this.clientes = clientes;
    }

    public int getVotosBrancos() {
        return votosBrancos;
    }

    public void setVotosBrancos(int votosBrancos) {
        this.votosBrancos = votosBrancos;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public int getVotosTotalGeral() {
        return votosTotalGeral;
    }

    public void setVotosTotalGeral(int votosTotalGeral) {
        this.votosTotalGeral = votosTotalGeral;
    }
    
    
    
}
