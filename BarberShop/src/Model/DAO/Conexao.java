/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 *
 * @author daniel.frey
 */
public class Conexao {

    public Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/barbershop", "root", "");
        return conexao;
    }
}

//modelo para conectar e imprimir os dados da tabela

//    public static void main(String args[]) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/barbershop", "root", "");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from usuario");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//            }
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
