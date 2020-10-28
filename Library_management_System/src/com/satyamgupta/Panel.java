package com.satyamgupta;



import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Panel extends JFrame{



    public Panel(){
        JFrame frame = new JFrame("THIS IS A PANEL");
        JLabel label = new JLabel("THIS IS A LABEL");
        JButton b1 = new JButton("BUTTON 1");
        JButton b2 = new JButton("BUTTON 2");
        JButton b3 = new JButton("BUTTON 3");

        JPanel panel = new JPanel();

        panel.add(label);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(label);

        panel.setBackground(Color.blue);

        frame.add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Panel p = new Panel();
    }

}
