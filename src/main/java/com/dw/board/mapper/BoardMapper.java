package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.dw.board.vo.BoardVO;

@Mapper
public interface BoardMapper {

	
	public List<Map<String, Object>> selectBoardList();
	
	
	/**
	 * @param vo
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 6. 2.
	 * comment : 게시물 작성
	 */
	public int getSaveBoard(BoardVO vo);
	

	/**
	 * @param boardId
	 * @return
	 * comment : 게시판 게시물 삭제
	 */
	public int deleteBoard(int boardId);
	
	/**
	 * @param boardId
	 * @return : int
	 * @date : 2022. 5. 26.
	 *comment : 게시물 수정
	 */
	public int updateBoard(@RequestBody BoardVO vo);
	
	
	/**
	 * @param boardId
	 * @return
	 * comment : 특정 회원 게시물 조회
	 */
	public BoardVO getBoard(int boardId);
	
	public BoardVO selectBoardOne(int BoardId);
	
	public int updateBoardViews(BoardVO vo);
	
	public List<Map<String, Object>> selectSearchBoardList(@Param("studentsName") String studentsName);
	//파라미터 2개면 Param 하나면 생략가능
	
	public Map<String, Object> selectBoardStatistics();
}
