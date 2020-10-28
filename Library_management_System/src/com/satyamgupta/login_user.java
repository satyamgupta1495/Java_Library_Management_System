package com.satyamgupta;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class login_user extends JFrame implements ActionListener {

        private JPanel panel;
        private JTextField textField;
        private JPasswordField passwordField;
        private JButton b1, b2,b3;

        public login_user(){

            setLayout(null);

            setBackground(new Color(169,169,169));
            setBounds(600,300,600,300);

            panel = new JPanel();
            panel.setBackground(new Color(176,224,230));
            setContentPane(panel);
            panel.setLayout(null);

            JLabel l1 = new JLabel("USERNAME : ");
            l1.setBounds(124,124,95,24);
            panel.add(l1);

            JLabel l2 = new JLabel("PASSWORD : ");
            l2.setBounds(124,124,95,24);
            panel.add(l2);


            textField = new JTextField();
            textField.setBounds(210,93,157,20);
            panel.add(textField);

            passwordField = new JPasswordField();
            passwordField.setBounds(210,93,157,20);
            panel.add(passwordField);

            b1 = new JButton("LOGIN");
            b1.addActionListener(this);

            b1.setForeground(new Color(139,69,19));
            b1.setBackground(new Color(250,250,210));
            b1.setBounds(149,181,113,39);
            panel.add(b1);

            b2 = new JButton("LOGIN");
            b2.addActionListener(this);

            b2.setForeground(new Color(139,69,19));
            b2.setBackground(new Color(255,235,205));
            b2.setBounds(289,181,113,39);
            panel.add(b2);

            b3 = new JButton("LOGIN");
            b3.addActionListener(this);

            b3.setForeground(new Color(205,92,92));
            b3.setBackground(new Color(253,245,230));
            b3.setBounds(199,231,179,39);
            panel.add(b3);

            JLabel l5 = new JLabel("FORGOT PASSWORD?");
            l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
            l5.setForeground(new Color(255,0,0));
            l5.setBounds(70,240,130,20);
            panel.add(l5);

            JPanel panel2 = new JPanel();
            panel2.setBackground(new Color(176,224,230));
            panel2.setBounds(24,42,434,263);
            panel.add(panel2);


        }



        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1);
            {
                Boolean status = false;
                try {
                    conn con = new conn();
                    String sq1 = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sq1);

//                        setString replaces the "?" with the username string
                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

//                        resultset data match krta hai databae se row by row jump krta hai
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new loading().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "INVALID LOGIN");
                    }

                } catch (Exception e2) {
                    e2.printStackTrade();
                }
            }
                if (ae.getSource() == b2) {
                    setVisible(false);
                    Signup su = new Signup();
                    su.setVisible(true);
                }
                if (ae.getSource() == b3) {
                    setVisible(false);
                    Forgot forgot = new Forgot();
                    forgot.setVisible(true);
                }
            }

        }
    }






