<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title></title>
    <style>
        /* 간단한 스타일링 예제 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header, footer {
            background-color: #333;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        nav {
            margin: 10px;
            text-align: center;
        }
        nav a {
            margin: 0 15px;
            color: #333;
            text-decoration: none;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <header>
        <h1>애완 호텔</h1>
    </header>

    <nav>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <a href="/">Home</a>
                <a href="/posts">Posts</a>
                <a href="/logout">Logout</a>
                <span>Hello, ${sessionScope.user.username}</span>
            </c:when>
            <c:otherwise>
                <a href="/">Home</a>
                <a href="/login">Login</a>
                <a href="/signup">Sign Up</a>
            </c:otherwise>
        </c:choose>
    </nav>
	
	

    <footer>
        <p>&copy; 2024 --- 애완 호텔 --- </p>
    </footer>
</body>
</html>