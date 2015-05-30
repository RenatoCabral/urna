package Servidor.Modelo.Dominio;

import Servidor.Modelo.Entidade.Mesario.UrnaEntidade;
import Servidor.Modelo.Entidade.Mesario.UrnasEntidade;
import Servidor.Visao.IServidorVisao;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTH extends Thread{// extendo a uma thread, para usar varios processos
    
    private UrnasEntidade urnas;// declaração da classe UrnasEntidade
    private UrnaEntidade urna; //declaração da classe UrnaEntidade
    private ServerSocket servidor; // declaração da classe ServerSocket
    private int port = 12345; // passando um número de porta, 
    private IServidorVisao servidorVisao; // declaração da classe IServidorVisao
    private CandidatoDominio candidatoDominio;// declaração da classe  CandidatoDominio
    private boolean finalizar = false; // declaração do metodo finalizar
    public ServidorTH(IServidorVisao visao){
        try {
            urnas = new UrnasEntidade(); // declaração de uma instancia do tipo UrnasEntidade
            candidatoDominio = new CandidatoDominio();//declaração de uma instancia do tipo CandidatoDominio
            carregarCandidatos();// chamada do metodo  de carregarCandidatos
            servidor = new ServerSocket(port);//declaração de uma instancia do tipo ServerSocket
            servidorVisao = visao;// instancia de um objeto do tipo IServidorVisao
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //METODO DE CARREGAR CANDIDATOS
    public void carregarCandidatos(){
        candidatoDominio.carregar(urnas.getCandidatos());
    }/* OBJETO CANDIDATO DOMINIO RECEBE O METODO CARREGAR, E PASSANDO COMO PARAMETRO UMA URNA QUE RECEBE CANDIDATOS*/
    
    
    /* Existe uma interface chamada Runnable que possui um método run. Dentro do método run devem ficar os 
    procedimentos que você deseja executar paralelamente*/    
    @Override
    public void run(){
        while(! finalizar){
            
            //aceita um cliente
            Socket cliente;
            try {
                System.out.println("Aguardando conexão na porta" + port);
                cliente = servidor.accept();//SERVIDOR ESTA ACEITANDO A CONEXÃO DE UM CLIENTE
                System.out.println("Nova conexão com o cliente" + cliente.getInetAddress().getHostAddress());//TRAZ OS DADOS DO CLIENTE CONECTADO NO SERVIDOR
                new TratarClienteTH(cliente, urnas, urna, servidorVisao).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
    public UrnasEntidade getUrnas(){
        return urnas;
    }
    
    public void setFinalizar(boolean finalizar){
        this.finalizar = finalizar;
    }

    
}

