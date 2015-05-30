package Cliente.Modelo.Dominio;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Cliente.Visao.IUrnaVisao;
import Servidor.Modelo.Entidade.Mesario.UrnaEntidade;

public class ClienteTH  extends Thread{
	
	private IUrnaVisao visao;
	
	private Socket cliente;
	
	private ObjectOutputStream output;
	
	private ObjectInputStream input;
	
	private UrnaEntidade urna;

	private String ip;	
	
	public ClienteTH(IUrnaVisao visao){
		this.visao = visao;		
	}
	
	@Override
	public void run() {		
		try {
		visao.bloqueio(true);
		cliente = new Socket(ip, 12345);
		System.out.println("O cliente se conectou ao servidor!");			
		urna.setBloqueada(true);
		output = new ObjectOutputStream(cliente.getOutputStream());			
	        output.writeObject(urna);
	        output.flush();
	        output.reset();
			
	        input = new ObjectInputStream(cliente.getInputStream());					
	        Object aux = input.readObject();
            if (aux instanceof UrnaEntidade) {
                urna = (UrnaEntidade) aux;
                System.out.println(urna.getCandidatos().get(0).getNome());
                System.out.println(urna.getCandidatos().get(0).getCodigo()); 
            }   
            
	        while(!urna.isDesconectar()){
	        	if (urna.isBloqueada()){        		
	        	Object bloc = input.readObject();
	                if (bloc instanceof UrnaEntidade) {
                            UrnaEntidade u = (UrnaEntidade) bloc;
	                    urna.setBloqueada(u.isBloqueada());
	                    visao.bloqueio(urna.isBloqueada());
	                }	    			
	                       
	        	}
	        }
	        fecharConexao();			
		} catch (Exception e) {			
			e.printStackTrace();
		}    
		
	}

	public UrnaEntidade getUrna() {
		return urna;
	}
	
	public void fecharConexao(){
		try {
		input.close();			
	        output.close();
		cliente.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	public void votar(String voto) {
		try {			
		urna.setVoto(voto);
		output.writeObject(urna);
	        output.flush();
	        output.reset();	        
	        Object aux = input.readObject();
            if (aux instanceof UrnaEntidade) {
            	UrnaEntidade u = (UrnaEntidade) aux;  
            	urna.setBloqueada(u.isBloqueada());
            	if (u.isBloqueada()) visao.finalizaVotacao();       		
            	
            }   
	        
		} catch (Exception e) {			
			e.printStackTrace();
		}			
        	
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setUrna(UrnaEntidade urna) {
		this.urna = urna;
	}	
}