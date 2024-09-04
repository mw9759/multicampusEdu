package com.multicampus.controller.board;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 상세 조회 처리");
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAOJdbc dao = new BoardDAOJdbc();
		BoardVO board = dao.getBoard(vo);
		
		// 3. 조회수 업데이트
		BoardVO vo2 = new BoardVO();
		vo2.setSeq(board.getSeq());
		vo2.setCnt(board.getCnt()+1);
		
		dao.updateCnt(vo2);
		board.setCnt(board.getCnt()+1); 
		
		// 4. 검색 결과를 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		// 4. 화면 이동
		// 이동하고자 하는 화면을 ModelAndView에 담아서 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard.jsp");
		return mav;
	}

}
