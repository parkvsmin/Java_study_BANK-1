<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	
	<form action="./add" method="post">
	<div>
		Name : <input type="text" name="bookName">
	</div>
	<div>
		Rate : <input type="text" name="bookRate">
	</div>
	
	<div>
		<input type="submit" value="Create">
		<button type="submit">Add</button>
		<button type="submit">Delete</button>
	</div>
	
	</form>
	
<!--  	<form action="add" method="post">
		<p>BookNum</p>
		<input type="text" name="bookName">
		<p>BookRate</p>
		<input type="text" name="bookRate">
		<br><br>
		<input type="submit">
	</form>
	-->
</body>
</html>