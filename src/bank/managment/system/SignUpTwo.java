package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpTwo extends JFrame implements ActionListener{

    JTextField panTextField,aadharTextField;
    JComboBox religionField,categoryField,incomeValues,qualiValues,OccupValues;
    JButton next;
    JRadioButton citizertrue, citizerfalse, accounttrue, accountfalse;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Campos de nome
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String[] religions = {"Hindu", "Cristianism", "Budism", "Muslim", "Other"};
        religionField = new JComboBox(religions);
        religionField.setFont(new Font("Raleway", Font.BOLD, 14));
        religionField.setBounds(300, 140, 400, 30);
        add(religionField);


        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String[] categories = {"General" ,"OBC", "SC", "ST", "Other"};
        categoryField = new JComboBox(categories);
        categoryField.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryField.setBounds(300, 190, 400, 30);
        add(categoryField);


        JLabel income = new JLabel("Income (Month):");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String[] salary = {"null", "1.000 - 2.000", "5.000 - 10.000", " > 10.000"};
        incomeValues = new JComboBox(salary);
        incomeValues.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeValues.setBounds(300,240,400,30);
        add(incomeValues);


        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 320, 200, 30);
        add(qualification);

        String[] qualis = {"Non-graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        qualiValues = new JComboBox(qualis);
        qualiValues.setFont(new Font("Raleway", Font.BOLD, 14));
        qualiValues.setBounds(300, 320, 400, 30);
        add(qualiValues);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String[] occups = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        OccupValues = new JComboBox(occups);
        OccupValues.setFont(new Font("Raleway", Font.BOLD, 14));
        OccupValues.setBounds(300, 390, 400, 30);
        add(OccupValues);


        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100, 440, 200, 30);
        add(panNumber);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);


        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumber.setBounds(100, 490, 200, 30);
        add(aadharNumber);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);



        JLabel citizer = new JLabel("Senior Citizer:");
        citizer.setFont(new Font("Raleway", Font.BOLD, 20));
        citizer.setBounds(100, 540, 200, 30);
        add(citizer);

        citizertrue = new JRadioButton("Yes");
        citizertrue.setBounds(300, 540, 100, 30);
        citizertrue.setBackground(Color.white);
        add(citizertrue);

        citizerfalse = new JRadioButton("No");
        citizerfalse.setBounds(400, 540, 100, 30);
        citizerfalse.setBackground(Color.white);
        add(citizerfalse);

        // PARA SELECIONAR APENAS UM BOTÃO
        ButtonGroup citizenButtons = new ButtonGroup();
        citizenButtons.add(citizertrue);
        citizenButtons.add(citizerfalse);



        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);

        accounttrue = new JRadioButton("Yes");
        accounttrue.setBounds(300, 590, 100, 30);
        accounttrue.setBackground(Color.white);
        add(accounttrue);

        accountfalse = new JRadioButton("No");
        accountfalse.setBounds(400, 590, 100, 30);
        accountfalse.setBackground(Color.white);
        add(accountfalse);

        // PARA SELECIONAR APENAS UM BOTÃO
        ButtonGroup accountButtons = new ButtonGroup();
        accountButtons.add(accounttrue);
        accountButtons.add(accountfalse);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        String religion = (String) religionField.getSelectedItem(); //função que extrai o texto do MENU SUSPENSO
        String category = (String) categoryField.getSelectedItem();
        String income = (String) incomeValues.getSelectedItem();
        String quali = (String) qualiValues.getSelectedItem();
        String occup = (String) OccupValues.getSelectedItem();
        String panNumber = panTextField.getText();
        String aadhar = aadharTextField.getText();


        String citizer = null;
        if (citizertrue.isSelected()) {
            citizer = "Yes";
        } else if (citizerfalse.isSelected()) {
            citizer = "No";
        }


        String existingAccount = null;
        if (accounttrue.isSelected()) {
            existingAccount = "Yes";
        } else if (accountfalse.isSelected()) {
            existingAccount = "No";
        }


        try {
            if (panNumber.isEmpty()) {
                //valindado campos vazios
                JOptionPane.showMessageDialog(null, "PAN NUMBER IS REQUIRED");
            } else {
                //fazendo a conexão com banco de dados e realizando um QUERY(DML)
                Conn c = new Conn();
                String query = "insert into signupTwo values ('"+formno+"', '" + religion + "', '" + category + "', '" + income + "', '" + quali + "', '" + occup + "', '" + panNumber + "', '" + aadhar + "', '" + citizer + "', '" + existingAccount + "');";
                c.s.executeUpdate(query);

                //Signup3 object
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("").setVisible(true);
    }
}