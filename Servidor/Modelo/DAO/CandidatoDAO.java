package Servidor.Modelo.DAO;

import Servidor.Conexao.ConnectionFactory;
import Servidor.Modelo.Entidade.Mesario.CandidatoEntidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

//CLASSE DAO, RESPONSAVEL PELA COMUNICAÇÃO COM O BANCO, POSSUI TODOS OS METODOS
public class CandidatoDAO {
    
    private ConnectionFactory connFactory = new ConnectionFactory();
    private Connection con = connFactory.getConnection();
    
    //CONSTRUTOR VAZIO
    public CandidatoDAO(){
    
    }
    
    //METODO PARA CARREGAR UM CANDIDATO DA CLASSE CANDIDATO ENTIDADE
    public boolean carregar(int id, CandidatoEntidade Candidato){
        String sql = "select *from votacao.candidatos where id =?";
        CandidatoEntidade candidato;// DECLARAND OBJETO candidato   
        try {
            PreparedStatement stmt = con.prepareStatement(sql); // PREPARANDO A CONEXAO
            stmt.setInt(1, id); // O PREPAREDESTATEMNTE stmt SETANDO O ID
            ResultSet rs = stmt.executeQuery(); // O RESULTSET EXECUTA A QUERY NO BD
            if(rs.next()){
                candidato = new CandidatoEntidade();
                preencherCandidato(candidato, rs);// CHAMADA DO METODO DE PREENCHERCANDIDATO, RECEBENDO UM CANDIDATO E O RS
            }
        } catch (Exception e) { // TRATAMENTO DE EXECEÇÃO OU FALHA NA CONEXAO
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
            reconectar(); // CHAMADA DO METODO DE RECONEXAO
            return false;
        }
        return true;
    }
    
    //FUNÇÃO QUE IRÁ CARREGAR UMA LISTA DE CANDIDATOS
    public boolean carregar(List<CandidatoEntidade> Candidatos){
        String sql = "select * from votacao.candidatos order by codigo";
        CandidatoEntidade candidato;
        try {
             PreparedStatement stmt = con.prepareStatement(sql); // PREPARANDO A CONEXAO
             ResultSet rs = stmt.executeQuery(); // O RESULTSET EXECUTA A QUERY NO BD
             Candidatos.clear(); // Limpa a lista de candidatos
             while(rs.next()){
                candidato = new CandidatoEntidade();
                preencherCandidato(candidato, rs);// CHAMADA DO METODO DE PREENCHERCANDIDATO, RECEBENDO UM CANDIDATO E O RS
                Candidatos.add(candidato); // ADICIONANDO CANDIDATO
             }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
            reconectar(); // CHAMADA DO METODO DE RECONEXAO
            return false;
        }
        return true;
    }
    
    //FUNÇÃO RESPONSAVEL POR INSERIR OS CANDIDATOS
    public boolean inserir(CandidatoEntidade candidato){
        String sql = "insert into votacao.candidatos(codigo, nome, partido)values(?,?,?)";
        if(! buscarCandidato(candidato)){  // FUNÇÃO DE BUSCAR RECEBENDO UM CANDIDATO
            try {
                PreparedStatement stmt = con.prepareStatement(sql); // PREPRARANDO A CONEXAO    
                //PASSANDO OS ATRIBUTOS DO OBJETO CANDIDATO PARA INSERIR NO BANCO
                stmt.setString(1, candidato.getCodigo());
                stmt.setString(2, candidato.getNome());
                stmt.setString(3, candidato.getPartido());
                return stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
                reconectar(); // CHAMADA DO METODO DE RECONEXAO
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Candidato já cadastrado!");
            return false;
        }
            
            
    }
    
    public boolean alterar(CandidatoEntidade candidato){
        String sql = "update votacao.candidatos set codigo = ?, nome = ?, partido = ? where id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, candidato.getCodigo());
            stmt.setString(2, candidato.getNome());
            stmt.setString(3, candidato.getPartido());
            stmt.setInt(4, candidato.getId());
            return stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
            reconectar(); // CHAMADA DO METODO DE RECONEXAO
            return false;
        }
    }
    
    public boolean remover(CandidatoEntidade candidato){
        String sql = "delete from votacao.candidatos where id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, candidato.getId());
            return stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!");
            reconectar();
            return false;
        }
    }
    
    private void preencherCandidato(CandidatoEntidade candidato, ResultSet rs){
        try {
            candidato.setId(rs.getInt("id"));
            candidato.setCodigo(rs.getString("codigo"));
            candidato.setNome(rs.getString("nome"));
            candidato.setPartido(rs.getString("partido"));
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!");
            reconectar();
        }
    }
    
    private boolean buscarCandidato(CandidatoEntidade candidato){
        String sql = "select * from votacao.candidatos where codigo = ? or nome = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, candidato.getCodigo());
            stmt.setString(2, candidato.getNome());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!");
            reconectar();
            return false;
        }
    }
   
    
    private void reconectar(){
        if(con == null){
            con = connFactory.getConnection();
        }
    }
    
    
    
}
