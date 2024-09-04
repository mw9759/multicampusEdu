package com.multicampus.biz.board;

import java.util.Date;

import lombok.Data;

// 1.VO(VALUE OBJECT) : BOARD 테이블과 매핑되는 클래스
@Data
public class BoardVO {
	// private 멤버변수 선언
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
}
