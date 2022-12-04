package core.src.Notes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author QAISER AFTAB
 */
public class Notes_Cell extends JButton{
    String title ;
    public javax.swing.JButton jText = new javax.swing.JButton();
    public Notes_Cell() {
        setContentAreaFilled(true);
        setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
    }
    public Notes_Cell(String thing) {
        this.title = thing;
        setContentAreaFilled(true);
        setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
//        jText = new jButton();
//        jText = new javax.swing.JButton(thing);
        setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        setText(thing);
        setBounds(50,100,95,30);
        setVisible(true);

    }
    public void addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt){

        }
    });
//    public void addActionListener(new java.awt.event.ActionListener() {
//        public void actionPerformed(java.awt.event.ActionEvent evt ) {
//            jTextActionPerformed(evt);
//        }
//    });
    private void jTextActionPerformed (java.awt.event.ActionEvent evt) {

        ViewNote n = new ViewNote(this.title);
        n.setVisible(true);
    }

//    @Override
//    public void addActionListener(ActionListener l) {
//        actionPerformed(l);
//    }
//    private void actionPerformed (java.awt.event.ActionListener l)
//    {
//        ViewNote n= new ViewNote(this.title);
//        n.setVisible(true);
////        dispose();
//    }
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