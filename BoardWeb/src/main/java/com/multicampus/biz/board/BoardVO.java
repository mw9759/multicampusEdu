package com.multicampus.biz.board;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	//검색관련 변수
	private String searchCondition;
	private String searchKeyword;
	
	//파일 업로드 관련 변수
	private MultipartFile uploadFile;

	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}

	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}

	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
}
