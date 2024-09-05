package com.multicampus.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
// Model에 board라는 이름의 데이터가 저장될 때, 세션에도 동일하게 저장해라
@SessionAttributes("board")
public class BoardController {

	// BoardService 타입의 객체(BoardServiceImple)를 의존선 주입한다
	@Autowired
	public BoardService boardService;
	
	// 글 등록
	@GetMapping("/insertBoard.do")
	public String insertBoardView() throws Exception {
		return "insertBoard.jsp";
	}
	
	// 글 등록
	@PostMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	// 세션에 board 라는 이름의 데이터가 있다면 꺼내서 재사용해라.@ModelAttribute("board")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		// 조회수 증가
		BoardVO vo2 = boardService.getBoard(vo);
		vo2.setCnt(vo2.getCnt()+1);
		boardService.updateCnt(vo2);
		
		model.addAttribute("board", boardService.getBoard(vo2)); // model
		return "getBoard.jsp";   // view
	}

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList(vo)); // model
		return "getBoardList.jsp";   // view
	}
	
	// 글 검색
	@RequestMapping("/searchBoard.do")
	public String searchBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("boardList", boardService.searchBoardTitleList(vo)); // model
		return "getBoardList.jsp";   // view
	} 
}
