package Servidor.Visao;

import Servidor.Conexao.ConfiguracaoConexaoDBEntidade;
import Servidor.Modelo.Dominio.ConfiguracaoConexaoBDDominio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConfiguracaoConexaoBDVisao extends JDialog{
    
    private static final long serialVersionUID = 1L;
	private JTextField txtHost;
	private JTextField txtPorta;
	private JTextField txtUsuario;
	private JButton btnConfirmar;
	private JButton btnFechar;
	private JPasswordField txtSenha;
	private JTextField txtDatabase;
	private ConfiguracaoConexaoDBEntidade configuracaoBDEntidade;
	private ConfiguracaoConexaoBDDominio configuracaoBDDominio;

	public ConfiguracaoConexaoBDVisao(){
		this.setModal(true);
		setBounds(0, 0, 411, 203);
		getContentPane().setLayout(null);
		
		configuracaoBDEntidade = new ConfiguracaoConexaoDBEntidade();
		configuracaoBDDominio = new ConfiguracaoConexaoBDDominio();
		
		configuracaoBDDominio.carregar(configuracaoBDEntidade);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(10, 8, 57, 23);
		getContentPane().add(lblHost);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(8, 98, 59, 23);
		getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(8, 129, 59, 23);
		getContentPane().add(lblSenha);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(8, 69, 53, 21);
		getContentPane().add(lblPorta);
		
		txtHost = new JTextField();
		txtHost.setBounds(78, 7, 200, 23);
		getContentPane().add(txtHost);
		txtHost.setColumns(10);
		
		txtPorta = new JTextField();
		txtPorta.setBounds(78, 67, 53, 23);
		getContentPane().add(txtPorta);
		txtPorta.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(78, 97, 200, 23);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnConfirmar.setBounds(290, 8, 95, 23);
		getContentPane().add(btnConfirmar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(290, 129, 95, 23);
		getContentPane().add(btnFechar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(78, 129, 200, 23);
		getContentPane().add(txtSenha);
		
		JLabel lblDatabase = new JLabel("Database:");
		lblDatabase.setBounds(10, 37, 57, 23);
		getContentPane().add(lblDatabase);
		
		txtDatabase = new JTextField();
		txtDatabase.setBounds(78, 37, 200, 23);
		getContentPane().add(txtDatabase);
		txtDatabase.setColumns(10);
		preencherCampos();
	}
	
	private void preencherCampos(){ // METODO DE PREENCHERCAMPOS
		txtHost.setText(configuracaoBDEntidade.getHost());
		txtDatabase.setText(configuracaoBDEntidade.getDataBase());
		txtPorta.setText(String.valueOf(configuracaoBDEntidade.getPorta()));
		txtUsuario.setText(configuracaoBDEntidade.getUsuario());
		txtSenha.setText(configuracaoBDEntidade.getSenha());		
	}
	
	private void preencherObjeto(){ // METODO DE PREENCHER OBJETO
		configuracaoBDEntidade.setHost(txtHost.getText().toString());
		configuracaoBDEntidade.setDataBase(txtDatabase.getText().toString());
		configuracaoBDEntidade.setPorta(Integer.valueOf(txtPorta.getText().toString()));
		configuracaoBDEntidade.setUsuario(txtUsuario.getText().toString());		
		configuracaoBDEntidade.setSenha(new String(txtSenha.getPassword()));				
	}
	
	private void salvar(){ // METODO DE SALVAR
		preencherObjeto();
		if (configuracaoBDDominio.salvar(configuracaoBDEntidade)){
			JOptionPane.showMessageDialog(null,"Registro salvo com sucesso!");
		}
	}
    
}
