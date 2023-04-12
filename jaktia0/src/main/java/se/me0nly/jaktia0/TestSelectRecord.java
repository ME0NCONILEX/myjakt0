package se.me0nly.jaktia0;

import java.sql.*;

public class TestSelectRecord {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jaktia0";
    static final String USER = "root";
    static final String PASS = "Test1234";
    static final String QUERY = "SELECT id, firstname, lastname, age, mail FROM Registration";
    public static void main(String[] args) {
        // Open a connection -- here are all records selected
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)
        ) {
            while(rs.next()){
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", First name: " + rs.getString("firstname"));
                System.out.println(", Last name: " + rs.getString("lastname") + ",  Age: " + rs.getInt("age"));

                //                System.out.print(" Age: " + rs.getInt("age"));
                System.out.print( " \n");
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
