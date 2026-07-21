package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pinNumber;
    JButton back;

    public MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        setTitle("Mini Statement");

        JLabel bank = new JLabel("Calango's Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel mini = new JLabel();
        add(mini);

        JLabel totalBalance = new JLabel();
        totalBalance.setBounds(20, 400, 300, 20);
        add(totalBalance);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '1234'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card").substring(0,4) + "XXXXXXXX" + rs.getString("card").substring(12));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            int balance = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '1234'");//"+pinNumber+"
            while(rs.next()){
                mini.setText(mini.getText() +"<html>" + rs.getString("date")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount") + "<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            totalBalance.setText("Your total balance is: $"+balance);

        } catch (Exception e){
            System.out.println(e);
        }

        back = new JButton("BACK");
        back.setBounds(20, 500, 100, 25);
        back.addActionListener(this);
        add(back);


        mini.setBounds(20, 140, 400, 200);
        card.setBounds(20,80,300,20);


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
