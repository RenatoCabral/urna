package Servidor.Modelo.Dominio;

import Servidor.Conexao.ConfiguracaoConexaoDBEntidade;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracaoConexaoBDDominio {
    
    private String urlFile = "./properties/config.properties"; // CAMINHO O ARQUIVO PROPERTIES
    //PROPERTIES SÃO ARQUIVOS DE PROPRIEDADES

    //CONSTRUTOR DA CLASSE
    public ConfiguracaoConexaoBDDominio() {
    }
    
    //METODO PARA SALVAR, PASSANDO COMO PARAMETRO A CLASSE ConfiguracaoConexaoDBEntidade RECEBENDO O OBJETO configuracao
    public boolean salvar(ConfiguracaoConexaoDBEntidade configuracao) /*throws IOException*/{
        Properties props = new Properties();//Instancia-se a classe Properties na variável props.
        try {
            props.setProperty("host",configuracao.getHost());//PEGADO A PROPRIEDADE DO HOST E ATRIBUIDO AO OBJETO CONFIGURAÇÃO
            props.setProperty("database", configuracao.getDataBase());//PEGADO A PROPRIEDADE DO DATABASE E ATRIBUIDO AO OBJETO CONFIGURAÇÃO
            props.setProperty("porta", String.valueOf(configuracao.getPorta()));//PEGADO A PROPRIEDADE DA PORTA E ATRIBUIDO AO OBJETO CONFIGURAÇÃO, PASSANDO VALOR INTEIRO PARA UMA STRING
            props.setProperty("usuario", configuracao.getUsuario());//PEGADO A PROPRIEDADE DO USUARIO E ATRIBUIDO AO OBEJTO CONFIGURAÇÃO
            props.setProperty("senha", configuracao.getSenha());//PEGADO A PROPRIEDADE DA SENHA E ATRIBUI AO OBJETO CONFIGURAÇÃO
            props.store(new FileOutputStream(urlFile), null);//FILEOUTPUTSTREM  É UMA classe de fluxo de bytes que é usado para manipular dados raw binário, GRAVAR DADOS EM UM ARQUIVO
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;      
    }
    
    private Properties getProperties() throws IOException{
        Properties props = new Properties();//Instancia-se a classe Properties na variável props.
        FileInputStream file = new FileInputStream(urlFile);//FileInputStream é uma classe de fluxo de bytes que é usado para ler bytes de arquivo.
        props.load(file);// LEITURA DO ARQUIVO
        return props;
    }
    
    //METODO CARREGAR PASSANDO COMO PARAMETRO A CLASSE ConfiguracaoConexaoDBEntidade
    public void  carregar(ConfiguracaoConexaoDBEntidade configuracaoDBEntidade){
        try {
            Properties prop = getProperties();//Instancia-se a classe Properties na variável props.
            configuracaoDBEntidade.setHost(prop.getProperty("host"));//OBJETO  configuracaoDBEntidade RECEBENDO O HOST DA CONEXÃO
            configuracaoDBEntidade.setDataBase(prop.getProperty("database"));//OBJETO  configuracaoDBEntidade RECEBENDO O databse DA CONEXÃO
            configuracaoDBEntidade.setPorta(Integer.valueOf(prop.getProperty("porta")));//OBJETO  configuracaoDBEntidade RECEBENDO a porta DA CONEXÃO
            configuracaoDBEntidade.setUsuario(prop.getProperty("usuario"));//OBJETO  configuracaoDBEntidade RECEBENDO O usuario DA CONEXÃO
            configuracaoDBEntidade.setSenha(prop.getProperty("senha"));//OBJETO  configuracaoDBEntidade RECEBENDO a senha DA CONEXÃO       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
