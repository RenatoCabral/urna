package Servidor.Conexao;

import Servidor.Modelo.Dominio.ConfiguracaoConexaoBDDominio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CLASSE DE CONFIGURACÃO DA CONEXÃO COM O BANCO DE DADOS
public class ConnectionFactory {
    
    /*public Connection getConnection() {
        try {
            return DriverManager.getConnection(
          "jdbc:mysql://localhost/votacao", "root", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);            
        }
    }*/
    
    public Connection getConnection(){
        ConfiguracaoConexaoDBEntidade configuracaoDBEntidade = new ConfiguracaoConexaoDBEntidade();
        ConfiguracaoConexaoBDDominio configuracaoBDDominio = new ConfiguracaoConexaoBDDominio();
        configuracaoBDDominio.carregar(configuracaoDBEntidade);
        
        try {
            return DriverManager.getConnection(
                    configuracaoDBEntidade.getUrlConexao(), configuracaoDBEntidade.getUsuario(), configuracaoDBEntidade.getSenha());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
