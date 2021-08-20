<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Hardware> hardwareList = (List) request.getAttribute("hardwareList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>

<h2>Hardware 목록</h2>

<table>
  <tr>
    <th>이름</th>
    <th>브랜드</th>
    <th>가격</th>
  </tr>
  <%for(Hardware obj : hardwareList){ %>
  <tr>
    <td><%=obj.getName() %></td>
    <td><%=obj.getBrand() %></td>
    <td><%=obj.getPrice() %></td>
  </tr>
  <%} %>
  
</table>

</body>
</html>
