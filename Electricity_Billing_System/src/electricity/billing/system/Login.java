package electricity.billing.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField userText,passwordText;
    Choice loginChoice;


    JButton loginbutton,cancelButton,signupButton;

    Login(){
        super("Login");
        getContentPane().setBackground(Color.BLUE);
        JLabel username = new JLabel("USERNAME: ");
        add(username);
        username.setBounds(300,60,100,20);

        JTextField userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);


        JLabel password = new JLabel("PASSWORD: ");
        password.setBounds(300,100,100,20);
        add(password);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        JLabel login_As = new JLabel("LOGIN_AS: ");
        login_As .setBounds(300,140,100,20);
        add(login_As);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);

        loginbutton =new JButton("Login");
        loginbutton.setBounds(330,180,100,20);
        loginbutton.addActionListener(this);
        add(loginbutton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("SignUp");
        signupButton.setBounds(400,215,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne= new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profileLable = new JLabel(fprofileOne);
        profileLable.setBounds(5,5,250,250);
        add(profileLable);

        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==loginbutton){
            String susername = userText.getText();
            String spassword = passwordText.getText();
            String suser = loginChoice.getSelectedItem();

            try{
                database d = new database();
                String queryy = "select * from signup where username = '"+susername+"' and password = '"+spassword+"' and  usertype = '"+suser+"'";
                ResultSet resultSet = d.statement.executeQuery(queryy);

                if(resultSet.next()){
                    setVisible(false);
                    //new main_class(suser);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()==cancelButton){
            setVisible(false);

        }else if(e.getSource()==signupButton){
            setVisible(false);
            new signup();
        }
    }
    public static void main(String[] args) {

        new Login();
    }
}
