<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Detail Page</h1>
		<table border="1">
				<tr>
					<th>num</th>
					<th>title</th>
					<th>content</th>
					<th>Writer</th>
					<th>boardDate</th>
					<th>hit</th>			
				</tr>
			<tr>
				<td>${list.num}</td>
				<td>${list.title}</td>
				<td>${list.content}</td>
				<td>${list.writer}</td>
				<td>${list.boardDate}</td>
				<td>${list.hit}</td>
			</tr>
	</table>
</body>
</html>