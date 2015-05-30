package Servidor.Visao;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class JtextFieldSomenteNumeros extends JTextField{
    
    private static final long serialVersionUID = 1L;
	private int maximoCaracteres = -1;// definição de -1

	// como valor normal de um textfield sem limite de caracters
	public JtextFieldSomenteNumeros() {
		super();
		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	public JtextFieldSomenteNumeros(int limit) {
		this();
		setColumns(limit);
	}

	private void jTextFieldKeyTyped(KeyEvent evt) {

		String caracteres = "0987654321";// lista de caracters que não devem ser
                                            // aceitos
		if (!caracteres.contains(evt.getKeyChar() + "")) {// se o caracter que
								// gerou o evento
                                                                // estiver não
                                                                // estiver na lista
			evt.consume();// aciona esse propriedade para eliminar a ação do
							// evento
		}
		if ((getText().length() >= getMaximoCaracteres())
				&& (getMaximoCaracteres() != -1)) {
			// if para saber se precisa verificar também o tamanho da string do
			// campo
			// maior ou igual ao tamanho máximo, cancela e nao deixa inserir
			// mais
			evt.consume();
			setText(getText().substring(0, getMaximoCaracteres()));
			// esta linha acima é para remover os caracters inválidos caso o
			// usuário tenha copiado o //conteúdo de algum lugar, ou seja, com
			// tamanho maior que o definido
		}// fim do if do tamanho da string do campo

	}

	public int getMaximoCaracteres() {
		return maximoCaracteres;
	}

	public void setMaximoCaracteres(int maximoCaracteres) {
		this.maximoCaracteres = maximoCaracteres;
	}
    
}
