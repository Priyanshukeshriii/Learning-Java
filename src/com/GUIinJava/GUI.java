package com.GUIinJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        GUI g1 = new GUI();
        g1.setVisible(true);
        g1.setTitle("GUI");
        g1.setSize(500,500);
    }
    JLabel user,password;
    JTextField tuser,tpassword;
    JButton login , cancel;

    public GUI() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        Font ft = new Font("Arial",Font.BOLD,15);
        user = new JLabel("user");
        tuser = new JTextField(20);
        user.setFont(ft);
        password = new JLabel("Password");
        tpassword = new JTextField(20);
        login = new JButton("Login");
        cancel = new JButton("Cancel");
        add(user);
        add(tuser);
        add(password);
        add(tpassword);
        add(login);
        add(cancel);
        login.addActionListener(this);
    }
}
