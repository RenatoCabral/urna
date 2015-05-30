package Servidor.Conexao;


//CLASSE DE CONFIGURAÇÃO DA CONEXÃO, DEFININDO OS ATRIBUTOS PARA A CONEXÃO
public class ConfiguracaoConexaoDBEntidade {
    
    private String host;
    private int porta;
    private String dataBase;
    private String usuario;
    private String senha; 

    //CONSTRUTOR
    public ConfiguracaoConexaoDBEntidade() {
    }

    //GET E SET
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getUrlConexao(){ // METODO DE CONEXAO QUE RETORNA O DRIVER DE CONEXAO DO BANCO
        return "jdbc:mysql://"+this.host+"/"+this.dataBase;
    }
    
    
}
