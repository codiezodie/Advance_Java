<%-- 
    Document   : a1
    Created on : 17 Nov, 2024, 2:50:35 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zpadd - Add Book</title>
  <style>
    /* Your existing styles */
  </style>
</head>
<body>
  <h1>Zpadd - Add a New Book</h1>

  <!-- Form that submits data to the servlet -->
  <form method="POST" action="a1">
    <div class="form-group">
      <label for="bookId">Book ID</label>
      <input type="text" id="bookId" name="bookId" required>
    </div>

    <div class="form-group">
      <label for="bookName">Book Name</label>
      <input type="text" id="bookName" name="bookName" required>
    </div>

    <div class="form-group">
      <label for="authorName">Author Name</label>
      <input type="text" id="authorName" name="authorName" required>
    </div>

    <div class="form-group">
      <label for="category">Category</label>
      <input type="text" id="category" name="category" required>
    </div>

    <button type="submit" class="submit-btn">Submit</button>
  </form>

</body>
</html>

