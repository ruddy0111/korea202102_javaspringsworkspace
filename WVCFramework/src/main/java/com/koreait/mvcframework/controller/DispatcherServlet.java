package com.koreait.mvcframework.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.blood.BloodController;
import com.koreait.mvcframework.controller.movie.MovieController;

//이 서블릿은 우리의 웹 어플리케이션의 모든~~요청을 일단 받는 진입점 컨트롤러임
public class DispatcherServlet extends HttpServlet{
   /*모든 컨트롤러의 업무처리 순서
    * 1. 요청을 받는다
    * 2. 요청을 분석한다(어떤 하위 컨트롤러에게 업무를 전달할지 알아야 하므로)
    * 3. 알맞는 로직 객체에 일 시킨다(하위컨트롤러가)
    * 4. 결과가 있다면 결과를 저장한다
    * 5. 결과를 보여준다
    */
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doRequest(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doRequest(request, response);
   }
   
   protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1단계 : 요청을 받는다
	   System.out.println("요청을 받았습니다.");
	  //2단계 : 어떤 하위 컨트롤러에게 업무를 할당할지 분석. 클라이언트가 요청시 사용한 URL 자체가 의미 부여 수단이 ehlamfh, 요청 url을 이용한 요청 분석 해보자.
	   String uri = request.getRequestURI();//URI>URL
	   System.out.println(uri);
	   
	   if(uri.equals("/blood.do")) {
		   BloodController controller = new BloodController();
		   controller.doRequest(request, response);
		   //5단계 결과 보여주기
		      RequestDispatcher dis=request.getRequestDispatcher("/blood/result.jsp");
		      dis.forward(request, response); //쌍방울을 가지고,  result.jsp로 전달된다!!
	   }else if(uri.equals("/movie.do")) {
		   MovieController controller = new MovieController();
	   }
   }
}