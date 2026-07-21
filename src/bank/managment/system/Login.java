package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton singIn, clear, singUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    //construtor
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

        cardTextField = new JTextField();
        cardTextField.setBounds(300,160,230,30);
        cardTextField.setFont(new Font("Aerial", Font.BOLD, 14));
        add(cardTextField);

        // configurando o campo da senha
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Aerial", Font.BOLD, 14));
        add(pinTextField);

        // configurando o botão de login
        singIn = new JButton("SIGN IN");
        singIn.setBounds(300,300,100,30);
        singIn.setBackground(Color.BLACK);
        singIn.setForeground(Color.WHITE);
        singIn.addActionListener(this);
        add(singIn);

        // configurando o botão de 'clear'
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

         // botão de SIGN UP
        singUp = new JButton("SIGN UP");
        singUp.setBounds(300,350,230,30);
        singUp.setBackground(Color.BLACK);
        singUp.setForeground(Color.WHITE);
        singUp.addActionListener(this);
        add(singUp);


        //mudando a cor da logo
        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

        //Fechar a aba no X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // setando uma string vazia ao clicar no botao de clear
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == singIn){

            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where card = '"+cardNumber+"' and pin = '"+pinNumber+"'";

            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            } catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == singUp){
            setVisible(false);
            new SignUpOne().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}