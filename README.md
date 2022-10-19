

### get방식으로 데이터 한번에 보내기

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
```java
@GetMapping("/regist")
public ModelAndView regist(Book2 book) throws SQLException {
	bookService.saveBook(book);
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("redirect:/book/list");
		
	return mav;
}
  ```
