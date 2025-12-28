<%-- 
    Document   : display
    Created on : 6 Nov, 2024, 5:08:31 PM
    Author     : HP
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zpadd - Library Management System</title>
  <style>
    /* General Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Main Container */
    body {
      font-family: Arial, sans-serif;
      background-color: #E6E6FA;
      color: #333;
      display: flex;
      flex-direction: column;
      align-items: center;
      min-height: 100vh;
      padding-top: 20px;
    }

    /* Header */
    h1 {
      font-size: 2rem;
      color: #FF0080;
      margin-bottom: 20px;
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
    }

    .library-container {
      max-width: 1200px;
      margin: 20px;
      display: grid;
      gap: 20px;
      grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    }

    /* Book Card Style with Outline Effect */
    .book-card {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.15), 
                  0px 4px 10px rgba(255, 0, 128, 0.1),
                  0px 10px 20px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
      cursor: pointer;
    }

    .book-card:hover {
      transform: translateY(-5px);
      box-shadow: 0px 12px 20px rgba(0, 0, 0, 0.2), 
                  0px 8px 15px rgba(255, 0, 128, 0.15),
                  0px 14px 28px rgba(0, 0, 0, 0.15);
    }

    /* Book Cover */
    .book-cover {
      width: 100%;
      height: 200px;
      background-color: #ddd;
      background-size: cover;
      background-position: center;
    }

    /* Book Details */
    .book-details {
      padding: 15px;
    }

    .book-title {
      font-size: 1.1rem;
      font-weight: bold;
      color: #333;
      margin-bottom: 5px;
      text-overflow: ellipsis;
      white-space: nowrap;
      overflow: hidden;
    }

    .book-author {
      font-size: 0.9rem;
      color: #777;
    }

    /* Interactive Button */
    .view-btn {
      display: block;
      margin-top: 15px;
      text-align: center;
      padding: 10px 0;
      color: #fff;
      background-color: #FF0080;
      border-radius: 5px;
      font-weight: bold;
      text-transform: uppercase;
      text-decoration: none;
      transition: background-color 0.3s;
    }

    .view-btn:hover {
      background-color: #F4C2C2;
    }
  </style>
</head>
<body>

  <!-- Header -->
  <h1>Zpadd - Library Management System</h1>

  <!-- Main Library Container -->
  <div class="library-container" id="libraryContainer">
    <!-- Books will be populated here -->
  </div>

  <script>
    // Sample book data
    const books = [
      { title: "The Great Gatsby", author: "F. Scott Fitzgerald", cover: "https://via.placeholder.com/200x200?text=Book+Cover" },
      { title: "To Kill a Mockingbird", author: "Harper Lee", cover: "https://via.placeholder.com/200x200?text=Book+Cover" },
      { title: "1984", author: "George Orwell", cover: "https://via.placeholder.com/200x200?text=Book+Cover" },
      { title: "Pride and Prejudice", author: "Jane Austen", cover: "https://via.placeholder.com/200x200?text=Book+Cover" },
      { title: "The Catcher in the Rye", author: "J.D. Salinger", cover: "https://via.placeholder.com/200x200?text=Book+Cover" },
      // Add more books as needed
    ];

    // Display books in the library container
    const libraryContainer = document.getElementById('libraryContainer');

    books.forEach(book => {
      // Create book card elements
      const bookCard = document.createElement('div');
      bookCard.classList.add('book-card');

      const bookCover = document.createElement('div');
      bookCover.classList.add('book-cover');
      bookCover.style.backgroundImage = `url(${book.cover})`;

      const bookDetails = document.createElement('div');
      bookDetails.classList.add('book-details');

      const bookTitle = document.createElement('h3');
      bookTitle.classList.add('book-title');
      bookTitle.innerText = book.title;

      const bookAuthor = document.createElement('p');
      bookAuthor.classList.add('book-author');
      bookAuthor.innerText = `by ${book.author}`;

      const viewBtn = document.createElement('a');
      viewBtn.classList.add('view-btn');
      viewBtn.href = "#";
      viewBtn.innerText = "View Details";

      // Assemble book card
      bookDetails.appendChild(bookTitle);
      bookDetails.appendChild(bookAuthor);
      bookDetails.appendChild(viewBtn);
      bookCard.appendChild(bookCover);
      bookCard.appendChild(bookDetails);

      // Append to library container
      libraryContainer.appendChild(bookCard);
    });
  </script>

</body>
</html>
