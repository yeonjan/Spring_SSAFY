<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1>책 목록 조회 화면</h1>
    
    <table class="table table-striped">
    <thead>
      <tr>
        <th>책 고유번호</th>
        <th>제목</th>
        <th>저자</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="book">
            <tr>
                <td>${book.isbn }</td>
                <td>${book.title }</td>
                <td>${book.author }</td>
                <td>${book.price }</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>
</body>
</html>