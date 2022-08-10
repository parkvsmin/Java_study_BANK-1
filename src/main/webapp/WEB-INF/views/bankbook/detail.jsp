<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	
	<% if(bankBookDTO != null){ %>
	
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td><%= bankBookDTO.getBookNum() %> </td>
			<td><%= bankBookDTO.getBookName() %> </td>
			<td><%= bankBookDTO.getBookRate() %> </td>
			<td>
				<% if(bankBookDTO.getBookSale()==1){ %>
					판매중
				<%}else { %>
					판매금지
				<%} %>
			</td>
		</tr>
	</table>
	<%}else { %>
		<h3>Data가 없다</h3>
	<%} %>
	
	<!-- 상대경로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
	<a href="./list">리스트보기</a>
</body>
</html>