package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;



public class LoginFrame2 extends JFrame
{
    JTextField txtusername;
    JPasswordField txtpassword;

    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;

    JButton link1;
    JButton link2;
    JButton link3;

    JCheckBox showPassword;

    JLabel background;


    ImageIcon img = new ImageIcon("FB.png");
    ImageIcon img2 = new ImageIcon("ig.png");
    ImageIcon img3 = new ImageIcon("yt5.png");


    LoginFrame2()
    {
        txtpassword = new JPasswordField();
        txtpassword.setBorder(BorderFactory.createTitledBorder("PASSWORD"));
        txtpassword.setBounds(57, 260, 290, 53);

        txtusername = new JTextField();
        txtusername.setBorder(BorderFactory.createTitledBorder("USERNAME"));
        txtusername.setBounds(57, 197, 290, 53);

        btn1 = new JButton();
        btn1.setText("Clear");
        btn1.setForeground(Color.white);
        btn1.setBackground(Color.black);
        btn1.setBorder(BorderFactory.createLineBorder(Color.black));
        btn1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        btn1.setBounds(250, 400, 100, 35);

        btn2 = new JButton();
        btn2.setText("➤");
        btn2.setForeground(Color.white);
        btn2.setBackground(Color.black);
        btn2.setBorder(BorderFactory.createLineBorder(Color.black));
        btn2.setBounds(170, 492, 65, 65);

        btn3 = new JButton();
        btn3.setText("CANT SIGN IN? CREATE ACCOUNT");
        btn3.setForeground(Color.RED);
        btn3.setBackground(Color.white);
        btn3.setBorder(BorderFactory.createLineBorder(Color.white));
        btn3.setBounds(80, 590, 250, 70);

        btn4 = new JButton();
        btn4.setText("Delete User?");
        btn4.setForeground(Color.black);
        btn4.setBackground(Color.white);
        btn4.setBorder(BorderFactory.createLineBorder(Color.white));
        btn4.setBounds(150, 560, 100, 40);


        showPassword = new JCheckBox();
        showPassword.setText("Show password");
        showPassword.setForeground(Color.BLACK);
        showPassword.setBackground(Color.white);
        showPassword.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        showPassword.setBounds(57, 367, 150, 30);

        link1 = new JButton();
        link1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        link1.setBounds(57, 330, 97, 35);
        link1.setIcon(img);

        link2 = new JButton();
        link2.setBounds(155, 330, 97, 35);
        link2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        link2.setIcon(img2);

        link3 = new JButton();
        link3.setBounds(253, 330, 97, 35);
        link3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        link3.setIcon(img3);


        background = new JLabel("", new ImageIcon("lol2.png"), JLabel.CENTER);
        background.add(txtusername);
        background.add(txtpassword);
        background.add(btn1);
        background.add(btn2);
        background.add(btn3);
        background.add(btn4);
        background.add(showPassword);
        background.add(link1);
        background.add(link2);
        background.add(link3);
        background.setLayout(null);

        this.add(background);
        this.setSize(1300, 758);
        this.setTitle("LOGIN LABEL");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtpassword.setText("");
                txtusername.setText("");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (SQL.sqlSearchForThisID(txtusername.getText(), txtpassword.getText()) == "Successful login!") {
                    JOptionPane.showMessageDialog(null, SQL.sqlSearchForThisID(txtusername.getText(), txtpassword.getText()));
                    SnakeGame.main(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }

        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registration registration = new Registration();
            }
        });

        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SQL.delete("mexicancata1");
                JOptionPane.showMessageDialog(null, "User deleted successfully");

            }
        });

        link1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/leagueoflegends/").toURI());
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.instagram.com/leagueoflegends/?hl=bg").toURI());
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.youtube.com/channel/UC2t5bjwHdUX4vM2g8TRDq5g").toURI());
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });

        showPassword.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == showPassword)
                    if (showPassword.isSelected()) {
                        txtpassword.setEchoChar((char) 0);

                    } else {
                        txtpassword.setEchoChar('•');
                    }
            }
        });


    }

    public static void main(String s[]) {
       LoginFrame2 gui = new LoginFrame2();
    }

}
