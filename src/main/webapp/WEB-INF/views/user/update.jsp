<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
   <h2>UPDATE</h2>

   <form action="/user/update" method="post">
     UPDATE MY Username: <input type="text"  name="username"  value="${sessionScope.username}" required /><br>
     UPDATE MY Password: <input type="password"  name="pwd"  required /><br>
      <button type="submit">UPDATE</button>
   </form>
   
  </div>

</body>
</html>