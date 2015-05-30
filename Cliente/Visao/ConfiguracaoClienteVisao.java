package Cliente.Visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConfiguracaoClienteVisao extends JDialog{
    
    private String host="";
	public ConfiguracaoClienteVisao() {
		this.setModal(true); 
		setBounds(0, 0, 589, 67);
		JLabel lblHost = new JLabel("Host:");
		getContentPane().add(lblHost, BorderLayout.WEST);
		
		txtHost = new JTextField();
		getContentPane().add(txtHost, BorderLayout.CENTER);
		txtHost.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				host = txtHost.getText();
				setVisible(false);
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.EAST);
	}
	
	public String getHost(){
		setVisible(true);
		return  host;
	}
        
	private static final long serialVersionUID = 1L;
	private JTextField txtHost;
    
}
