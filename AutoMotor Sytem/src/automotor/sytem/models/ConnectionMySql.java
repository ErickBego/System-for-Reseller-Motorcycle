/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automotor.sytem.models;

import java.sql.Connection;
 
import java.sql.DriverManager;
 
import java.sql.SQLException;

/**
 *
 * @author jcodogno
 */
public class ConnectionMySql{
    
    public static boolean status = false;
             
    public static java.sql.Connection startConnection() {
        Connection connection = null;          //atributo do tipo Connection
        try{
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);
            String serverName = "192.168.1.252:3307";    
            String mydatabase ="helpdesk";       
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";         
            String password = "de4da9lu3s8";     
            connection = DriverManager.getConnection(url, username, password);
 
            if(connection != null) {
                status = true;
            }else{
                status = false;
            }
            return connection;

        }catch(ClassNotFoundException e) {  
            System.out.println("The driver specified was not found.");
            return null;
 
        }catch(SQLException e) {
            
            System.out.println("Cannot connect with the database.");
            return null;
        }
    }

    public static boolean statusConnection() {
        return status;
    }
 
    public static boolean closeConnection() {
        try{
            ConnectionMySql.startConnection().close();
            return true;
        }catch(SQLException e) {
            return false;
        }
    }
 
    public static java.sql.Connection ReiniciarConexao() {
        closeConnection();
        return ConnectionMySql.startConnection();
    }
}