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
     #username {
        font-size: 24px;
        font-weight: bold;
        color: #fff;
    }
      .container {
        width: 80%;
        margin: 20px auto;
        padding: 2px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 1);
    }
  
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #333;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    tr a {
        display: block;
        color: inherit;
        text-decoration: none;
    }
   
   
     .footerContainer {
        width: 80%;
        margin: 40px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        border-radius: 10px;
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
    <h2 id="username">${sessionScope.username}님</h2>
</nav>


<div class="container">
    <table>
        <thead>
            <tr>
                <th>USER</th>
                <th>QUESTIONS</th>
                <th>CREATE_AT</th>
				<th>DELETE</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach var="qList"  items="${ myQuestionList }">
            <tr>
                <td><a href="../question/content?id=${qList.id}">${ qList.username }</a></td>
                <td><a href="../question/content?id=${qList.id}">${ qList.title }</a></td>
                <td><a href="../question/content?id=${qList.id}">${ qList.qtime }</a></td> 
                <td>
                    <form action="/question/delete" method="post" style="display:inline;">
                     <input type="hidden" name="questionId" value="${qList.id}">
                     <input type="submit" value="DELETE">
                   </form>				
                </td>
            </tr>
         </c:forEach>
        </tbody>
 </table> 
</div>


<div class="footerContainer">
    <a href="../user/update" class="action-button">UPDATE MY INFORMATION</a>
    <a href="../user/delete" class="action-button">DELETE MY ACCOUNT</a>
</div>

</body>
</html>










