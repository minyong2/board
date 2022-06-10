package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;
import com.github.pagehelper.PageHelper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	//게시판 저장
	@Transactional(rollbackFor = Exception.class)
	public int setBoard(BoardVO vo) {
		return boardMapper.insertBoard(vo);
	}
	//게시판 전체 조회
	//pageNum : 현재 페이지, pageSize: 한 페이지에 게시물 몇개 보여줄지
	public List<Map<String, Object>> getAllBoardList(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return boardMapper.selectAllBoardList();
	}
	//게시물 수정
	@Transactional(rollbackFor = Exception.class)
	public int getUpdateBoard(BoardVO vo, int boardId) {
		vo.setBoardId(boardId);
		return boardMapper.updateBoard(vo);
	}
	//게시물 삭제
	@Transactional(rollbackFor = Exception.class)
	public int getRemoveBoard(int boardId) {
		return boardMapper.deleteBoard(boardId);
	}
	//게시물 상세조회
	public BoardVO getBoard(int boardId) {
		return boardMapper.selectBoardOne(boardId);
	}
	
	//게시풀 조회수 증가
	public int getUpdateBoardView(int boardId) {
		//1. 게시판 번호를 이용해서 조회 수 컬럼을 select
		BoardVO vo = boardMapper.selectBoardOne(boardId);
		int views = vo.getCnt();
		++views; //2. 조회 수를 1증가 함.
		vo.setCnt(views);
		vo.setBoardId(boardId);
		return boardMapper.updateBoardViews(vo); //3.조회 수 update
	}
	
	//작성자가 작성한 게시물 조회
	public List<Map<String, Object>> getSearchBoardList(String studentsName,int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return boardMapper.selectSearchBoardList(studentsName);
	}
	
	//학생 수, 게시글 수, 작성자 수, 총 조회 수 통계
	public Map<String, Object> getBoardStatistics(){
		return boardMapper.selectBoardStatistics();
	}
	
	

	
	
	
	
}