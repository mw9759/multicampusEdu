package com.multicampus.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO(Data Access Object) 클래스 : 실질적인 DB 연동을 담당하는 클래스
//@Repository
public class BoardDAOMybatis implements BoardDAO{
	
	// SQLMapClientTemplate 타입의 객체를 의존성 주입한다.
	@Autowired
	private SqlSessionTemplate mybatis;


	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> mybatis 기반으로 insertBoard() 기능 처리");
		mybatis.insert("insertBoard", vo);
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> mybatis 기반으로 updateBoard() 기능 처리");
		mybatis.update("updateBoard", vo);
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> mybatis 기반으로 deleteBoard() 기능 처리");
		mybatis.delete("deleteBoard", vo);
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> mybatis 기반으로 getBoard() 기능 처리");
		return (BoardVO) mybatis.selectOne("getBoard", vo);
	}

	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> mybatis 기반으로 getBoardList() 기능 처리");
		return mybatis.selectList("getBoardList", vo);
	}

	// 조회수 증가
	@Override
	public void updateCnt(BoardVO vo) {
		mybatis.update("updateCnt", vo);
	}

	@Override
	public List<BoardVO> searchBoardTitleList(BoardVO vo) {
		System.out.println("===> mybatis 기반으로 검색 기능 처리");
		return mybatis.selectList("boardSearchTitle", vo);
	}
}
