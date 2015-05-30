package Servidor.Modelo.Dominio;

public class GerenciaConexoes {
    
    private static ServidorTH servidor;
    
    public static void main(String [] args){
        servidor = new ServidorTH(null);
        servidor.run();
    }
    
}
