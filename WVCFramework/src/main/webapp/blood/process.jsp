<%@page import="com.koreait.mvcframework.model.blood.BloodService"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! BloodService service = new BloodService();%>
<%
//컨트롤러는 디자인과 로직을 분리시키기 위한 중간처리자(프로그램의 흐름 처리)
//요청을 받아서, 적절한 로직 객체에게 일을 시ㅣ고 

//클라이언트가 전송한 파라미터를 받아 결과 보여주기
request.setCharacterEncoding("utf-8");
String blood = request.getParameter("blood");

String msg=service.getAdvice(blood);

request.setAttribute("msg", msg);
//아래와 같이 요청을 끊고, 클라이언트가 재접속하게 하지 말고,
//서버에서 특정 자원으로 요청을 포워딩 즉 전달 시켜보자.
//response.sendRedirect("/blood/result.jsp");

RequestDispatcher dis=request.getRequestDispatcher("/blood/result.jsp");
dis.forward(request, response);//쌍방울을 가지고 result.jsp로 전달.
%>
