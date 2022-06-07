package com.dw.board.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogVO {
	private int logId;
	private String ip;
	private String latitude; //36.3286904  //경도,위도는 private ip라 좌표를 찍을 수 없어서 임시 데이터로 설정
	private String longitude; //127.4229992
	private String url;
	private String httpMethod;
	private String createAt;
}