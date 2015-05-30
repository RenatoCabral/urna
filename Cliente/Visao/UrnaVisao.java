package Cliente.Visao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Cliente.Modelo.Dominio.ClienteTH;
import Servidor.Modelo.Entidade.Mesario.UrnaEntidade;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UrnaVisao extends JFrame implements IUrnaVisao{
	/**
	 * 
	 */
	private static UrnaVisao jrframe = null;
	private UrnaEntidade urna = null;
	private static final long serialVersionUID = 1L;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JPanel panel;
	private JLabel lblLinha;
	private JLabel lblRodaPeL1;
	private JLabel lblRodaPeL2;
	private JLabel lblRodaPeL3;
	private static ClienteTH clienteTH;
	private JLabel lblmsg1;
	private int indiceCandidato = -1;
	private JLabel lblmsgCap1;
	private JLabel lblmsgCap2;
	private JLabel lblmsg2;
	private JLabel lblCategoria;
	private JLabel lblNumero;
	private JLabel lblVotoPara;
	private JLabel lblBloqueada;
	private JButton btnConfirmar;
	private JButton btnBranco;
	private JMenuBar menuBar;
	private JMenuItem mntmFecharAplicativo;
	UrnaVisao() {
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);  
		setBounds(0, 0, 965, 640);
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); 
		panel = new JPanel();
		panel.setBounds(0, 0, 957, 587);
		getContentPane().add(panel);		
		panel.setLayout(null);
		urna = new UrnaEntidade();		
		JButton Button1 = new JButton("New button");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencheCodigo("1");
			}
		});
		
		btnBranco = new JButton("New button");
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Branco");
			}
		});	
		btnBranco.setBounds(637, 490, 73, 41);
		prepararButton(btnBranco);
		
		JButton Button4 = new JButton("New button");
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("4");
			}
		});		
		Button4.setBounds(678, 319, 48, 36);
		prepararButton(Button4);
		
		JButton Button5 = new JButton("New button");
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("5");
			}
		});			
		Button5.setBounds(747, 319, 48, 36);
		prepararButton(Button5);
		
		JButton Button8 = new JButton("New button");
		Button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("8");
			}
		});		
		Button8.setBounds(747, 376, 48, 41);
		prepararButton(Button8);
		
		JButton Button3 = new JButton("New button");
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("3");
			}
		});			
		Button3.setBounds(814, 259, 56, 42);
		prepararButton(Button3);
		
		JButton Button7 = new JButton("New button");
		Button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("7");
			}
		});			
		Button7.setBounds(678, 376, 48, 41);
		prepararButton(Button7);
		
		JButton Button9 = new JButton("New button");
		Button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("9");
			}
		});		
		Button9.setBounds(814, 376, 48, 41);
		prepararButton(Button9);
		
				
		JButton Button6 = new JButton("New button");
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("6");
			}
		});		 
		Button6.setBounds(814, 319, 56, 36);
		prepararButton(Button6);
		
		JButton Button0 = new JButton("New button");
		Button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("0");
			}
		});		 
		Button0.setBounds(747, 428, 56, 51);
		prepararButton(Button0);
				
		JButton Button2 = new JButton("New button");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCodigo("2");
			}
		});		
		Button2.setBounds(750, 259, 50, 42);
		prepararButton(Button2);			
		Button1.setBounds(681, 259, 50, 42);
		prepararButton(Button1);
		
		btnConfirmar = new JButton("");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirma();
			}			
		});
		btnConfirmar.setOpaque(false);
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setBounds(819, 481, 73, 50);
		panel.add(btnConfirmar);
		
		JButton btnCorrige = new JButton("");
		btnCorrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCodigo();
			}
		});
		btnCorrige.setOpaque(false);
		btnCorrige.setContentAreaFilled(false);
		btnCorrige.setBorderPainted(false);
		btnCorrige.setBounds(732, 490, 67, 41);
		panel.add(btnCorrige);
		
		lblBloqueada = new JLabel("CONECTAR");
		lblBloqueada.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloqueada.setFont(new Font("Tahoma", Font.BOLD, 84));
		lblBloqueada.setBounds(40, 203, 544, 314);
		panel.add(lblBloqueada);
		
		lblVotoPara = new JLabel("SEU VOTO VAI PARA");
		lblVotoPara.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVotoPara.setBounds(40, 203, 200, 50);
		panel.add(lblVotoPara);
		
		lblCategoria = new JLabel("Deputado Estadual");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCategoria.setBounds(115, 269, 200, 50);
		panel.add(lblCategoria);
		
		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField1.setText("");
		textField1.setBounds(115, 330, 48, 45);
		panel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setText("");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField2.setColumns(10);
		textField2.setBounds(162, 330, 48, 45);
		panel.add(textField2);
		
		textField3 = new JTextField();
		textField3.setEditable(false);
		textField3.setText("");
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField3.setColumns(10);
		textField3.setBounds(209, 330, 48, 45);
		panel.add(textField3);
		
		textField4 = new JTextField();
		textField4.setEditable(false);
		textField4.setText("");
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField4.setColumns(10);
		textField4.setBounds(256, 330, 48, 45);
		panel.add(textField4);
		
		textField5 = new JTextField();
		textField5.setEditable(false);
		textField5.setText("");
		textField5.setHorizontalAlignment(SwingConstants.CENTER);
		textField5.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField5.setColumns(10);
		textField5.setBounds(303, 330, 48, 45);
		panel.add(textField5);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumero.setBounds(40, 325, 62, 50);
		panel.add(lblNumero);
		
		lblmsgCap1 = new JLabel("Nome:");
		lblmsgCap1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmsgCap1.setBounds(40, 386, 62, 38);
		panel.add(lblmsgCap1);
		
		lblmsg1 = new JLabel("Candidato1");
		lblmsg1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmsg1.setBounds(115, 386, 236, 38);
		panel.add(lblmsg1);
		
		lblmsgCap2 = new JLabel("Partido:");
		lblmsgCap2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmsgCap2.setBounds(40, 428, 62, 38);
		panel.add(lblmsgCap2);
		
		lblmsg2 = new JLabel("Partido A");
		lblmsg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmsg2.setBounds(115, 428, 236, 38);
		panel.add(lblmsg2);
		
		JPanel pnlImgCandidato = new JPanel();
		pnlImgCandidato.setBounds(430, 203, 154, 152);
		panel.add(pnlImgCandidato);
		pnlImgCandidato.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImgCandidato = new JLabel("");
		pnlImgCandidato.add(lblImgCandidato);
		
		pnlImgCandidato.setVisible(false);
		
		lblLinha = new JLabel("__________________________________");
		lblLinha.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLinha.setBounds(39, 429, 545, 50);
		panel.add(lblLinha);
		
		lblRodaPeL1 = new JLabel("Aperte a tecla:");
		lblRodaPeL1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRodaPeL1.setToolTipText("");
		lblRodaPeL1.setBounds(40, 469, 106, 15);
		panel.add(lblRodaPeL1);
		
		lblRodaPeL2 = new JLabel("VERDE para CONFIRMAR esse voto");
		lblRodaPeL2.setToolTipText("");
		lblRodaPeL2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRodaPeL2.setBounds(67, 484, 236, 15);
		panel.add(lblRodaPeL2);
		
		lblRodaPeL3 = new JLabel("LARANJA para REINICIAR esse voto");
		lblRodaPeL3.setToolTipText("");
		lblRodaPeL3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRodaPeL3.setBounds(50, 502, 236, 15);
		panel.add(lblRodaPeL3);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 947, 583);
		label.setIcon(new ImageIcon(UrnaVisao.class.getResource("/Cliente/Visao/img/urna.jpg")));
		panel.add(label);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mntmConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfiguracaoClienteVisao host = new ConfiguracaoClienteVisao(); 
				String ip = host.getHost();
				if (!ip.isEmpty()){
					conectar(ip);
				}
			}
		});
		mnConfiguraes.add(mntmConectar);		
		
		mntmFecharAplicativo = new JMenuItem("Fechar aplicativo");
		mntmFecharAplicativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}
		});
		mnConfiguraes.add(mntmFecharAplicativo);
		limparCodigo();
		desconectada();
		clienteTH = new ClienteTH(this);
  }
	private void confirma() {
		if (indiceCandidato > -1)
			clienteTH.votar(clienteTH.getUrna().getCandidatos().get(indiceCandidato).getCodigo());
		
	}

	private void prepararButton(JButton btn){
	  btn.setIcon(new ImageIcon(UrnaVisao.class.getResource("/Cliente/Visao/img/buttontransp.png")));
	  btn.setOpaque(false);
	  btn.setContentAreaFilled(false);
	  btn.setBorderPainted(false);
	  btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	  panel.add(btn);  
  }

  private void preencheCodigo(String digito){
	  boolean habilitar = false;
	  if (textField1.getText().isEmpty()){
		  textField1.setText(digito);  
		  habilitar= false;
	  } else  if (textField2.getText().isEmpty()){
		  textField2.setText(digito);
		  habilitar= false;
	  } else  if (textField3.getText().isEmpty()){
		  textField3.setText(digito);
		  habilitar= false;
	  } else  if (textField4.getText().isEmpty()){
		  textField4.setText(digito);
		  habilitar= false;
	  } else  if (textField5.getText().isEmpty()){
		  textField5.setText(digito);
		  habilitar= true;
		  procurarCadidato();
	  } else
		  procurarCadidato();
	  habilitarRodape(habilitar);
	  habilitarCabecalho(habilitar);
  }
  
  private void limparCodigo(){	  
	  textField1.setText("");  
	  textField2.setText("");  
	  textField3.setText("");  
	  textField4.setText("");  
	  textField5.setText("");
	  lblmsg1.setText("");
	  lblmsg2.setText("");
	  habilitarCabecalho(false);
	  habilitarRodape(false);
  }
  
  private void habilitarRodape(boolean habiltar){	  
	lblLinha.setVisible(habiltar);
	lblRodaPeL1.setVisible(habiltar);
	lblRodaPeL2.setVisible(habiltar);
	lblRodaPeL3.setVisible(habiltar);
	lblmsgCap1.setVisible(habiltar);
	lblmsgCap2.setVisible(habiltar);
  }
  
  private void habilitarCabecalho(boolean habiltar){	
	  	lblVotoPara.setVisible(habiltar);
	  	lblCategoria.setVisible(habiltar);
		lblmsgCap1.setVisible(habiltar);
		lblmsg1.setVisible(habiltar);
		lblmsgCap2.setVisible(habiltar);
		lblmsg2.setVisible(habiltar);		
	  }
  
  public static void main(String[] args) {
	  jrframe = new UrnaVisao();	  
	  jrframe.setVisible(true);  
	  
  }
  
  private void conectar(String ip){	
	  clienteTH.setIp(ip);
	  clienteTH.setUrna(urna);
	  clienteTH.start();  
  }
  
  public void bloqueio(boolean habilitado){
	  habilitarCabecalho(!habilitado);
	  habilitarRodape(!habilitado);
	  textField1.setVisible(!habilitado);
	  textField2.setVisible(!habilitado);
	  textField3.setVisible(!habilitado); 
	  textField4.setVisible(!habilitado);
	  textField5.setVisible(!habilitado);
	  lblNumero.setVisible(!habilitado);
	  lblBloqueada.setVisible(habilitado);
	  lblBloqueada.setText("BLOQUEADA");
	  if (!habilitado) limparCodigo();
	  
  }  
  
  public void finalizaVotacao(){
	  habilitarCabecalho(false);
	  habilitarRodape(false);
	  textField1.setVisible(false);
	  textField2.setVisible(false);
	  textField3.setVisible(false); 
	  textField4.setVisible(false);
	  textField5.setVisible(false);
	  lblNumero.setVisible(false);
	  lblBloqueada.setVisible(true);
	  lblBloqueada.setText("FIM");	
	  
  }  

  public void desconectada(){
	  habilitarCabecalho(false);
	  habilitarRodape(false);
	  textField1.setVisible(false);
	  textField2.setVisible(false);
	  textField3.setVisible(false); 
	  textField4.setVisible(false);
	  textField5.setVisible(false);
	  lblNumero.setVisible(false);
	  lblBloqueada.setVisible(true);
	  lblBloqueada.setText("CONECTAR");	
	  
  }  
  
  private void procurarCadidato(){
	  indiceCandidato = -1;
	  String codigo = textField1.getText()+textField2.getText()+textField3.getText()+textField4.getText()+textField5.getText();
	  for (int i = 0; i < clienteTH.getUrna().getCandidatos().size(); i++) {
		  if (clienteTH.getUrna().getCandidatos().get(i).getCodigo().equalsIgnoreCase(codigo)){
			  indiceCandidato = i;
			  break;
		  }
	}
	  if (indiceCandidato > -1){
		  lblmsg1.setText(clienteTH.getUrna().getCandidatos().get(indiceCandidato).getNome());
		  lblmsg2.setText(clienteTH.getUrna().getCandidatos().get(indiceCandidato).getPartido());
	  }
	  else {
		  lblmsg1.setText("");
		  lblmsg2.setText("");
	  }
  }
  
  private void finalizar(){
	  clienteTH.interrupt();
	  System.exit(0);
  }
}