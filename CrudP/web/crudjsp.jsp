<%-- 
    Document   : crudjsp
    Created on : 19 Nov, 2024, 12:51:20 AM
    Author     : HP
--%>

<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>CRUD Operations</title>
</head>
<body>
    <h1>CRUD Operations</h1>

    <!-- Display All Data -->
    <h2>All Records</h2>
    <table border="1">
        <tr>
            <th>Roll No</th>
            <th>Name</th>
        </tr>
        <%
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM btech");

            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("rollNo") %></td>
            <td><%= rs.getString("name") %></td>
        </tr>
        <%
            }
            rs.close();
            st.close();
            conn.close();
        %>
    </table>

    <!-- Insert Data -->
    <h2>Insert Record</h2>
    <form method="post" action="crud.jsp?action=insert">
        Roll No: <input type="number" name="rollNo" required><br>
        Name: <input type="text" name="name" required><br>
        <input type="submit" value="Insert">
    </form>

    <!-- Update Data -->
    <h2>Update Record</h2>
    <form method="post" action="crud.jsp?action=update">
        Roll No: <input type="number" name="rollNo" required><br>
        New Name: <input type="text" name="name" required><br>
        <input type="submit" value="Update">
    </form>

    <!-- Delete Data -->
    <h2>Delete Record</h2>
    <form method="post" action="crud.jsp?action=delete">
        Roll No: <input type="number" name="rollNo" required><br>
        <input type="submit" value="Delete">
    </form>

    <%
        String action = request.getParameter("action");
        if (action != null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            if (action.equals("insert")) {
                int rollNo = Integer.parseInt(request.getParameter("rollNo"));
                String name = request.getParameter("name");

                PreparedStatement pst = conn2.prepareStatement("INSERT INTO btech (rollNo, name) VALUES (?, ?)");
                pst.setInt(1, rollNo);
                pst.setString(2, name);
                pst.executeUpdate();
                pst.close();
                out.println("Record inserted successfully!");
            } else if (action.equals("update")) {
                int rollNo = Integer.parseInt(request.getParameter("rollNo"));
                String name = request.getParameter("name");

                PreparedStatement pst = conn2.prepareStatement("UPDATE btech SET name = ? WHERE rollNo = ?");
                pst.setString(1, name);
                pst.setInt(2, rollNo);
                pst.executeUpdate();
                pst.close();
                out.println("Record updated successfully!");
            } else if (action.equals("delete")) {
                int rollNo = Integer.parseInt(request.getParameter("rollNo"));

                PreparedStatement pst = conn2.prepareStatement("DELETE FROM btech WHERE rollNo = ?");
                pst.setInt(1, rollNo);
                pst.executeUpdate();
                pst.close();
                out.println("Record deleted successfully!");
            }
            conn2.close();
        }
    %>
</body>
</html>
