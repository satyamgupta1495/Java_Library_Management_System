package com.satyamgupta;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


//extends thread ya implement runnable use krte hai for threading
public class loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;

    public static void main(String[] args) {
        new loading().setVisible(true);
    }

    public void setUploading(){
        th.start();
    }

    public void run(){
        try{
            for (int i = 0; i< 200; i++){
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if(v<m){
                    progressBar.setValue(progressBar.getValue()-1);
                }
                else{
                    i= 200;
                    setVisible(false);
//                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public loading(){
        super("LOADING.....");
        th = new Thread((Runnable) this);

        setBounds(600, 300,600,400);
        contentPane = new JPanel();
        contentPane.setLayout(null);

        JLabel labelt1 = new JLabel("Digital Library v2.0");
        labelt1.setForeground(new Color(72,209,204));
        labelt1.setFont(new Font("Tahu", Font.BOLD, 35));
        labelt1.setBounds(130,45,500,35);
        contentPane.add(labelt1);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahu", Font.BOLD, 35));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130,135,300,25);
        contentPane.add(progressBar);

        JLabel label2 = new JLabel("PLEASE WAIT.....");
        label2.setFont(new Font("Joker gothic", Font.BOLD, 35));
        label2.setForeground(new Color(160,82,45));
        label2.setBounds(200,165,150,20);
        contentPane.add(label2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0,0,590,390);
        contentPane.add(panel);

        setUploading();






    }
}
