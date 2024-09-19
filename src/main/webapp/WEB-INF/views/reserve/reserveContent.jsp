<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 상세 정보</title>
<style>
    /* ReserveContent 페이지 스타일 */
    .container {
        width: 80%;
        margin: 20px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table caption {
        font-size: 18px;
        margin-bottom: 10px;
        font-weight: bold;
        text-align: left;
    }

    table, th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f4f4f4;
    }

    .button-container {
        text-align: center;
        margin-top: 20px;
    }

    .button-container input {
        padding: 10px 20px;
        background-color: #333;
        color: white;
        border: none;
        cursor: pointer;
        font-size: 16px;
    }

    .button-container input:hover {
        background-color: #555;
    }

    #result {
        font-weight: bold;
    }

    #petsuError, #phonechk {
        color: red;
    }
</style>
<script>
  function chongpriceadd() {
      var chongprice1;
      var daydiff = document.getElementById("dayDiff").value;
      var petsu = document.getElementById("petsu").value;
      var price = document.getElementById("price").value;

      if (petsu == "0") {
          chongprice1 = price * daydiff;
      } else {
          chongprice1 = price * daydiff + (((petsu - 1) * 10000) * daydiff);
      }

      document.getElementById("result").innerText = chongprice1 + "만원";
      document.getElementById("chongprice").value = chongprice1;
  }

  function check() {
      var petsu = document.getElementById("petsu").value;
      if (petsu == "0") {
          document.getElementById("petsuError").innerText = "애완견 마리수를 선택해 주세요.";
          return false;
      } else {
          document.getElementById("petsuError").innerText = "";
      }

      var phone = document.getElementById("phone").value;
      if (phone == "") {
          document.getElementById("phonechk").innerText = "휴대폰 번호 입력 해주세요.";
          return false;
      } else {
          document.getElementById("phonechk").innerText = "";
          return true;
      }
  }
</script>
</head>
<body>
<div class="container">
    <form method="post" action="reserveOk" name="resForm" onsubmit="return check()">
        <input type="hidden" id="roomid" name="roomid" value="${roomid}">
        <input type="hidden" id="startDate" name="startDate" value="${startDate}">
        <input type="hidden" id="endDate" name="endDate" value="${endDate}">
        <input type="hidden" id="dayDiff" name="dayDiff" value="${dayDiff}">
        <input type="hidden" id="price" name="price" value="${rdto.price}">
        <input type="hidden" id="chongprice" name="chongprice" value="">

        <!-- 예약 방 정보 -->
        <table>
            <caption>예약 방 정보 - ${roomid}</caption>
            <tr>
                <td>예약 기간</td>
                <td>${startDate} ~ ${endDate}</td>
            </tr>
            <tr>
                <td>방 이름</td>
                <td>${rdto.title}</td>
            </tr>
            <tr>
                <td>방 가격</td>
                <td>${rdto.price}만원</td>
            </tr>
            <tr>
                <td>애완견 마리수 (최대: ${rdto.max})</td>
                <td>
                    <select name="petsu" onchange="chongpriceadd()" id="petsu">
                        <c:forEach begin="${rdto.min}" end="${rdto.max}" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><div id="petsuError"></div></td>
            </tr>
        </table>

        <!-- 애완견 주인 정보 -->
        <table>
            <caption>애완견 주인 정보</caption>
            <tr>
                <td>이름</td>
                <td>${username}</td>
            </tr>
            <tr>
                <td>전화 번호</td>
                <td><input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td colspan="2"><div id="phonechk"></div></td>
            </tr>
            <tr>
                <td>요청 사항</td>
                <td>
                    <input type="text" name="content" placeholder="요청 사항을 입력하세요">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    숙소는 최선을 다해 요청 사항을 제공해 드릴 수 있도록 최선을 다하겠습니다. 다만, 사정에 따라 제공 여부가 보장되지 않을 수 있습니다.
                </td>
            </tr>
        </table>

        <!-- 취소 및 노쇼 정책 -->
        <table>
            <caption>취소 및 노쇼 정책</caption>
            <tr>
                <td>입실 1일전 24:00까지</td>
                <td>취소 비용 없음</td>
            </tr>
            <tr>
                <td>입실 1일전 24:00부터 입실 당일까지</td>
                <td>첫날 객실료의 100%의 상당의 수수료 발생</td>
            </tr>
            <tr>
                <td>노쇼</td>
                <td>체크인하지 않는 경우 첫날의 객실료의 100% 부과</td>
            </tr>
        </table>

        <!-- 총 가격 -->
        <table>
            <caption>총 가격</caption>
            <tr>
                <td>총 가격</td>
                <td><div id="result"></div></td>
            </tr>
        </table>

        <!-- 예약하기 버튼 -->
        <div class="button-container">
            <input type="submit" value="예약하기">
        </div>
    </form>
</div>
</body>
</html>