package com.multicampus.biz;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		
		// BoardService 타입의 객체(BoardServiceImpl)를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("Spring IoC 테스트");
		vo.setWriter("테스터");
		vo.setContent("Spring IoC 테스트 중입니다.");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
//		vo.setSeq(999);
//		boardService.deleteBoard(vo);
		
		container.close();
	}
}








