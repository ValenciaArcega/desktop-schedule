package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tester extends JFrame {
    
    public Tester() {
        StackBody();
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
    }

    void StackBody() {

        background = new JPanel(){
            
            @Override public void paintComponent(Graphics var) {

                Graphics2D obj = (Graphics2D)var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(Color.darkGray);
                obj.fillRoundRect(0,0,599,599, 30,30);

                JPanel btnLogin = new JPanel();
                btnLogin.setBounds(30,30,130,40);
                btnLogin.setBackground(Color.blue);
                btnLogin.invalidate();;
                add(btnLogin);
            }
        };
        background.setBounds(0,0,600,600);
        add(background);
    }

    // Objects & Variables

    JPanel background;

} // class
