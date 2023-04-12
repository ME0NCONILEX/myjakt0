package se.me0nly.jaktia0;

import java.sql.*;

public class TestUpdRecord {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jaktia0";
    static final String USER = "root";
    static final String PASS = "Test1234";
    static final String QUERY = "SELECT id, first, last, age FROM Registration";

    public static void main(String[] args) {
        // Open a connection and update record - ex: age = 32 WHERE id in (2)
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()
        ) {
            String sql = "UPDATE Registration " +

                    "SET age = 32 WHERE id in (2)";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", First name: " + rs.getString("first"));
                System.out.println(", Last name: " + rs.getString("last"));
                System.out.print(", Age: " + rs.getInt("age"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
