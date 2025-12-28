<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zpadd - Update Book</title>
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
      background: linear-gradient(135deg, #E6E6FA, #FFDDC1);
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
      color: #FF0080;
      text-decoration: underline;
      text-decoration-style: wavy;
      margin-bottom: 20px;
      text-align: center;
      width: 100%;
    }

    /* Update Book Form Container */
    .update-book-container {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 500px;
      margin: 0 auto;
    }

    /* Form Group Styling */
    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
      color: #333;
    }

    select,
    input[type="text"],
    input[type="date"] {
      width: 100%;
      padding: 10px;
      font-size: 1rem;
      border-radius: 4px;
      border: 1px solid #ddd;
    }

    /* Submit Button */
    .submit-btn {
      width: 100%;
      padding: 10px;
      font-size: 1rem;
      font-weight: bold;
      color: #fff;
      background-color: #FF0080;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease;
      margin-top: 20px;
    }

    .submit-btn:hover {
      background-color: #FF4C8B;
    }
  </style>
</head>
<body>

  <h1>Zpadd - Update Book</h1>

  <!-- Display Success or Error Message -->
  <c:if test="${not empty successMessage}">
    <div class="success">${successMessage}</div>
  </c:if>
  <c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
  </c:if>

  <div class="update-book-container">
    <h2>Update Book Information</h2>

    <form method="POST" action="Updatebook">
      <div class="form-group">
        <label for="bookSelect">Select Book</label>
        <select id="bookSelect" name="bookSelect" required>
          <option value="" disabled selected>Select a book</option>
          ${bookOptions} <!-- Dynamically generated book options will appear here -->
        </select>
      </div>

      <div class="form-group">
        <label for="publisherName">New Publisher Name</label>
        <input type="text" id="publisherName" name="publisherName" required>
      </div>

      <div class="form-group">
        <label for="category">Category</label>
        <input type="text" id="category" name="category" required>
      </div>

      <button type="submit" class="submit-btn">Update Book</button>
    </form>
  </div>

</body>
</html>