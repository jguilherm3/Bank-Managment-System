package bank.managment.system;

import java.sql.*;

public class Conn {

    Connection c;
    public Statement s;

    public Conn(){
    //Conexão com Banco de Dados Mysql
        try {
            //1. Register the Driver (Carregando o driver do banco de dados)
            //Class.forName("com.mysql.cj.jdbc.Driver");

            //Create Connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagmentsystem", "root", "root1234");

            //Create Statement
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
