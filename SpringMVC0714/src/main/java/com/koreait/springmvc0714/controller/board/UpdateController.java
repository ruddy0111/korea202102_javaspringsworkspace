package com.koreait.springmvc0714.controller.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

//수정 컨트롤러
@Setter
public class UpdateController implements Controller{
	private BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 : 일시키기
		Board board = new Board();
		board.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		board.setTitle(request.getParameter("title"));
		board.setTitle(request.getParameter("writer"));
		board.setTitle(request.getParameter("content"));
		ModelAndView mav = new ModelAndView();
		try {
			boardService.update(board);
			//성공은 상세보기 유도
			mav.setViewName("redirect:/board/detail?board_id"+board.getBoard_id());;
		}catch(DMLException e) {
			e.printStackTrace();
			//에러 페이지로 이동
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}
		return mav;
	}

}
