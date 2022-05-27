package com.dw.board.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	
	private int boardId;
	private String title;
	private String content;
	private String updateAt;
	private String createAt;
	private int studentsId;
	private String studentsName;
	private int cnt; //조회 수

}
