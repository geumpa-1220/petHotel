<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        }
        header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 20px;
       }
        h1 {
            margin: 0;
            font-size: 24px;
       }
       
        a {
            margin: 0 15px;
            color: white;
            text-decoration: none;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 1);
         }
    </style>
    <sitemesh:write property="head"/>
</head>
<body>
<header>
        
        <h1><a href="../main/index">HOME</a></h1>
         
        <c:choose>
            <c:when test="${not empty sessionScope.role and sessionScope.role == 'admin' }">
               <a href="../answer/list" >Q&A</a>
                <a href="../admin/mypage"  >관리자: ${sessionScope.username}</a>
                <a href="../reserve/reserve">RRSERVATION</a>
                <a href="../admin/logout">LOG OUT</a> 
            </c:when>
            
            <c:when test="${not empty sessionScope.role and sessionScope.role == 'user'}">
                <a href="../question/list" >Q&A</a>
                <a href="../user/mypage"  > ${sessionScope.username}님</a>
                <a href="../reserve/reserve">RRSERVATION</a>
                <a href="../user/logout">LOG OUT</a> 
            </c:when>
            
            <c:otherwise>   
                   <a href="../user/login" >Q&A</a>
                   <a href="../user/login">RRSERVATION</a>
               <div>
                   <a href="../user/login">LOGIN</a>
                   <a href="../user/signup">SIGN UP</a>
               </div>   
            </c:otherwise>
        </c:choose>
    
    
 </header>

    
    <sitemesh:write property="body"/>
    
 <footer>
    <p>&copy; 2024 --- 애완 호텔 --- </p>
</footer>
</body>
</html>