package E_preparationSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login1 {

    static Connection con = connection.getConnection();
    static String sql = "";

    public static boolean loginAccount(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("All fields are required!");
            return false;
        }

        sql = "SELECT password FROM users WHERE username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String actualPassword = rs.getString("password");
                    if (actualPassword.equals(password)) {
                        return true;
                    } else {
                        if (actualPassword.length() >= 2) {
                            String lastTwoChars = actualPassword.substring(actualPassword.length() - 2);
                            System.out.println("Login failed. Last 2 characters of the actual password: " + lastTwoChars);
                        } else {
                            System.out.println("Login failed. Password is too short to show the last 2 characters.");
                        }
                    }
                } else {
                    System.out.println("Login failed. Username not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred during login.");
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        try (BufferedReader sc = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter username: ");
            String username = sc.readLine();
            System.out.print("Enter password: ");
            String password = sc.readLine();

            if (loginAccount(username, password)) {
                System.out.println("Welcome!");
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
