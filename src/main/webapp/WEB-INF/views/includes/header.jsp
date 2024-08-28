<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <header>
        <h1>애완 호텔</h1>
    </header>

    <nav>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <a href="/">Home</a>
                <a href="/posts">Posts</a>
                <a href="/logout">Logout</a>
                <span>Hello, ${sessionScope.user.username}</span>
            </c:when>
            <c:otherwise>
                <a href="/">Home</a>
                <a href="/login">Login</a>
                <a href="/signup">Sign Up</a>
            </c:otherwise>
        </c:choose>
    </nav>