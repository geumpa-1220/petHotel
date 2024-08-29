<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
<style>
    /* 기본 스타일은 default.jsp의 스타일과 일관성 있게 유지 */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        width: 80%;
        margin: 20px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 1);
    }
    form {
        max-width: 400px;
        margin: 0 auto;
    }
    form input[type="text"],
    form input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    form button {
        width: 100%;
        padding: 10px;
        background-color: #333;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    form button:hover {
        background-color: #555;
    }
    .error {
        color: red;
        margin-bottom: 10px;
    }
</style>
</head>
<body>
<div class="container">
   <h2>Login</h2>
   
  
   
   <form action="/user/login" method="post">
      Username: <input type="text"  name="username"  value="${userdto.username}" required /><br>
      Password: <input type="password"  name="pwd"  value="${userdto.pwd}" required /><br>
      <button type="submit">Login</button>
   </form>
   
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
   </c:if>
   
</div>

</body>
</html>