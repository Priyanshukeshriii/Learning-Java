package com.GUIinJava;

import javax.swing.*;
import java.util.List;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RegistrationPage extends JFrame implements ActionListener{

        public static void main(String[] args)
        {
            RegistrationPage rp = new RegistrationPage();
            rp.setVisible(true);
            rp.setSize(500, 500);
            rp.setTitle("Registartion Page");
            rp.setLocationRelativeTo(null);
            rp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        JLabel lname, laddress, lhobbies, llanguage, lgender;
        JTextField tname;
        JTextArea taddress;
        JRadioButton male, female;
        ButtonGroup bg;
        JCheckBox cricket, football, hockey, music;
        JList<String> lang;
        String all[] = {"c","cpp","java","python"};
        JButton registartion, cancel, login;
        JPanel main, jp1, jp2, jp3, jp4;

        RegistrationPage()
        {
            main = new JPanel();
            main.setLayout(new GridLayout(4,1));

            jp1 = new JPanel();
            jp1.setLayout(new GridLayout(2,2));
            lname = new JLabel("Student Name");
            tname = new JTextField(30);
            laddress = new JLabel("Address");
            taddress = new JTextArea(10, 10);
            jp1.add(lname);
            jp1.add(tname);
            jp1.add(laddress);
            jp1.add(taddress);
            main.add(jp1);

            jp2 = new JPanel(new GridLayout(1,3));
            lgender = new JLabel("Gender");
            male = new JRadioButton("Male");
            female = new JRadioButton("Female");
            bg = new ButtonGroup();
            bg.add(male);
            bg.add(female);
            jp2.add(lgender);
            jp2.add(male);
            jp2.add(female);
            main.add(jp2);

            jp3 = new JPanel(new GridLayout(1,5));
            lhobbies = new JLabel("Hobbies");
            cricket = new JCheckBox("Cricket");
            football = new JCheckBox("Football");
            hockey = new JCheckBox("Hockey");
            music = new JCheckBox("Music");
            jp3.add(lhobbies);
            jp3.add(cricket);
            jp3.add(football);
            jp3.add(hockey);
            jp3.add(music);
            main.add(jp3);

            jp4 = new JPanel(new GridLayout(2,2));
            llanguage = new JLabel("Langauge");
            lang = new JList<String>(all);
            registartion = new JButton("Registration");
            cancel = new JButton("Cancel");
            jp4.add(llanguage);
            jp4.add(lang);
            jp4.add(registartion);
            jp4.add(cancel);
            main.add(jp4);

            registartion.addActionListener(this);

            add(main);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==registartion)
            {
                String sname = tname.getText();
                String address = taddress.getText();
                String gender = "";
                if(male.isSelected())
                {
                    gender = "male";
                }
                if(female.isSelected())
                {
                    gender = "female";
                }
                System.out.println("Sname: " + sname);
                System.out.println("Address: " + address);
                System.out.println("Gender: " + gender);
                String allhobbies="";
                if(cricket.isSelected())
                {
                    allhobbies += "cricter";

                }
                if(football.isSelected())
                {
                    allhobbies += "football";

                }
                if(music.isSelected())
                {
                    allhobbies += "music";

                }
                if(hockey.isSelected())
                {
                    allhobbies += "hockey";

                }
                System.out.println("hobbies: " +allhobbies );
                List<String> indexall = lang.getSelectedValuesList();
                System.out.println("Language: " +indexall );



            }
        }
}
