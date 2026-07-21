package bank.managment.system;
import javax.swing.*;
import javax.xml.transform.TransformerConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    JButton withdraw100, withdraw500, withdraw1000, withdraw2000, withdraw5000, withdraw10000, exit;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        //o texto agora virá sobre a imagem
        image.add(text);

        withdraw100 = new JButton("$100");
        withdraw100.setBounds(170,415,150,30);
        withdraw100.addActionListener(this);
        image.add(withdraw100);

        withdraw500 = new JButton("$500");
        withdraw500.setBounds(355,415,150,30);
        withdraw500.addActionListener(this);
        image.add(withdraw500);

        withdraw1000 = new JButton("$1000");
        withdraw1000.setBounds(170,450,150,30);
        withdraw1000.addActionListener(this);
        image.add(withdraw1000);

        withdraw2000 = new JButton("$2000");
        withdraw2000.setBounds(355,450,150,30);
        withdraw2000.addActionListener(this);
        image.add(withdraw2000);

        withdraw5000 = new JButton("$5000");
        withdraw5000.setBounds(170,485,150,30);
        withdraw5000.addActionListener(this);
        image.add(withdraw5000);

        withdraw10000 = new JButton("$10000");
        withdraw10000.setBounds(355,485,150,30);
        withdraw10000.addActionListener(this);
        image.add(withdraw10000);

        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        // retira as opções de minimizar, maximizar e fechar. Fechará apenas clicando em 'exit'
        setUndecorated(true);
        setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(1); // remove the $

            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuficient Balance");
                    return;
                }


                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$"+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
