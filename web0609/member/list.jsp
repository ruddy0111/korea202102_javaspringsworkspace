<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%!
	//����� : Ŭ������ ����������ν�, ���� �� �޼��带 ������ �� �ִ� ���� 
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
%>
<%
	//��ũ��Ʋ�� ����: Ŭ������ �޼��� ���� , ���� ���� �ۼ����� 
	Class.forName(driver);//1.����̹� �ε�
	out.print("����̹� �ε� ����"); //����̹��� lib���� jar ���丮�� �־�ױ� ������..
	con=DriverManager.getConnection(url, user , password); //2.���� 
	
	if(con==null){
		out.print("���� ����<br>");
	}else{
		out.print("���� ����<br>");
		
		//3.�������� 
		String sql="select * from member";
		pstmt=con.prepareStatement(sql); //������ �غ�
		rs=pstmt.executeQuery(); //�������� �� ��� �������� 
		
		out.print(rs);
		
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
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

<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
	<tr>
		<th>No</th>
		<th>member_id</th>
		<th>user_id</th>
		<th>name</th>
		<th>regdate</th>
	</tr>
	<%while(rs.next()){%>
	<tr>
		<td>Jill</td>
		<td><%=rs.getInt("member_id")%></td>
		<td><%=rs.getString("user_id")%></td>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getString("regdate")%></td>
	</tr>
	<%}%>
</table>

</body>
</html>

<%
	if(rs!=null){
		rs.close();
	}
	if(pstmt!=null){
		pstmt.close();
	}
	if(con!=null){
		con.close();
	}
%>