package core.src.Class;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author QAISER AFTAB
 */
public class Cell extends JButton{
    public Cell(){
        setContentAreaFilled(false);
        setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));

    }
}