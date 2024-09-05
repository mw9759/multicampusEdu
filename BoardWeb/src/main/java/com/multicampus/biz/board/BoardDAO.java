package com.multicampus.biz.board;

import java.util.List;


public interface BoardDAO {
	// CRUD 기능의 메소드 구현
	// 조회수 증가
	void updateCnt(BoardVO vo);
	
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 검색
	List<BoardVO> getBoardList(BoardVO vo);
	
	// 글 제목 검색
	List<BoardVO> searchBoardTitleList(BoardVO vo);

}