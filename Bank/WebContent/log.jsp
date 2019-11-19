<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You have login in to your bank</title>
</head>
<body>	
	<table border="1">
		<tr>
			<th>From Account:</th>
			<th>To Account:</th>
			<th>Transfer Value:</th>
		</tr>
		<c:forEach items="${pageinfo.list }" var="log">
			<tr>
				<td>${log.accOut }</td>
				<td>${log.accIn }</td>
				<td>${log.money }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber-1}" 
		<c:if test="${pageinfo.pageNumber<=1}"> onclick="javascript:return false"</c:if>>previous page</a>
	<a href="show?pageSize=${pageinfo.pageSize }&pageNumber=${pageinfo.pageNumber+1}">
		<c:if test="${pageinfo.pageNumber>=pageinfo.total}"> onclick="javascript:return false;"</c:if>>next page</a>
</body>
</html>