package Cliente.Modelo.Dominio;

public class ClienteUrna {
    
    private static ClienteTH clienteTH;
    
    public static void mais(String[] args){
        clienteTH = new ClienteTH(null);
        clienteTH.start();
    }
    
}
