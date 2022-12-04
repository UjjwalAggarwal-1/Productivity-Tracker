package core.src.Notes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author QAISER AFTAB
 */
public class Notes_Cell{
    public javax.swing.JButton jtext ;
    String title ;
    public javax.swing.JButton jText = new javax.swing.JButton();
    public Notes_Cell() {
        jtext.setContentAreaFilled(false);
        jtext.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
    }
    public Notes_Cell(String thing) {
        jtext = new javax.swing.JButton();
        this.title = thing;
        jtext.setContentAreaFilled(false);
        jtext.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
//        jText = new jButton();
//        jText = new javax.swing.JButton(thing);
        jtext.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jtext.setText(thing);
        jtext.setBounds(50,100,305,20);
        jtext.setVisible(true);
        this.jtext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtextFunction (e);
            }
        });
    }
    private void jtextFunction (java.awt.event.ActionEvent evt)
    {
        ViewNote n = new ViewNote(this.title);
        n.setVisible(true);
    }
    private void functionActionPerformed(){
        ViewNote n = new ViewNote(this.title);
        n.setVisible(true);

    }

}