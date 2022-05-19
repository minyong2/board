package com.dw.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;	
	
	public List<BoardVO> selectBoardList(){
		
		return boardMapper.selectBoardList();
	}
	
	public int getSaveBoard(BoardVO vo) {
		return boardMapper.getSaveBoard(vo);
	}

}
