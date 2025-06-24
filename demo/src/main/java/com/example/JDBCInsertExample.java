package com.example;

import java.sql.*;

public class JDBCInsertExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "Rocky@001";

        String sql = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        Object[][] data = {
            {101, "Jenny", 25, 10000},
            {102, "Jacky", 30, 20000},
            {103, "Joe", 20, 40000},
            {104, "John", 40, 80000},
            {105, "Shameer", 25, 90000}
        };

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (Object[] emp : data) {
                pstmt.setInt(1, (Integer) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setInt(3, (Integer) emp[2]);
                pstmt.setInt(4, (Integer) emp[3]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
