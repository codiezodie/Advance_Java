<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zpadd - Add Book</title>
  <style>
    /* General Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body Styling */
    body {
      font-family: Arial, sans-serif;
      color: #333;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      min-height: 100vh;
      background: linear-gradient(135deg, rgba(230, 230, 250, 0.8), rgba(255, 221, 193, 0.8)), 
                  url('https://st.depositphotos.com/2397583/2655/v/600/depositphotos_26558067-stock-illustration-pattern-for-girls-with-books.jpg');
      background-size: cover;
      background-attachment: fixed;
    }

    h1 {
      font-size: 2rem;
      color: #FF0080;
      text-decoration: underline;
      text-decoration-style: wavy;
      margin-bottom: 20px;
    }

    /* Form Styling */
    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
      width: 90%;
      max-width: 400px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    input[type="text"],
    input[type="date"] {
      width: 100%;
      padding: 10px;
      font-size: 1rem;
      border-radius: 4px;
      border: 1px solid #ddd;
    }

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
    }

    .submit-btn:hover {
      background-color: #FF4C8B;
    }
  </style>
</head>
<body>

  <h1>Zpadd - Add a New Book</h1>

  <!-- Direct Form Without JavaScript -->
  <form method="POST" action="Addbook">
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

    <button type="submit" class="submit-btn">Add Book</button>
  </form>

</body>
</html>
