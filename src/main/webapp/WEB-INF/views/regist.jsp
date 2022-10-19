<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h2>HTML Forms</h2>

<form action="${pageContext.request.contextPath}/book/regist">
  <label>isbn:</label><br>
  <input type="text" name="isbn" ><br>
  <label>title:</label><br>
  <input type="text" name="title"><br>
  <label>author:</label><br>
  <input type="text" name="author"><br>
  <label>price:</label><br>
  <input type="text" name="price"><br><br>
  <input type="submit" value="Submit">
</form> 

<p>If you click the "Submit" button, the form-data will be sent to a page called "/action_page.php".</p>

</body>
</html>

