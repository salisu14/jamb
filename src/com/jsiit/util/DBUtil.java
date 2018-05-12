/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author salisu14
 */
public class DBUtil {

    private static Connection connection;

    private DBUtil() {
    }

    public static synchronized Connection getConnection() throws DBException {
        if (connection != null) {
            return connection;
        } else {
            try {
                String dbURL = "jdbc:mysql://localhost/jambdb";
                String uname = "salisu";
                String password = "pa55w0rd";

                connection = DriverManager.getConnection(dbURL, uname, password);
                return connection;
            } catch (SQLException e) {
                throw new DBException(e.toString());
            }

        }
    }

    public static synchronized void closeConnection() throws DBException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBException(e.toString());
            } finally {
                connection = null;
            }
        }
    }
}
