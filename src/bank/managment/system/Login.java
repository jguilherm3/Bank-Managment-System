package bank.managment.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        //java.net.URL imageWay = getClass().getResource("/icons/img.png");

        //Buscando a logo, carregando e mostrando.
        ImageIcon firstLoad = new ImageIcon(ClassLoader.getSystemResource("icons/img.png"));
        Image secondLoad = firstLoad.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon thirdLoad = new ImageIcon(secondLoad);
        JLabel label = new JLabel(thirdLoad);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to the G-Bank");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200,40,400,40);
        add(text);

        // configurando o campo do cartão de ID
        JLabel cardNumber = new JLabel("Card No.");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNumber.setBounds(120,150,150,40);
        add(cardNumber);

        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(300,160,230,30);
        add(cardTextField);

        // configurando o campo da senha
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);

        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        // configurando o botão de login
        JButton login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        // configurando o botão de 'clear'
        JButton clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);

         // botão de SIGN UP
        JButton singUp = new JButton("SIGN UP");
        singUp.setBounds(360,350,100,30);
        singUp.setBackground(Color.BLACK);
        singUp.setForeground(Color.WHITE);
        add(singUp);


        //mudando a cor da logo
        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

        //Fechar a aba no X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Login();
    }
}