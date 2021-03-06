package com.koreait.springmvc0715.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.springmvc0715.model.board.service.BoardService;
import com.koreait.springmvc0715.model.domain.Board;

//목록, 등록, 수정, 삭제, 상세보기를 하나의 컨트롤러에서 처리~~~

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	// 목록 요청을 처리하는 메서드
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String getList(Model model) {
		// System.out.println("목록을 원하는 군여");
		List boardList = boardService.selectAll();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}

	// 글쓰기 요청 처리
	@RequestMapping(value = "/board/regist", method = RequestMethod.POST)
	public String regist(Board board, Model model) {
		// 3단계 : 일 시키기
		String viewName = null;
		try {
			boardService.insert(board);
			viewName = "redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}
		// System.out.println("자동 매핑된 제목은?"+board.getTitle());
		return viewName;

	}

	// 상세보기 요청 처리
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String getDetail(int board_id, Model model) {
		// 3단계 : 일 시키기
		Board board = boardService.select(board_id);
		// 4단계 : 결과 저장
		model.addAttribute("board", board);

		return "board/detail";
	}

	// 수정 요청 처리
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public ModelAndView edit(Board board) {
		// 3단계 : 일 시키기(수정)
		ModelAndView mav = new ModelAndView();
		try {
			boardService.update(board);
			mav.setViewName("redirect:/board/detail?board_id=" + board.getBoard_id());
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}
		return mav;
	}

	// 삭제요청 처리
	@RequestMapping(value = "/board/del", method = RequestMethod.POST)
	public String delete(int board_id, Model model) {

		String viewName = null;
		try {
			boardService.delete(board_id);
			viewName = "redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e", e);
			viewName = "error/result";
		}

		return viewName;
	}
}
