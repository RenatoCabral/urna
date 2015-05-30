package Servidor.Visao;

import Servidor.Modelo.Entidade.Mesario.CandidatoEntidade;
import Servidor.Modelo.Entidade.Mesario.UrnasEntidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VotacaoVisao extends JFrame{
    
    private JTable table;	
	private String[]  colunas = {"C\u00F3digo", "Nome", "Partido", "Votos"};
	private List<String[]> dados = new ArrayList<>();
	public VotacaoVisao(UrnasEntidade urnas) {
		setBounds(0, 0, 532, 402);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 516, 318);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		dados.clear();
		for (CandidatoEntidade c : urnas.getCandidatos()) {
			dados.add(new String[]{c.getCodigo(), c.getNome(), c.getPartido(), Integer.toString(c.getVotos())});
		}
		
		DefaultTableModel model = new DefaultTableModel(
		        dados.toArray(new String[dados.size()][]), colunas);
		//dados.add("C\u00F3digo", "Nome", "Partido", "Votos");
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(417, 329, 89, 23);
		getContentPane().add(btnFechar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    
}
