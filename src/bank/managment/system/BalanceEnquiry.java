package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;

    public BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
            }

        JLabel text = new JLabel("Your Current Account balance is $"+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
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
        new BalanceEnquiry("");
    }
}
