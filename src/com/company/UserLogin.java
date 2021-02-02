package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JPasswordField passwordField;
    private JTextField textField;

    public static void main(String[] args) {
        System.out.println("This is user login");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUserLabel = new JLabel("Username");
        lblUserLabel.setForeground(Color.BLACK);
        lblUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblUserLabel.setBounds(250 , 166, 196, 52);
        contentPane.add(lblUserLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 46));
        textField.setBounds(480, 166, 281, 60);
        textField.setColumns(1);
        contentPane.add(textField);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblPassword.setBounds(250, 280, 196, 52);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 46));
        passwordField.setBounds(480, 280, 281, 60);
        passwordField.setColumns(1);
        contentPane.add(passwordField);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton.setBounds(545,392,162,73);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                System.out.println("Button is pressed : " + userName + " : " + password);


                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/titanicmanifest", "root", "ah447Sladl!");

                    PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("select name, password from student where name=? and password = ?");


                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, password);


                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        System.out.println("Logging IN");
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        System.out.println("Not allowed to login");
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }


                } catch (Exception ex) {
                    System.out.println(ex);
                } finally {

                }
            }


        });

        contentPane.add(btnNewButton);

    }
}
