package com.multicampus.controller.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
// Model에 board라는 이름의 데이터가 저장될 때, 세션에도 동일하게 저장해라
@SessionAttributes("board")
public class BoardController {
	
	// BoardService 타입의 객체(BoardServiceImple)를 의존선 주입한다
	@Autowired
	public BoardService boardService;
	
	@RequestMapping("/json.do")
	// @ResponseBody : 자바 객체를 JSON으로 변환하여 HTTP 응답 프로토콜 body에 출력해준다.
	public @ResponseBody List<BoardVO> json(BoardVO vo) throws Exception {
		return boardService.getBoardList(vo);
	}
	
//	@RequestMapping("/json.do")
//	// @ResponseBody : 자바 객체를 JSON으로 변환하여 HTTP 응답 프로토콜 body에 출력해준다.
//	public @ResponseBody BoardVO json(BoardVO vo) throws Exception {
//		return boardService.getBoard(vo);
//	}
//	
	// 글 등록
	@GetMapping("/insertBoard.do")
	public String insertBoardView() throws Exception {
		return "insertBoard.jsp";
	}
	
	// 글 등록
	@PostMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		// 1. 파일 업로드 처리
		MultipartFile upload = vo.getUploadFile();
		if(!upload.isEmpty()) { // 업로드된 파일 정보가 있다면
			long time = System.currentTimeMillis();
			upload.transferTo(new File("C:/DEV/upload_files/" +time+ "_"+ upload.getOriginalFilename()));
		}
		// 2. 글등록 처리
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
