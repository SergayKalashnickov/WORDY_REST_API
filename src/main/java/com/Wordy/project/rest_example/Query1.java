package com.Wordy.project.rest_example;

import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Query1 {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/wordy";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static String queryAll(String str)  {
        StringBuilder sb = new StringBuilder();


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(str);



            while (rs.next()) {   // Move the cursor to the next row
                Map<String, Object> testmap = new HashMap<String, Object>();
                testmap.put("id", rs.getInt("id"));
                testmap.put("username", rs.getString("username"));
                testmap.put("email", rs.getString("email"));
                testmap.put("country", rs.getString("country"));
                testmap.put("password", rs.getString("password"));


                JSONObject json = new JSONObject(testmap);


                sb.append(json);

                System.out.println(json);
            }
            System.out.println(sb);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return sb.toString();

    }

}


