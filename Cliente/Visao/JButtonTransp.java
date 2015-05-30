package Cliente.Visao;

import javax.swing.JButton;

public class JButtonTransp extends JButton{
    
    private static final long serialVersionUID = 1L;

	public JButtonTransp (String text){
        super(text);
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }
    
}
