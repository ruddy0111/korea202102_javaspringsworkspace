package com.koreait.mvcframework.controller.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.model.movie.MovieService;

//영화에 대한 요청을 처리하는 컨트롤러 
public class MovieController{
	MovieService service;
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movie = request.getParameter("movie");//파라미터 받기!!
		
		//3단계 : 알맞는 로직 객체에 일 시킨다.
		//로직은 재사용 가능성이 있으므로, 컨트롤러에 소속시키지 말고, 별도의 물리적 파일로 분리
		String msg=service.getAdvice(movie);
		
		//4단계 : 보여질 결과가 있다면 결과를 request 에 저장한다.
		//결과를 request 에 심기!!
		request.setAttribute("msg", msg);
		
		//여기서 디자인 처리가 가능하긴 하지만, 유지보수성이 떨어지므로 
		//디자인은 별도의  jsp 에 담당하기로 한다!!
		//별도의 결과페이지인  result.jsp로 포워딩을 통해 결과를 가지고 가자!!!
		RequestDispatcher dis = request.getRequestDispatcher("/movie/result.jsp");
		dis.forward(request, response);
	}
	
}
