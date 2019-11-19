<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="transfer" method="post">
		Transfer Account: <input type="text" name="accOutAccNo"/><br>
		Password: <input type="password" name="accOutPassword"/><br>
		Balance: <input type="text" name="accOutBalance"/>
		Received Account: <input type="text" name="accInAccNo"/><br>
		Received Account User Name: <input type="text" name="accInName"/>
		<input type="submit" value="transfer"/>
	</form>
</body>
</html>