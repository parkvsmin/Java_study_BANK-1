<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	
	<form action="./update" method="post">
	
	<div>
			Num : <input type="hidden" name="bookNum" readonly="readonly" value="${dto.bookNum}">
		</div>
		
		<div>
			Name : <input type="text" name="bookName" value="${dto.bookName}">
		</div>
				<div>
			Rate : <input type="text" name="bookRate" value="${dto.bookRate}">
		</div>
		
		<!--<input type="submit" value="업데이트">-->
		<button type="submit">업데이트</button>
		
	</form>

</body>
</html>