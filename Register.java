package E_preparationSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {
    // Temporary storage for registered users
    private static List<User> userList = new ArrayList<>();

    // Inner class to represent a user
    private static class User {
        String username;
        String password;

        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public static void registration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long! Try again.");
            return;
        }

        // Store user information in the collection
        userList.add(new User(username, password));

        // Print out the registered users (for demonstration)
        System.out.println("User Registered Successfully.");

        // Optionally, you could now insert the user into the database
        insertUserIntoDatabase(username, password);
    }

    private static void insertUserIntoDatabase(String username, String password) {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

