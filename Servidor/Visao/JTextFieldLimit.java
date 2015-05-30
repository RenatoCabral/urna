package Servidor.Visao;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument{
    
    private static final long serialVersionUID = 1L;
	private int limit;
	// optional uppercase conversion
	private boolean toUppercase = false;

	private int maximo = 500;

	public JTextFieldLimit(int limit) {
		super();
		if (limit == 0)
			this.limit = maximo;
		else
			this.limit = limit;
	}

	public JTextFieldLimit(int limit, boolean upper) {
		super();
		if (limit == 0)
			this.limit = maximo;
		else
			this.limit = limit;
		toUppercase = upper;
	}

	@Override
	public void insertString(int offset, String str, AttributeSet attr)
			throws BadLocationException {
		if (str == null) {
			return;
		}

		if ((getLength() + str.length()) <= limit) {
			if (toUppercase) {
				str = str.toUpperCase();
			}
			super.insertString(offset, str, attr);
		}
	}
    
}
