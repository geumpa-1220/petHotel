<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .navi {
        width: 100%;
        padding: 20px;
        background-color: #333;
        color: white;
        text-align: center;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .container {
        width: 80%;
        margin: 40px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        border-radius: 10px;
    }
    #username {
        font-size: 24px;
        font-weight: bold;
        color: #fff;
    }
    .action-button {
        display: inline-block;
        margin: 20px 10px;
        padding: 15px 30px;
        background-color: #333;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s ease, color 0.3s ease;
    }
    .action-button:hover {
        background-color: #555;
        color: white;
    }
</style>
</head>
<body>

<nav class="navi">
    <h2 id="username">관리자:${sessionScope.username}</h2>
</nav>

<div class="container">
    <a href="../admin/update" class="action-button">UPDATE MY INFORMATION</a>
    <a href="../admin/delete" class="action-button">DELETE MY ACCOUNT</a>
</div>

</body>
</html>
