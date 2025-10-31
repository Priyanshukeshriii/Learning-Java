package com.GUIinJava;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JTable extends JFrame {

    public JTable() {
            setTitle("Student Data from Database");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);
            setLocationRelativeTo(null);

            // Table model and JTable
            DefaultTableModel model = new DefaultTableModel();
            javax.swing.JTable table = new javax.swing.JTable(model);

            // Add columns (optional if you want dynamic column names)
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Email");
            model.addColumn("Phone Number");

            // Fetch data from database
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Database connection
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/gsv",  // DB name
                        "root",                                   // username
                        "password"                                // password
                );

                // Query
                String query = "SELECT * FROM student";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                // Add rows dynamically
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getInt("phone_number")
                    });
                }

                // Close connections
                rs.close();
                stmt.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
            }

            // Add table inside scroll pane
            add(new JScrollPane(table), BorderLayout.CENTER);

            setVisible(true);
        }

        // Main method
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new JTable());
        }

    public static class RegistrationPage extends JFrame implements ActionListener
    {
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
}


