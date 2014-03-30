/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjub.data.dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbhandler {

// DB Main Information
    private static final String URL = "jdbc:mysql://www.brackwasser.ch:3306/d01a11fa?zeroDateTimeBehavior=convertToNull [d01a11fa on Default schema]";
    private static Connection conn = null;

    /**
     * Open Database Connection
     *
     * @throws SQLException
     */
    public void openDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Verbindung zur JDBC-Datenbank herstellen.
            conn = DriverManager.getConnection("jdbc:mysql://www.brackwasser.ch:3306/d01a11fa?zeroDateTimeBehavior=convertToNull [d01a11fa on Default schema]");
        } catch (ClassNotFoundException e) {
            System.out.println("jdbc.Driver nicht gefunden");
        } catch (SQLException e) {
            System.out.println("Verbindung nicht moglich:");
            System.out.println("SQLException -> " + e.getMessage());
            System.out.println("SQLState ->  " + e.getSQLState());
            System.out.println("VendorError ->  " + e.getErrorCode());
        }
    }

    /**
     * Close DataBase
     */
    public void closeDB() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Verbindung wurde nicht geschlossen:");
            System.out.println("SQLException -> " + ex.getMessage());
            System.out.println("SQLState -> " + ex.getSQLState());
            System.out.println("VendorError -> " + ex.getErrorCode());
        }
    }

    /**
     * Null Zustand der Datenbank
     */
    public void createDatabase() {

    }

    public void deleteDatabase() {

    }

    private void getDBInformation() {

    }

}
