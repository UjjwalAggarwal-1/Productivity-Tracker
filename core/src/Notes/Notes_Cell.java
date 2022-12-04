package core.src.Notes;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author QAISER AFTAB
 */
public class Notes_Cell extends JButton{
    public javax.swing.JButton jText = new javax.swing.JButton();
    public Notes_Cell() {
        setContentAreaFilled(false);
        setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
    }
    public Notes_Cell(String thing) {
        setContentAreaFilled(false);
        setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
//        jText = new jButton();
        jText = new javax.swing.JButton(thing);
        jText.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
//        jText.setText(thing);
        jText.setBounds(50,100,95,30);
        jText.setVisible(true);

    }
//    jText.addActionListener(new java.awt.event.ActionListener() {
//        public void actionPerformed(java.awt.event.ActionEvent evt) {
//            jTextActionPerformed(evt);
//        }
//    });
//    private void jTextActionPerformed(java.awt.event.ActionEvent evt){
//
//
//    }
   
    public void setjText (String thing)       {
        jText.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jText.setText(thing);
    }



//    private javax.swing.JButton jText;
    
}