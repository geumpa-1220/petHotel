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
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #333;
        color: white;
    }
    td {
        background-color: #f9f9f9;
    }
    .content-row {
        background-color: #fff;
    }
    .answer-row {
        background-color: #f1f1f1;
    }
    .datetime {
        text-align: right;
        font-size: 0.9em;
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
            <th  class="datetime">${content.qtime}</th>
        </tr>
        <tr class="content-row">
            <td colspan="2">${content.content}</td>
        </tr>
        <tr>
            <th>ANSWER</th>
            <th class="datetime">${content.atime != null ? content.atime : ''}</th>
        </tr>
        <tr class="answer-row">
            <td colspan="2">${content.acontent != null ? content.acontent : 'no answer yet'}</td>
        </tr>
    </table>
</div>
</body>
</html>
