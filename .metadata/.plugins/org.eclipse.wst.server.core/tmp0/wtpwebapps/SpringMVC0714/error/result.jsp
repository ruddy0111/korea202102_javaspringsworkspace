<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<img src="https://cdn0.iconfinder.com/data/icons/shift-free/32/Error-128.png">
<%
	RuntimeException e=(RuntimeException)request.getAttribute("e");
	String msg =e.getMessage();
	out.print(msg);
%>

</body>
</html>