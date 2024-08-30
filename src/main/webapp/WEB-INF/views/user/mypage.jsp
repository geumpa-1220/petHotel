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
        width: 80%;
        margin: 20px auto;
        padding: 10px;
        background-color: #333;
        color: white;
        text-align: center;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .container {
        width: 80%;
        margin: 20px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center; /* 가운데 정렬 */
    }
    #username {
        font-size: 24px;
        font-weight: bold;
        color: #fff;
    }
    .action-button {
        display: inline-block;
        margin: 10px;
        padding: 10px 20px;
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
    <h2 id="username">${sessionScope.username}님</h2>
</nav>

<div class="container">
    <div id="update">
        <a href="../user/update" class="action-button">UPDATE MY INFORMATION</a>
    </div>
    
    <div id="delete">
        <a href="../user/delete" class="action-button">DELETE MY ACCOUNT</a>
    </div> 
</div>

</body>
</html>
