<%-- 
    Document   : keyboard
    Created on : 12 Oct, 2024, 7:33:33 PM
    Author     : HP
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual Keyboard</title>
    <style>
        /* Keyboard container */
        .keyboard {
            width: 600px;
            margin: 50px auto;
            text-align: center;
        }

        /* Styling keys */
        .key-row {
            display: flex;
            justify-content: center;
            margin-bottom: 10px;
        }

        .key {
            width: 50px;
            height: 50px;
            margin: 5px;
            background-color: #3498db;
            color: white;
            font-size: 18px;
            line-height: 50px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .key:hover {
            background-color: #2980b9;
        }

        /* Special key styles (like enter, space) */
        .key.wide {
            width: 100px;
        }

        .key.space {
            width: 250px;
        }

        /* Input box */
        .input-box {
            width: 600px;
            height: 50px;
            margin-bottom: 20px;
            text-align: left;
            font-size: 20px;
            padding: 10px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }

        /* Body styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>

<div class="keyboard">
    <!-- Input field -->
    <input type="text" class="input-box" id="inputBox" readonly />

    <!-- Keyboard rows -->
    <div class="key-row">
        <div class="key" onclick="insertText('1')">1</div>
        <div class="key" onclick="insertText('2')">2</div>
        <div class="key" onclick="insertText('3')">3</div>
        <div class="key" onclick="insertText('4')">4</div>
        <div class="key" onclick="insertText('5')">5</div>
        <div class="key" onclick="insertText('6')">6</div>
        <div class="key" onclick="insertText('7')">7</div>
        <div class="key" onclick="insertText('8')">8</div>
        <div class="key" onclick="insertText('9')">9</div>
        <div class="key" onclick="insertText('0')">0</div>
    </div>
    <div class="key-row">
        <div class="key" onclick="insertText('Q')">Q</div>
        <div class="key" onclick="insertText('W')">W</div>
        <div class="key" onclick="insertText('E')">E</div>
        <div class="key" onclick="insertText('R')">R</div>
        <div class="key" onclick="insertText('T')">T</div>
        <div class="key" onclick="insertText('Y')">Y</div>
        <div class="key" onclick="insertText('U')">U</div>
        <div class="key" onclick="insertText('I')">I</div>
        <div class="key" onclick="insertText('O')">O</div>
        <div class="key" onclick="insertText('P')">P</div>
    </div>
    <div class="key-row">
        <div class="key" onclick="insertText('A')">A</div>
        <div class="key" onclick="insertText('S')">S</div>
        <div class="key" onclick="insertText('D')">D</div>
        <div class="key" onclick="insertText('F')">F</div>
        <div class="key" onclick="insertText('G')">G</div>
        <div class="key" onclick="insertText('H')">H</div>
        <div class="key" onclick="insertText('J')">J</div>
        <div class="key" onclick="insertText('K')">K</div>
        <div class="key" onclick="insertText('L')">L</div>
        <div class="key wide" onclick="insertText('\n')">Enter</div>
    </div>
    <div class="key-row">
        <div class="key" onclick="insertText('Z')">Z</div>
        <div class="key" onclick="insertText('X')">X</div>
        <div class="key" onclick="insertText('C')">C</div>
        <div class="key" onclick="insertText('V')">V</div>
        <div class="key" onclick="insertText('B')">B</div>
        <div class="key" onclick="insertText('N')">N</div>
        <div class="key" onclick="insertText('M')">M</div>
        <div class="key" onclick="deleteText()">Del</div>
        <div class="key wide" onclick="insertText(' ')">Space</div>
    </div>
</div>

<script>
    // Function to insert text into the input box
    function insertText(val) {
        document.getElementById('inputBox').value += val;
    }

    // Function to delete text from the input box
    function deleteText() {
        var inputBox = document.getElementById('inputBox');
        inputBox.value = inputBox.value.slice(0, -1);
    }
</script>

</body>
</html>
