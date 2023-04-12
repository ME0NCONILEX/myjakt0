package se.me0nly.jaktia0;

import java.sql.*;

public class TestDelRecord {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jaktia0";
    static final String USER = "root";
    static final String PASS = "Test1234";
    static final String QUERY = "SELECT id, first, last, age FROM Registration";

    public static void main(String[] args) {
        // Open a connection -- delete all records (id > 0) or one by one where id = 1, or id = 2 ...
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM Registration " +
                  "WHERE id > 0" +
        //        "WHERE id = 1" +  // for one by one reg (1 or 2 or...)
                    "";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First name: " + rs.getString("first"));
                System.out.println(", Last name: " + rs.getString("last"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
