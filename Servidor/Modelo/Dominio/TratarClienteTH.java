package Servidor.Modelo.Dominio;

import Servidor.Modelo.Entidade.Mesario.CandidatoEntidade;
import Servidor.Modelo.Entidade.Mesario.UrnaEntidade;
import Servidor.Modelo.Entidade.Mesario.UrnasEntidade;
import Servidor.Visao.IServidorVisao;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TratarClienteTH extends Thread{
    
    //DECLARAÇÃO DE VARIAS CLASSES DENTRO DE OUTRA CLASSE
    private Socket cliente;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private UrnasEntidade urnas;
    private UrnaEntidade urna;
    private IServidorVisao servidorVisao;
    private boolean votando;
    
    //construtor
    public TratarClienteTH(Socket cliente, UrnasEntidade urnas, UrnaEntidade urna, IServidorVisao servidorVisao){
        this.cliente =cliente;
        this.urnas = urnas;
        this.urna = urna;
        this.servidorVisao = servidorVisao;
        this.votando = false;     
    }
    
    //METODO DE PREENCHER URNA, RECEBENDO COMO PARAMETRO UMA URNA
    private void preencherUrna(UrnaEntidade urna){
        urna.getCandidatos().clear();// limpar a urna
        for(CandidatoEntidade c : urnas.getCandidatos()){//FOR QUE VAI PREENCHER A URNA COM OS CANDIDATOS
            urna.getCandidatos().add(new CandidatoEntidade(c.getId(), c.getNome(), c.getCodigo(), c.getPartido()));
        }
    }
    
    /* método run. Dentro do método run devem ficar os procedimentos que você deseja executar paralelamente*/
    @Override
    public void run(){
        try {
            input = new ObjectInputStream(cliente.getInputStream());
            output = new ObjectOutputStream(cliente.getOutputStream());
            Object aux = input.readObject();//LER OBJETO DO ObjectInputStream
            if(aux instanceof UrnaEntidade){
                urna = (UrnaEntidade) aux;//INSTANCIANDO OBJETO AUX DO TIPO URNAENTIDADE
                urna.setNome(cliente.getInetAddress().getHostAddress());//ESTA SENDO SETADO PARA O OBJET URNA O HOST E IP
                urna.getCandidatos().add(new CandidatoEntidade());// OBJETO URNA RECEBENDO NOVOS CANDIDATOS
                preencherUrna(urna);//CHAMADA DO METODO DE PREENCHERURNA
            }
            urna.setNome(cliente.getInetAddress().getHostAddress());
            urnas.getUrnas().add(urna);//OBJETO URNAS ESTA ADICIONANDO OUTRAS URNA
            urnas.getClientes().add(cliente);//OBJETO URNAS ADICIONANDO OUTROS CLIENTES
            urna.setBloqueada(true);
            if(servidorVisao != null)
                servidorVisao.atualizaTela();//ATUALIZA A TELA DO SERVIDOR DEPOIS DO CLIENTE SE CONECTAR
            output.writeObject(urna);//O método writeObject é usado para gravar um objeto, ESCREVER
            output.flush();
            output.reset();
            
            while(! urna.isDesconectar()){//DESCONETAR URNA DO SERVIDOR
                if(!urna.isBloqueada()){
                
                     if(!votando){
                         urna.setBloqueada(false);
                         output.writeObject(urna);
                         output.flush();
                         output.reset();
                     }else{
                         if(servidorVisao != null)
                             servidorVisao.atualizaTela();//METODO PARA ATUALIZAR O SERVIDOR DEPOIS DE VOTAR OU NÃO
                        Object voto = input.readObject();//LER OBJETO DO TIPO VOTO
                        if(voto instanceof UrnaEntidade){
                            UrnaEntidade u = (UrnaEntidade) voto;
                            confirmarVoto(u.getVoto());
                            urna.setNome(cliente.getInetAddress().getHostAddress());
                            votando = false;
                        }
                        urna.setBloqueada(true);//PASSANDO QUE A URNA ESTA BLOQUEADA DEPOIS DE UM CLIENTE VOTAR
                        output.writeObject(urna);//METODO DE ESCREVER
                        output.flush();
                        output.reset();
                        if(servidorVisao != null)
                            servidorVisao.atualizaTela();
                     }
                }
                
            }
            fecharConexao();
        } catch (Exception e1) {
            fecharConexao();
            e1.printStackTrace();
        } 
    }
    
    //METODO ONDE SERÁ FECHADA TODAS AS CONEXÕES QUE FOREM ABERTAS
     public void fecharConexao(){
         try {
             urnas.getUrnas().remove(urna);
             servidorVisao.atualizaTela();
             input.close();
             cliente.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         try {
             this.finalize();
         } catch (Throwable e) {
             e.printStackTrace();
         }
    }   
     
     
     //METODO PARA CONFIRMAR O VOTO QUE RECEBE COMO PARAMETRO UMA STRING DO TIPO VOTO
     private void confirmarVoto(String voto){
         boolean valido = false;
         for(CandidatoEntidade c : urnas.getCandidatos()){
             if(c.getCodigo().equalsIgnoreCase(voto)){
                 c.setVotos(c.getVotos()+1); //SERA ADICIONADO MAIS UM VOTO PARA O OBEJTO QUE FOR VOTADO
                 valido = true;
             }
         }
         if(! valido){
             if(voto.isEmpty())
                    urnas.setVotosBrancos(urnas.getVotosBrancos()+1);//METODO DE SOMA DOS VOTOS BRANCOS
            else
                    urnas.setVotosNulos(urnas.getVotosNulos()+1);//METODO DE SOMA DOS VOTOS BRANCOS
		}
		
		urnas.setVotosTotalGeral(urnas.getVotosTotalGeral()+1);//TOTALIZADOR GERAL
	}
}
         

     

