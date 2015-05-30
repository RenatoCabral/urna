package Servidor.Visao;

import Servidor.Modelo.Dominio.ServidorTH;
import Servidor.Modelo.Entidade.Mesario.CandidatoEntidade;
import Servidor.Modelo.Entidade.Mesario.UrnaEntidade;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServidorVisao extends JFrame implements IServidorVisao {
    
    private static final long serialVersionUID = 1L;
    private DefaultListModel<String> lista = new DefaultListModel<String>();
    private JList<String> list;
    private static ServidorTH servidor;
    private JButton btnFecharConexao;
    private JMenuItem mntmCadastroCandidatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneVotacao;
    private JTable jTableVotacao;
    private String[] columnNames = {"C\u00F3digo", "Nome", "Partido", "Votação","%"};
    private List<Object[]> data = new ArrayList<>(); // LISTA DE OBJECT
    private DefaultTableModel model = new DefaultTableModel(data.toArray(new String[data.size()][]), columnNames); 
    private JLabel lblVotao;
	public ServidorVisao() {		
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);  
		setBounds(0, 0, 1011, 656);
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); 
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jScrollPane1.setBounds(10, 18, 827, 176);		
		lista.addElement("======== Aguardando conexões ========");
		
		jScrollPaneVotacao = new javax.swing.JScrollPane();
		getContentPane().add(jScrollPaneVotacao);
		jTableVotacao = new JTable(model);
		TableColumn columnCodigo = jTableVotacao.getColumnModel().getColumn(0);
		columnCodigo.setMaxWidth(60);
		columnCodigo.setMinWidth(60);
		TableColumn columnNome = jTableVotacao.getColumnModel().getColumn(1);
		columnNome.setMaxWidth(450);
		columnNome.setMinWidth(450);
		TableColumn columnPartido = jTableVotacao.getColumnModel().getColumn(2);
		columnPartido.setMaxWidth(300);
		columnPartido.setMinWidth(300);
		TableColumn columnProgress = jTableVotacao.getColumnModel().getColumn(3);
		columnProgress.setCellRenderer(new ProgressRenderer());
		columnProgress.setMaxWidth(100);
		columnProgress.setMinWidth(100);
		TableColumn columnPercentual = jTableVotacao.getColumnModel().getColumn(4);
		columnPercentual.setMaxWidth(25);
		columnPercentual.setMinWidth(25);
		jScrollPaneVotacao.setViewportView(jTableVotacao);
		jScrollPaneVotacao.setBounds(10, 236, 975, 337);
		getContentPane().add(jScrollPane1);
		list = new JList<String>();
		jScrollPane1.setViewportView(list);		
		list.setModel(lista);  
		list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		list.setModel(lista);
		list.setBounds(10, 338, 348, -321);
		getContentPane().add(jScrollPane1);
		JLabel lblNewLabel = new JLabel("Urnas conectadas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 3, 128, 14);
		getContentPane().add(lblNewLabel);
		
                //BOTÃO ONDE SERÁ FEITA A LIBERAÇÃO DA URNA NO SERVIDOR
		JButton btnNewButton = new JButton("Liberar urna");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				servidor.getUrnas().getUrnas().get(list.getSelectedIndex()).setBloqueada(false);				
			}
		});
		
		btnNewButton.setBounds(847, 19, 138, 23);
		getContentPane().add(btnNewButton);
		
                //BOTÃO ONDE SERÁ FECHADA A CONEXÃO DA URNA COM O SERVIDOR
		btnFecharConexao = new JButton("Fechar conex\u00E3o");
		btnFecharConexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servidor.getUrnas().getUrnas().get(list.getSelectedIndex()).setDesconectar(true);
			}
		});
		btnFecharConexao.setBounds(847, 53, 138, 23);
		getContentPane().add(btnFecharConexao);
		
                //BOTÃO ONDE SERÁ FINALIZADO, FECHADO O SERVIDOR
		JButton btnNewButton_2 = new JButton("Finalizar servidor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}			
		});
		btnNewButton_2.setBounds(847, 171, 138, 23);
		getContentPane().add(btnNewButton_2);
		
		lblVotao = new JLabel("Vota\u00E7\u00E3o");
		lblVotao.setBounds(10, 205, 334, 23);
		getContentPane().add(lblVotao);
		
		
		servidor = new ServidorTH(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnManuteno = new JMenu("Manuten\u00E7\u00E3o");
		menuBar.add(mnManuteno);
		
                //BOTÃO DE CADASTRO DE CANDIDATOS
		mntmCadastroCandidatos = new JMenuItem("Cadastros");
		mntmCadastroCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadCandidatos();
			}
		});
		
		JMenuItem mntmConfigurao = new JMenuItem("Configura\u00E7\u00E3o");
		mntmConfigurao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configuracaoBD();
			}
		});
		mnManuteno.add(mntmConfigurao);
		mnManuteno.add(mntmCadastroCandidatos);
		
	}
	
	private void cadCandidatos() {
		CadCandidatoVisao cadCandidato = new CadCandidatoVisao(servidor.getUrnas());
		cadCandidato.setVisible(true);
	}

	public static void main(String[] args) {
		ServidorVisao jrframe = new ServidorVisao();		
		jrframe.setVisible(true);
		iniciarServidor();
	   
	 }
	
        //METODO ONDE A LISTA DE URNAS CONECTADAS NO SERVIDOR SERÁ FEITA
	private void preencherLista(){
		lista.clear();
		lista.addElement("======== Aguardando conexões ========");
		for (UrnaEntidade urna : servidor.getUrnas().getUrnas()) {
			if (urna.isBloqueada()) 
				lista.add(lista.getSize()-1, urna.getNome() + " - Bloqueada");
			else
				lista.add(lista.getSize()-1, urna.getNome() + " - Desbloqueada");
		}			
		jScrollPane1.setViewportView(list);		
		list.setModel(lista);  
		list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		list.setModel(lista);
		list.setBounds(10, 338, 348, -321);		
	}
	
	private static void iniciarServidor(){
		servidor.start();
	}
	
	@Override
	public void atualizaTela() {
		preencherLista();	
		atualizaVotacao();
	}
	
	private void finalizar() {
		servidor.interrupt();
		System.exit(0);		
	}
	
	private void configuracaoBD(){
		ConfiguracaoConexaoBDVisao visao = new ConfiguracaoConexaoBDVisao();		
		visao.setVisible(true);
		servidor.carregarCandidatos();
	}

	@Override
	public void atualizaVotacao() {
		atualizarTabelaVotacao();		
	}
        
        //METODO DE ATUALIZAÇÃO DE VOTOS
	private void atualizarTabelaVotacao() {
		int qntVotos = servidor.getUrnas().getVotosTotalGeral(); // DECLARADO OBJETO qntVotos QUE RECEBERA OS VOTOS DA URNA
		model.getDataVector().clear();				 
		for (CandidatoEntidade c : servidor.getUrnas().getCandidatos()) {
			if (qntVotos > 0)
				model.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getPartido(), (c.getVotos()*100)/qntVotos, (c.getVotos()*100)/qntVotos });
			else
				model.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getPartido(), c.getVotos(), c.getVotos()});
				
		}				
		jTableVotacao.setModel(model);	
		TableColumn columnProgress = jTableVotacao.getColumnModel().getColumn(1);
		//columnProgress.setCellRenderer(new ProgressRenderer());
		columnProgress.setMaxWidth(100);
		TableColumn columnPercentual = jTableVotacao.getColumnModel().getColumn(2);
		columnPercentual.setMaxWidth(25);
		jScrollPaneVotacao.setViewportView(jTableVotacao);	
		
		lblVotao.setText("Vota\u00E7\u00E3o - Votos válidos = "+qntVotos);
	}
    
}
