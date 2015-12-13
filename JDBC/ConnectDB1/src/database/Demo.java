/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Demo {
    public String makeURL(){
        StringBuilder url = new StringBuilder();
        url.append("jdbc:sqlserver://ZHZT05WZOVHVO8P:1433;databasename=ConnectDB;username=sa;password=123123");
        return url.toString();
    }
    public Connection getConnection(){
        Connection connect = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(this.makeURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getConnection());
    }
}
