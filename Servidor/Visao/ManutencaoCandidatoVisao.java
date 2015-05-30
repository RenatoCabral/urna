package Servidor.Visao;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ManutencaoCandidatoVisao extends JDialog{
    
    private static final long serialVersionUID = 1L;
	private JtextFieldSomenteNumeros textCodigo;
	private JTextField textNome;
	private JTextField textPartido;
	private boolean ok;
	
	public ManutencaoCandidatoVisao(){
		this.setModal(true);
		setBounds(0, 0, 376, 169);
		getContentPane().setLayout(null);
		
		ok = false;
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 14, 46, 14);
		getContentPane().add(label);
		
		textCodigo = new JtextFieldSomenteNumeros(5);
		textCodigo.setDocument(new JTextFieldLimit(5));
		textCodigo.setBounds(66, 11, 86, 20);
		getContentPane().add(textCodigo);
		
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(10, 39, 46, 14);
		getContentPane().add(label_1);
		
		textNome = new JTextField(60);
		textCodigo.setDocument(new JTextFieldLimit(60));
		textNome.setBounds(66, 36, 289, 20);
		getContentPane().add(textNome);
		
		JLabel label_2 = new JLabel("Partido:");
		label_2.setBounds(10, 64, 46, 14);
		getContentPane().add(label_2);
		
		textPartido = new JTextField(60);
		textPartido.setDocument(new JTextFieldLimit(60));
		textPartido.setBounds(66, 62, 289, 20);
		getContentPane().add(textPartido);
		
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(183, 93, 172, 20);
		getContentPane().add(btnFechar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validaCampos()) {
					ok = true;
					setVisible(false);
				}
			}
		});
		btnConfirmar.setBounds(5, 93, 172, 20);
		getContentPane().add(btnConfirmar);
		preparaForm();
	}

	public boolean isOk() {
		return ok;
	}

	public JTextField getTextCodigo() {
		return textCodigo;
	}

	public void setTextCodigo(JtextFieldSomenteNumeros textCodigo) {
		this.textCodigo = textCodigo;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextPartido() {
		return textPartido;
	}

	public void setTextPartido(JTextField textPartido) {
		this.textPartido = textPartido;
	}

	private boolean validaCampos(){// METODO DE VALIDAÇÃO DO CAMPO CÓDIGO 
		if (textCodigo.getText().toString().length()!=5){
			JOptionPane.showMessageDialog(null,"O código deve ter cinco digitos numéricos!");			
			return false;
		}			
		return true;
	}
	
    public void preparaForm() {  
        
        // JTextFields limitados e com maiúsculas  
        for (Component c : this.getRootPane().getContentPane().getComponents()) {  
            if (c instanceof JTextField) {  
                ((JTextField) c).setDocument(new JTextFieldLimit(((JTextField) c).getColumns(), true));  
            }  
        }  
          
    }  
    
}
