<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <h1>책 등록 화면</h1>
    <!-- form 태그의 enctype 속성 multipart/form-data로 변경 -->
    <form action="${pageContext.request.contextPath}/book/regist" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="isbn">고유번호</label>
        <input type="text" class="form-control" name="isbn" id="isbn">
      </div>
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control"  name="title" id="title">
      </div>
      <div class="form-group">
        <label for="author">저자</label>
        <input type="text" class="form-control"  name="author" id="author">
      </div>
      <div class="form-group">
        <label for="price">가격</label>
        <input type="number" class="form-control" name="price" id="price">
      </div>
      <div class="form-group">
        <label for="description">설명</label>
        <textarea class="form-control" name="description" id="description"></textarea>
      </div>
      <!-- 파일 업로드 start -->
      <div class="form-group">
        <label for="fileInfo">파일: </label>
        <input type="file" class="form-control-file" name="file" id="file">
      </div>
      <!-- 파일 업로드 추가 end -->
      <button type="submit" class="btn btn-primary">등록하기</button>
    </form>
</body>
</html>