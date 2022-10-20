

### key=value 형태로 전달된 요청 파라미터 한번에 받기
regist.jsp 
파라미터의 name 값을 DTO의 setter의 set 뒤의 이름과 동일하게 작성
```html
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
```
BookController.java
controller에서는 dto로 입력받을 수 있다.  
book이 기본 생성자로 생성된 후 요청 파라미터에 따라 setter로 값이 설정된다.
```java
@GetMapping("/regist")
public ModelAndView regist(Book2 book) throws SQLException {
	bookService.saveBook(book);
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("redirect:/book/list");
		
	return mav;
}
  ```
