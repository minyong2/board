package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;	
	//게시물 전체 조회
	public List<Map<String, Object>> selectBoardList(){
		
		return boardMapper.selectBoardList();
	}
	
	public int getSaveBoard(BoardVO vo) {
		return boardMapper.getSaveBoard(vo);
	}
		//게시물 삭제
		@Transactional(rollbackFor = {Exception.class})
		public int getDeleteBoard(int boardId) {
			return boardMapper.deleteBoard(boardId);
		}
		
		// 게시물 수정
		@Transactional(rollbackFor = {Exception.class})
		public int getUpdateBoard(int boardId, BoardVO vo) {
			vo.setBoardId(boardId); //VO에 Id를 셋팅 해줘서 mapper에 있는 vo 수정값이랑 Id가 전부 있게 하자.
			return boardMapper.updateBoard(vo);
		}
		
		//특정학생 게시물 상세 조회
		@Transactional(rollbackFor = {Exception.class})
		public BoardVO getBoard(int boardId) {
			return boardMapper.getBoard(boardId);
		}
		
		//게시물 조회수 증가
		public int getUpdateBoardView(int boardId) {
			//1. 게시판 번호를 이용해서 조회 수 컬럼을 select
			BoardVO vo = boardMapper.selectBoardOne(boardId);
			int views = vo.getCnt();
			++views; //2. 조회 수를 1증가 함.
			vo.setCnt(views);
			vo.setBoardId(boardId);
			return boardMapper.updateBoardViews(vo); //3.조회 수 update
		}
		
		
		//작성자 검색 조회
		public List<Map<String, Object>> getSearchBoardList(String studentsName){
			
			return boardMapper.selectSearchBoardList(studentsName);
		}
		
		//-- 통계내기 ( 학생 수 , 게시글 수 , 작성자 수 , 총 조회수)
		public Map<String, Object> selectBoardStatistics(){
			return boardMapper.selectBoardStatistics();
		}


}
