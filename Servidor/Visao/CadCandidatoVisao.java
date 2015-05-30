package Servidor.Visao;

import Servidor.Modelo.Dominio.CandidatoDominio;
import Servidor.Modelo.Entidade.Mesario.CandidatoEntidade;
import Servidor.Modelo.Entidade.Mesario.UrnasEntidade;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CadCandidatoVisao extends JDialog{
    
    private static final long serialVersionUID = 1L;
	private JTable table;
	private String[]  colunas = {"C\u00F3digo", "Nome", "Partido", "Votos"};
	private List<String[]> dados = new ArrayList<>();
	private UrnasEntidade urnas;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnRemover;
	private JLabel lblCandidatos;
	private CandidatoDominio candidatoDominio;
	private DefaultTableModel model;
	private JButton btnFechar;
	public CadCandidatoVisao(UrnasEntidade urnas){
		this.setModal(true);
		setBounds(0, 0, 675, 421);
		getContentPane().setLayout(null);
		this.urnas = urnas;
		candidatoDominio = new CandidatoDominio();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 516, 318);
		getContentPane().add(scrollPane);
		
		table = new JTable(); //CRIANDO OBJETO TALE DO TIPO JTABLE
		preencherTable();//METODO DE PREENCHER TABELA
		scrollPane.setViewportView(table);
		
                //ABAIXO CRIAÇÃO DE ALGUNS BOTÕES
                
                //BOTÃO ADICIONAR
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}			
		});
		btnAdicionar.setBounds(536, 43, 113, 23);
		getContentPane().add(btnAdicionar);
		
                //BOTÃO EDITAR
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(536, 72, 113, 23);
		getContentPane().add(btnEditar);
		
                //BOTÃO REMOVER
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(536, 101, 113, 23);
		getContentPane().add(btnRemover);
		
		lblCandidatos = new JLabel("Candidatos");
		lblCandidatos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCandidatos.setBounds(10, 11, 119, 14);
		getContentPane().add(lblCandidatos);
		
                //BOTÃO FECHAR
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(536, 135, 113, 23);
		getContentPane().add(btnFechar);
	}
	
	private void adicionar() { // METODO DE ADICIONAR
		ManutencaoCandidatoVisao adicionar= new ManutencaoCandidatoVisao();//INSTANCIANDO CLASSE MANUTENCAOCANDIDATOVISAO COM O METODO DE ADICIONAR
		adicionar.setVisible(true);
		if (adicionar.isOk()) {// 
			CandidatoEntidade candidato = new CandidatoEntidade();//CIANDO OBJETO CANDIDATO
			candidato.setCodigo(adicionar.getTextCodigo().getText()); // OBJETO CANDIDATO RECEBE O CODIGO
			candidato.setNome(adicionar.getTextNome().getText());// OBJETO CANDIDATO RECEBE O NOME
			candidato.setPartido(adicionar.getTextPartido().getText());// OBJETO CANDIDATO RECEBE O PARTIDO
			candidatoDominio.salvar(candidato);//METODO SALVAR RECEBENDO OBJETO CANDIDATO
			candidatoDominio.carregar(urnas.getCandidatos());//CARREGANDO OS CANDIDATOS NA URNA
			preencherTable();//CHAMADA DO METODO DE PREENCHERTABELA COM OS CANDIDATOS
		}
	}
	
	private void editar() { // METODO DE EDITAR
		if (table.getSelectedRow()>=0){
			if (urnas.getCandidatos().get(table.getSelectedRow()).getId() > 0){ // OS CAMPOS QUE PODERAM SER EDITADOS
				ManutencaoCandidatoVisao adicionar= new ManutencaoCandidatoVisao();
				adicionar.getTextCodigo().setText(urnas.getCandidatos().get(table.getSelectedRow()).getCodigo());
				adicionar.getTextNome().setText(urnas.getCandidatos().get(table.getSelectedRow()).getNome());
				adicionar.getTextPartido().setText(urnas.getCandidatos().get(table.getSelectedRow()).getPartido());
				adicionar.setVisible(true);	
				if (adicionar.isOk()) {					
					urnas.getCandidatos().get(table.getSelectedRow()).setCodigo(adicionar.getTextCodigo().getText());
					urnas.getCandidatos().get(table.getSelectedRow()).setNome(adicionar.getTextNome().getText());
					urnas.getCandidatos().get(table.getSelectedRow()).setPartido(adicionar.getTextPartido().getText());
					candidatoDominio.salvar(urnas.getCandidatos().get(table.getSelectedRow()));
					candidatoDominio.carregar(urnas.getCandidatos());
					preencherTable();//CHAMADA DO METODO DE PREENCHERTABELA APÓS A EDIÇÃO
				}
			}
		} else JOptionPane.showMessageDialog(null,"Deve ser selecionado um registro antes de editar!");
	}
	
	private void remover() { // METODO DE REMOVER
		int resposta;
		if (table.getSelectedRow()>=0){
			if (urnas.getCandidatos().get(table.getSelectedRow()).getId() > 0){
				resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse registro?");
				if (resposta==JOptionPane.YES_OPTION){
					candidatoDominio.remover(urnas.getCandidatos().get(table.getSelectedRow()));
					candidatoDominio.carregar(urnas.getCandidatos());
					preencherTable();
				}
				else
					JOptionPane.showMessageDialog(null,"Os dados foram mantidos sem alterações!");
			}
		}
	}
	
	private void preencherTable(){//METODO DE PREENCHER TABELA
		dados.clear();
		candidatoDominio.carregar(urnas.getCandidatos());
		for (CandidatoEntidade c : this.urnas.getCandidatos()) {
			dados.add(new String[]{c.getCodigo(), c.getNome(), c.getPartido(), Integer.toString(c.getVotos())});
		}
		
		model = null;		
		model = new DefaultTableModel(
		        dados.toArray(new String[dados.size()][]), colunas);
		table.setModel(model);
	}
    
}
