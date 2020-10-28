package com.satyamgupta;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionListener;



public class Forgot extends  JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1, b2,b3;

    public static void main(String[] args) {
        new Forgot().setVisible(true);
    }

    public Forgot(){
        setBounds(500,200,650,500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("USERNAME");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(109,83,87,29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("USERNAME");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(109,122,75,21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("USERNAME");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(109,154,87156,27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("USERNAME");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(109,192,104,21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("USERNAME");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(109,224,104,21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setBounds(256,165,148,20);
        t1.setForeground(new Color(105,105,105));
        t1.setFont(new Font("Tahoma", Font.BOLD, 14));
        t1.setEditable(false);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setBounds(277,123,139,20);
        t2.setForeground(new Color(165,42,42));
        t2.setFont(new Font("Tahoma", Font.BOLD, 14));
        t2.setEditable(false);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setBounds(277,161,221,20);
        t3.setForeground(new Color(72,61,139));
        t3.setFont(new Font("Tahoma", Font.BOLD, 14));
        t3.setEditable(false);
        contentPane.add(t3);
        t3.setColumns(10);

        t4 = new JTextField();
        t4.setBounds(277,193,139,20);
        t4.setForeground(new Color(205,92,92));
        t4.setFont(new Font("Tahoma", Font.BOLD, 14));
        t4.setEditable(false);
        contentPane.add(t4);
        t4.setColumns(10);

        t5 = new JTextField();
        t5.setBounds(277,193,139,20);
        t5.setForeground(new Color(50,205,50));
        t5.setFont(new Font("Tahoma", Font.BOLD, 14));
        t5.setEditable(false);
        contentPane.add(t5);
        t5.setColumns(10);


        b1 = new JButton("SEARCH");
        b1.addActionListener(this);
        b1.setBounds(420,83,80,29);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(b1);

        b2 = new JButton("RETRIEVE");
        b2.addActionListener(this);
        b2.setBounds(426,188,85,29);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(b2);

        b3 = new JButton("BACK");
        b3.addActionListener(this);
        b3.setBounds(233,270,101,29);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(139,69,19),2),"FORGET-PANEL",TitledBorder.LEADING, TitledBorder.TOP,
                null, new Color(178,34,34)));
        panel.setBounds(47,45,508,281);
        panel.setBackground(Color.white);
        contentPane.add(panel);
    }


    public  void actionPerformed(ActionEvent ae){

        try {
            conn con = new conn();

            if (ae.getSource() == b1) {
                String sql = "select * from account where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t1.setText(rs.getString("name"));
                    t1.setText(rs.getString("sec_q"));
                }
            }

            if (ae.getSource() == b2) {
                String sql = "select * from account where sec_ans=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }

            }

            if (ae.getSource() == b3) {
                this.setVisible(false);
                new login_user().setVisible(true);
            }

        }

        catch (Exception e){

        }
    }


}
