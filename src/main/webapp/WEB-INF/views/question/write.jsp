<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A - Write Question</title>
<style>
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
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    #title {
        text-align: center;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #333;
        color: white;
    }
    input[type="text"],
    textarea {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    textarea {
        height: 150px;
    }
    input[type="submit"] {
        padding: 12px 20px;
        background-color: #333;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        box-sizing: border-box;
    }
    input[type="submit"]:hover {
        background-color: #555;
    }
</style>
</head>
<body>
<div class="container">
    <h2 id="title">Q&A -- QUESTION</h2>
    <form action="/writeOk" method="post">
        <table>
            <tr>
                <th>TITLE</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="title" required>
                </td>
            </tr>
            <tr>
                <th>CONTENT</th>
            </tr>
            <tr>
                <td>
                    <textarea name="content" required></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="WRITE">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>