<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        padding: 2px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 1);
    }
    #title {
        text-align: center;
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
</style>
</head>
<body>
<div class="container">
    <h2 id="title">Q&A -- LIST</h2>
 </div>
  <table>
        <thead>
            <tr>
                <th>USER</th>
                <th>QUESTIONS</th>
                <th>CREATE_AT</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach var="qnaList"  items="${ questionList }">
            <tr>
                <td><a href="../user/qnapost">${ sessionScope.username }</a></td>
                <td><a href="../user/qnapost">${ qnaList.title }</a></td>
                <td><a href="../user/qnapost">${ qnaList.qtime }</a></td>
                <td><input type="botton" value="DELETE"></td>
            </tr>
         </c:forEach>
        </tbody>
        <tfoot>
            <tr>
               <input type="botton" value="WRITE QUESTION">
            </tr>
        </tfoot>
    </table>

</body>
</html>