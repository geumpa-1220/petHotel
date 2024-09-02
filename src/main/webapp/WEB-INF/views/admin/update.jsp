<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin Information</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        width: 80%;
        margin: 40px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: center;
    }
    h2 {
        margin-bottom: 20px;
        color: #333;
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    input[type="text"], input[type="password"] {
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    button[type="submit"] {
        padding: 12px 20px;
        background-color: #333;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button[type="submit"]:hover {
        background-color: #555;
    }
</style>
</head>
<body>
<div class="container">
   <h2>UPDATE MY INFORMATION</h2>

   <form action="/admin/update" method="post">
   
     <label for="username">UPDATE MY Username:</label>
     <input type="text" id="username" name="username" value="${sessionScope.username}" required /><br>

     <label for="pwd">UPDATE MY Password:</label>
     <input type="password" id="pwd" name="pwd" required /><br>

     <button type="submit">UPDATE</button>
   </form>
</div>
</body>
</html>
