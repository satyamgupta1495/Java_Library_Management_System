package com.satyamgupta;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup(){
        setBounds(600,250,606,406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);


        JLabel lusername = new JLabel("USERNAME :");
        lusername.setForeground(Color.DARK_GRAY);
        lusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lusername.setBounds(99,86,92,26);
        contentPane.add(lusername);


        JLabel lname = new JLabel("NAME :");
        lname.setForeground(Color.DARK_GRAY);
        lname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lname.setBounds(99,123,92,26);
        contentPane.add(lname);


        JLabel lpassword = new JLabel("NAME :");
        lpassword.setForeground(Color.DARK_GRAY);
        lpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lpassword.setBounds(99,160,92,26);
        contentPane.add(lpassword);


        JLabel lanswer = new JLabel("NAME :");
        lanswer.setForeground(Color.DARK_GRAY);
        lanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lanswer.setBounds(99,234,92,26);
        contentPane.add(lanswer);


        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"YOUR SCHOOL NAME ?","YOUR COLLEGE NAME ?","YOUR PETS NAME ?","YOUR CHILDHOOD NAME ?",}));
        comboBox.setBounds(256,202,148,20);
        contentPane.add(comboBox);

        JLabel securityQuestions = new JLabel("Security Questions");
        securityQuestions.setForeground(Color.DARK_GRAY);
        securityQuestions.setFont(new Font("Tahoma", Font.BOLD, 14));
        securityQuestions.setBounds(99,197,140,26);
        contentPane.add(securityQuestions);

        textField = new JTextField();
        textField.setBounds(256,91,148,20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(256,128,148,20);
        contentPane.add(textField);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(256,165,148,20);
        contentPane.add(textField);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(256,239,148,20);
        contentPane.add(textField);
        textField_3.setColumns(10);

        b1 = new JButton("CREATE");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setBounds(140,289,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        contentPane.add(b1);


        b2 = new JButton("BACK");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setBounds(300,289,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        contentPane.add(b2);


        JPanel panel = new JPanel();
        panel.setForeground(new Color(34,139,34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0),2),"CREATE YOUR ACCOUNT",TitledBorder.LEADING, TitledBorder.TOP,
                null, new Color(34,139,34)));
        panel.setBounds(31,46,476,296);
        panel.setBackground(Color.white);
        contentPane.add(panel);
    }

    public  void actionPerformed(ActionEvent ae){

        try{
            conn con = new conn();

            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?,?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(5, textField_3.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                 int i = st.executeUpdate();

                 if (i>0){
                     JOptionPane.showMessageDialog(null, "SUCCESSFULLY CREATED YOUR ACCOUNT!");
                 }

//                 kuch likhne k badd apne app khali ho jata hai
                 textField.setText("");
                 textField_1.setText("");
                 textField_3.setText("");
                 textField_3.setText("");

            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new login_user().setVisible(true);
            }

        }

        catch (Exception e){

        }
    }


}
