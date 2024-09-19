<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <table width ="1000" border = "1">
     <caption> 예약 완료! </caption>
       
       <tr>
          <td>성함</td>
          <td>${rdto.username}</td>
       </tr>
       <tr>
          <td>전화번호</td>
          <td>${rdto.phone }</td>
       </tr>
       <tr>
         <td>예약날짜</td>
         <td>${rdto.startDate} ~ ${rdto.endDate }</td>             
       </tr>
       
       <tr>
          <td>요청사항</td>
          <td>${rdto.content }</td>
       </tr>
       
       <tr>
         <td>결제가격</td>
         <td>${rdto.chongprice }</td>
       </tr>
       
       
       
       
  
  </table>
    
    <a href = "/main/index">메인화면으로 돌아기</a>

</body>
</html>