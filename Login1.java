package E_preparationSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Login1 {

   // private static final int NULL = 0;

    static Connection con = connection.getConnection();
    static String sql = "";

    public static boolean registration(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("All Fields Required!");
            return false;
        }

        sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println(username + ", Now You Login!");
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Username Not Available!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean loginAccount(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("All Fields Required!");
            return false;
        }

        sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Assuming there are no other conditions and it just wants to display menu
                BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
                int ch;

                while (true) {
                    try {
                        System.out.println("1) Registration");
                        System.out.println("2) Login");
                        System.out.println("5) LogOut");

                        System.out.print("Enter Choice: ");
                        ch = Integer.parseInt(sc.readLine());

                        if (ch == 1) {
                            System.out.print("Enter username: ");
                            String newUsername = sc.readLine();
                            System.out.print("Enter password: ");
                            String newPassword = sc.readLine();

                            if (registration(newUsername, newPassword)) {
                                System.out.println("MSG : Register Successfully!\n");
                            } else {
                                System.out.println("ERR : Registration Failed!\n");
                            }
                        } else if (ch == 2) {
                            System.out.print("Enter username: ");
                            String loginUsername = sc.readLine();
                            System.out.print("Enter password: ");
                            String loginPassword = sc.readLine();

                            if (loginAccount(loginUsername, loginPassword)) {
                                System.out.println("Msg: Login Successfully!\n");
                            } else {
                                System.out.println("Login Failed");
                            }
                        } else if (ch == 5) {
                            break;
                        } else {
                            System.out.println("Err : Enter Valid input!\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            } else {
                System.out.println("Login Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
