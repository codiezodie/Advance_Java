<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zpadd - Display Books</title>
</head>
<body>
  <h1>Books in the Library</h1>

  <table border="1">
    <tr>
      <th>Book ID</th>
      <th>Book Name</th>
      <th>Author Name</th>
      <th>Category</th>
    </tr>

    <%
      // Database connection variables
      String dbURL = "jdbc:mysql://localhost:3306/library";
      String dbUser = "root";
      String dbPass = "";
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
        // Connect to the database
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // SQL query to select all books
        String sql = "SELECT * FROM t1";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        // Loop through the result set and display the book data
        while (rs.next()) {
          String bookId = rs.getString("bookId");
          String bookName = rs.getString("bookName");
          String authorName = rs.getString("authorName");
          String category = rs.getString("category");
    %>
    <tr>
      <td><%= bookId %></td>
      <td><%= bookName %></td>
      <td><%= authorName %></td>
      <td><%= category %></td>
    </tr>
    <%
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        // Close the database resources
        try {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
          if (conn != null) conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    %>

  </table>

</body>
</html>
