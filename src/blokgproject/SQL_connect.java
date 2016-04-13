/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokgproject;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AaikOosters
 */
public class SQL_connect {

    private static          Connection  conn = null;
    private static final    String      host                = "85.214.54.154";
    private static final    String      dbName              = "BlokGDB";
    private static final    String      username            = "BlokGUser";
    private static final    String      password            = "Zcc96e4";
    private static final    String      poort               = "3306";
    private static final    String      connectionString    = "jdbc:mysql://" + host + ":"+ poort +"/" + dbName + "?user=" + username + "&password=" + password;
    
    //returns the connection
    public static Connection getConnection() {
        
        return conn;
    }

    //checks if there is a connection
    private static boolean isConnected() {
        if (conn == null) {
            return false;
        }
        try {
            return !conn.isClosed();
        } catch (Exception e) {
            System.out.println("Connection not definable");
            System.out.println(e);
            return false;
        }
    }

    //connects to the database using the information declared above
    public static void doConnect() {
        try {
            if (isConnected()) {
                closeConnection();
            }
           
            conn = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            System.out.println("Error while connecting, " + connectionString);
            System.out.println(e);
        }
    }

    //closes the conection if alive  
    private static void closeConnection() {
        try {
            if (isConnected()) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Error while closing");
            System.out.println(e);
        }
    }
}
