package com.raviteja.expense.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USERNAME =
            "expense_user";

    private static final String PASSWORD =
            "expense123";

    public static Connection getConnection() {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}