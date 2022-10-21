<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

</head>
<body>
	<div class="container">
		<h2>로그인</h2>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			<div class="mb-3">
				<label class="form-label" for="id">아이디</label> <input
					class="form-control" type="text" name="id" id="id" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="pwd">비밀번호</label> <input
					class="form-control" type="password" name="pwd" id="pwd" />
			</div>
			<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>