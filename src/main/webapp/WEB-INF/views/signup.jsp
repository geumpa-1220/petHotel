<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
   <h2>Sign Up</h2>
   <form action="/signup" method="post">
      Username: <input type="text"  name="username"  required /><br>
      Password: <input type="password"  name="password" required /><br>
      <button type="submit">Sign Up</button>
   </form>

</body>
</html>