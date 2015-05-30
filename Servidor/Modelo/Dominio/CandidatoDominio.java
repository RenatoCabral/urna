package Servidor.Modelo.Dominio;

import Servidor.Modelo.DAO.CandidatoDAO;
import Servidor.Modelo.Entidade.Mesario.CandidatoEntidade;
import java.util.List;

public class CandidatoDominio {
    
    private CandidatoDAO dao; // CIRAÇÃO DO OBJETO dao, DA CLASSE CandidatoDAO
    
    //CONTRUTOR DA CLASSE CandidatoDominio
    public CandidatoDominio(){
        dao = new CandidatoDAO();
    }
    
    //METODO DE SALVAR DO RECEBENDO O OBJETO candidato
    public boolean salvar(CandidatoEntidade candidato){
        if(candidato.getId()<=0) // SE O id FOR <= 0 ENTRE NO LAÇO
            return dao.inserir(candidato); // INSERI O candidato CHAMANDO O METODO INSERIR DO DAO
        else
            return dao.alterar(candidato);// ALTERA O candidato CHAMANDO O METODO ALATERAR DO DAO
    }
    
    //METODO DE CARREGAR RECEBENDO O OBJETO candidato
    public boolean carregar(int id, CandidatoEntidade Candidato){
        return dao.carregar(id, Candidato);// CARREGA O OBJETO CHAMANDO O METODO CARREGAR DO DAO
    }
    
    //METODO DE CARREGAR RECEBENDO UMA LISTA DE CANDIDATOS
    public boolean carregar(List<CandidatoEntidade> Candidatos){
        return dao.carregar(Candidatos);//CARREGA UMA LISTA DE OBJETOS CHAMANDO O METODO DE CARREGAR DA DAO
    }
    
    //METODO DE REMOVER RECEBENDO OBJETO candidato
    public boolean remover(CandidatoEntidade candidato){
        return dao.remover(candidato);// CARREGA O METODO DE REMOVER DA DAO, PARA REMOVER O OBJETO
    }
    
}
