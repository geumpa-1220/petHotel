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
    </style>
</head>
<body>
<div class="container">
    <h2 id="title">Q&A -- CONTENT</h2>

        <table>
            <tr>
                <th>TITLE</th>
            </tr>
            <tr>
                <td> ${content.title} </td>
            </tr>
			
            <tr>
                <th>QUESTION</th>
				<th>${content.qtime}</th>
            </tr>
            <tr>
                <td > ${content.content} </td>
            </tr>
			
			<tr>
			    <th>ANSWER</th>
				<th>${content.atime != null ? content.atime : ''}</th>
		    </tr>
            <tr>
                <td> ${content.acontent != null ? content.acontent : 'no answer yet'} </td>
            </tr>
        </table>
    
</div>
</body>
</html>