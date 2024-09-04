package com.multicampus.controller.board;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 검색 처리");
		
		// 1. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAOJdbc dao = new BoardDAOJdbc();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 2. 검색 결과를 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		// 3. 화면 이동
		// 이동하고자 하는 화면을 ModelAndView에 담아서 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}
