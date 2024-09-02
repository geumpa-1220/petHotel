<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A - Content</title>
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
        font-size: 24px;
        font-weight: bold;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        background-color: #fff;
    }
    th, td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #333;
        color: white;
        font-weight: bold;
    }
    td {
        background-color: #f9f9f9;
    }
    .content-row, .answer-row {
        background-color: #fff;
    }
    .datetime {
        text-align: right;
        color: #888;
        font-size: 0.9em;
    }
    .action-buttons {
        margin-top: 20px;
        text-align: center;
    }
    .action-buttons form {
        display: inline-block;
        width: 100%;
    }
    textarea {
        width: 100%;
        height: 100px;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-family: Arial, sans-serif;
        font-size: 14px;
        margin-bottom: 15px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #333;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
        background-color: #555;
    }
    p {
        text-align: center;
        font-size: 16px;
        color: #333;
    }
</style>
</head>
<body>
<div class="container">
    <h2 id="title">Q&A -- CONTENT</h2>
    <table>
        <tr>
            <th colspan="2">TITLE</th>
        </tr>
        <tr>
            <td colspan="2">${content.title}</td>
        </tr>
        <tr>
            <th>QUESTION</th>
            <td class="datetime">${content.qtime}</td>
        </tr>
        <tr class="content-row">
            <td colspan="2">${content.content}</td>
        </tr>
        <tr>
            <th>ANSWER</th>
            <td class="datetime">${content.atime != null ? content.atime : ''}</td>
        </tr>
        <tr class="answer-row">
            <td colspan="2">${content.acontent != null ? content.acontent : 'no answer yet'}</td>
        </tr>
    </table>
    
    <c:choose>
        <c:when test="${ content.acontent == null }">
            <div class="action-buttons">
                <form action="../answer/write" method="post">
                    <input type="hidden" name="qid" value="${ content.id }">
                    <textarea name="content" required></textarea>
                    <input type="submit" value="WRITE">
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <p>Answer is already provided. You cannot modify the answer.</p>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
