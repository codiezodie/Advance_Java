/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.Scanner;
@WebServlet("/crudjsp")
public class crudjsp {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Read All Data");
                System.out.println("2. Insert Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline left-over
                
                switch (choice) {
                    case 1:
                        // Read Data
                        readData(conn);
                        break;
                    case 2:
                        // Insert Data
                        insertData(conn, sc);
                        break;
                    case 3:
                        // Update Data
                        updateData(conn, sc);
                        break;
                    case 4:
                        // Delete Data
                        deleteData(conn, sc);
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        return; // Gracefully exit the program
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } finally {
            // Close resources
            closeResources(null, null, conn);
        }
    }

    // Read Data
    private static void readData(Connection conn) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM btech");

            while (rs.next()) {
                int rollNo = rs.getInt("rollNo");
                String name = rs.getString("name");
                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
            }
        } finally {
            closeResources(rs, st, null);
        }
    }

    // Insert Data
    private static void insertData(Connection conn, Scanner sc) throws SQLException {
        PreparedStatement pst = null;
        try {
            System.out.print("Enter roll number: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            String query = "INSERT INTO btech (rollNo, name) VALUES (?, ?)";
            pst = conn.prepareStatement(query);
            pst.setInt(1, rollNo);
            pst.setString(2, name);
            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        } finally {
            closeResources(null, pst, null);
        }
    }

    // Update Data
    private static void updateData(Connection conn, Scanner sc) throws SQLException {
        PreparedStatement pst = null;
        try {
            System.out.print("Enter roll number to update: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            String query = "UPDATE btech SET name = ? WHERE rollNo = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, rollNo);
            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        } finally {
            closeResources(null, pst, null);
        }
    }

    // Delete Data
    private static void deleteData(Connection conn, Scanner sc) throws SQLException {
        PreparedStatement pst = null;
        try {
            System.out.print("Enter roll number to delete: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            String query = "DELETE FROM btech WHERE rollNo = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, rollNo);
            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        } finally {
            closeResources(null, pst, null);
        }
    }

    // Close resources
    private static void closeResources(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}