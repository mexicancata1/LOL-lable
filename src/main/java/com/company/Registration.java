package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration extends JFrame {


    JLabel titleL = new JLabel();
    String[] gender = {"Male","Female"};
    JCheckBox shP = new JCheckBox("Show password");
    JLabel back = new JLabel();

    JTextField nameT = new JTextField();
    JTextField lnameT = new JTextField();
    JTextField usernamet = new JTextField();
    JComboBox genderCB = new JComboBox(gender);
    JPasswordField passwordT = new JPasswordField();
    JPasswordField confirmT = new JPasswordField();
    JTextField emailT = new JTextField();
    JButton registerbtn = new JButton("Register");
    JButton resetbtn = new JButton("RESET");
    
    Registration(){

        titleL.setText("REGISTRATION");
        titleL.setForeground(Color.white);
        titleL.setFont(new Font("Stencil STD", Font.PLAIN, 40));
        titleL.setBounds(150, 10, 350, 50);


        nameT.setBorder(BorderFactory.createTitledBorder("FIRST NAME"));
        nameT.setBounds(40, 60, 280, 40);

        lnameT.setBorder(BorderFactory.createTitledBorder("LAST NAME"));
        lnameT.setBounds(40, 110, 280, 40);

        usernamet.setBorder(BorderFactory.createTitledBorder("CREATE USERNAME"));
        usernamet.setBounds(40, 160, 280, 40);

        passwordT.setBorder(BorderFactory.createTitledBorder("CREATE PASSWORD"));
        passwordT.setBounds(40, 210, 280, 40);

        confirmT.setBorder(BorderFactory.createTitledBorder("CONFIRM PASSWORD"));
        confirmT.setBounds(40, 260, 280, 40);

        emailT.setBorder(BorderFactory.createTitledBorder("E-MAIL"));
        emailT.setBounds(40, 310, 280, 40);

        genderCB.setBackground(Color.WHITE);
        genderCB.setForeground(Color.BLACK);
        genderCB.setBorder(BorderFactory.createTitledBorder("GENDER"));
        genderCB.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        genderCB.setBounds(400, 70, 150, 50);


        resetbtn.setText("Clear");
        resetbtn.setForeground(Color.black);
        resetbtn.setBackground(Color.white);
        resetbtn.setBorder(BorderFactory.createLineBorder(Color.black));
        resetbtn.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        resetbtn.setBounds(440, 140, 100, 30);


        registerbtn.setForeground(Color.black);
        registerbtn.setBackground(Color.white);
        registerbtn.setBorder(BorderFactory.createLineBorder(Color.black));
        registerbtn.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        registerbtn.setBounds(440, 190, 100, 30);


        back = new JLabel("", new ImageIcon("reglol.jpg"), JLabel.CENTER);
        back.add(titleL);
        back.add(nameT);
        back.add(passwordT);
        back.add(registerbtn);
        back.add(resetbtn);
        back.add(shP);
        back.add(genderCB);
        back.add(lnameT);
        back.add(confirmT);
        back.add(emailT);
        back.add(usernamet);
        back.setLayout(null);

        this.add(back);
        this.setSize(600, 758);
        this.setTitle("REGISTER LABEL");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        shP.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == shP)
                    if (shP.isSelected()) {
                        passwordT.setEchoChar((char) 0);
                        confirmT.setEchoChar((char) 0);

                    } else {
                        passwordT.setEchoChar('•');
                        confirmT.setEchoChar('•');
                    }
            }
        });


        resetbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernamet.setText("");
                passwordT.setText("");
                lnameT.setText("");
                confirmT.setText("");
                emailT.setText("");
                nameT.setText("");

            }
        });

        registerbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == registerbtn) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindata", "root", "12345");

                        PreparedStatement Pstatement = connection.prepareStatement("Insert into users values(?,?,?,?,?,?)");
                        Pstatement.setString(1, genderCB.getSelectedItem().toString());
                        Pstatement.setString(2, nameT.getText());
                        Pstatement.setString(3, lnameT.getText());
                        Pstatement.setString(4, usernamet.getText());
                        Pstatement.setString(5, emailT.getText());
                        Pstatement.setString(6, passwordT.getText());


                            if (passwordT.getText().equalsIgnoreCase(confirmT.getText())) {
                                Pstatement.executeUpdate();

                            } else {
                                JOptionPane.showMessageDialog(null, "Password did not match");
                            }
                            if (passwordT.getText().matches("([A-Z]|[a-z]|[0-9])+")) {

                            } else {
                                JOptionPane.showMessageDialog(null, "Password can contain numbers 0-9 and large and small letters!");
                            }
                            if (usernamet.getText().matches("([A-Z]|[a-z]|[0-9])+")) {

                            } else {
                                JOptionPane.showMessageDialog(null, "Username can contain numbers 0-9 and large and small letters!");
                            }

                            if(passwordT.getText().equalsIgnoreCase(confirmT.getText()) && passwordT.getText().matches("([A-Z]|[a-z]|[0-9])+") && usernamet.getText().matches("([A-Z]|[a-z]|[0-9])+") ) {

                                JOptionPane.showMessageDialog(null, "Registered successfully");
                            }

                            else {
                                JOptionPane.showMessageDialog(null, "Registration failed!");
                            }


                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args)
    {
        new Registration();
    }
}
