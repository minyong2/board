package com.dw.board;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.utils.PageHandler;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private PageHandler pageHandler;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void contextLoads() {
		System.out.println("hello world");
		
		int total = boardMapper.selectAllBoardTotal();
		System.out.println("Total => "+ total);
//		int total = (int) map.get("boardCnt");  //전체 게시물 수
//				System.out.println("total => "+total);
		int pageNum = 1; //현재 페이지 번호
		int pageSize = 10; //한 페이지에 게시물 10개
		int navigatePages = 5; //한 블록에 페이지 5개
		
		pageHandler.setTotal(total);
		pageHandler.setPageNum(pageNum);
		pageHandler.setPageSize(pageSize);
		pageHandler.setNavigatePages(navigatePages);
		
		pageHandler.setNowBlock(pageNum);
		int nowBlock = pageHandler.getNowBlock(); //현재 블럭
		System.out.println("현재 블럭 => " +nowBlock);
		
		pageHandler.setLastBlock(total); //마지막 블럭
		int lastBlock = pageHandler.getLastBlock();
		System.out.println("마지막 블럭 => " +lastBlock);
		
		pageHandler.setStartPage(nowBlock);
		int startBlock = pageHandler.getStartPage();
		System.out.println("처음 블럭 => "+startBlock);
		
		int pages = pageHandler.calcPage(total, pageSize);
		pageHandler.setEndPage(nowBlock, pages);
		int lastPage = pageHandler.getEndPage();
		System.out.println("마지막 페이지 => "+lastPage);
		
		pageHandler.setPreNext(pageNum);
		boolean hasPreviousPage = pageHandler.isHasPreviousPage();
		boolean hasNextPage = pageHandler.isHasNextPage();
		System.out.println("이전 버튼 유무 => "+hasPreviousPage);
		System.out.println("다음 버튼 유무 => "+hasNextPage);
		
		//limit은 데이터가 엄청 많을때는 비효율적
		//데이터가 엄청 많을때는 between 쓰는게 좋음!
		int limitStart = (pageNum - 1) * pageSize;
		List<Map<String, Object>> list = boardMapper.selectAllBoardListTest(limitStart,pageSize);
		//학생 전체 조회
//		List<StudentsVO> list = service.getAllStudentsList();
		
//		for(StudentsVO vo : list) {
//			System.out.println(vo.getStudentsId());
//			System.out.println(vo.getStudentsName());
//		}
	}

}
