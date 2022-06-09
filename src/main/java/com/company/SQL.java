package com.company;
import java.sql.*;

public class SQL {
    public static String sqlSearchForThisID(String username, String pass){
        String  jdbcURL = "jdbc:mysql://localhost:3306/logindata";
        String user="root";
        String password="12345";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            return null;
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            System.out.println(user);
            System.out.println(password);
            connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("SQL Connected");
            statement = connection.createStatement();

            String sql="select * from users";
            rs = statement.executeQuery(sql);


            while (rs.next()){
                if(rs.getString("un").equals(username) && rs.getString("pw").equals(pass)){
                    return "Successful login!";
                }
            } return "Fail";


        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void delete(String username){
        try {
        String sql = "DELETE FROM users WHERE un = ?";
        String url = "jdbc:mysql://localhost:3306/logindata";
        String user = "root";
        String password = "12345";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        pst.execute();
    } catch (Exception e) {
        e.printStackTrace();
    }}

}
