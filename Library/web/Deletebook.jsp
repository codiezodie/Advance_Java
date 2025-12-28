<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zpadd - Delete Book</title>
  <style>
    /* General Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body Styling with Gradient Background */
    body {
      font-family: Arial, sans-serif;
      background: linear-gradient(135deg, #FFE5E5, #FFF1C1);
      color: #333;
      display: flex;
      justify-content: center;
      align-items: flex-start;
      flex-direction: column;
      min-height: 100vh;
      padding: 40px;
      background: linear-gradient(135deg, rgba(230, 230, 250, 0.8), rgba(255, 221, 193, 0.8)), 
                  url('https://st.depositphotos.com/2397583/2655/v/600/depositphotos_26558067-stock-illustration-pattern-for-girls-with-books.jpg');
    }

    /* Header Styling */
    h1 {
      font-size: 2rem;
      color: #FF4C4C;
      text-decoration: underline;
      text-decoration-style: wavy;
      margin-bottom: 20px;
      text-align: center;
      width: 100%;
    }

    /* Delete Book Form Container */
    .delete-book-container {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 500px;
      margin: 0 auto;
      text-align: center;
    }

    /* Warning Message */
    .warning-message {
      color: #FF4C4C;
      font-weight: bold;
      margin-bottom: 15px;
    }

    /* Form Group Styling */
    .form-group {
      margin-bottom: 15px;
      text-align: left;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
      color: #333;
    }

    select {
      width: 100%;
      padding: 10px;
      font-size: 1rem;
      border-radius: 4px;
      border: 1px solid #ddd;
    }

    /* Delete Button */
    .delete-btn {
      width: 100%;
      padding: 10px;
      font-size: 1rem;
      font-weight: bold;
      color: #fff;
      background-color: #FF4C4C;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease;
      margin-top: 20px;
    }

    .delete-btn:hover {
      background-color: #FF0000;
    }
  </style>
</head>
<body>

  <!-- Header for App Name -->
  <h1>Zpadd - Delete Book</h1>

  <!-- Delete Book Form Container -->
  <div class="delete-book-container">
    <!-- Warning Message -->
    <p class="warning-message">⚠️ Warning: Deleting a book cannot be undone.</p>

    <form method="POST" action="Deletebook">
      <!-- Dropdown for Selecting Book to Delete -->
      <div class="form-group">
        <label for="bookSelect">Select Book to Delete</label>
        <select id="bookSelect" name="bookSelect" required>
    <option value="" disabled selected>Select a book</option>

    <!-- Static Book Options -->
    <option value="100">The Great Gatsby by F. Scott Fitzgerald - Romance/Drama</option>
    <option value="101">To Kill a Mockingbird by Harper Lee - Thriller</option>
    <option value="102">1984 by George Orwell - Horror</option>
    <option value="103">Pride and Prejudice by Jane Austen - Novel of manners</option>
    <option value="104">The Catcher in the Rye by J.D. Salinger - Novel</option>
</select>
      </div>

      <!-- Delete Button -->
      <button type="submit" class="delete-btn">Delete Book</button>
    </form>
  </div>

</body>
</html>
