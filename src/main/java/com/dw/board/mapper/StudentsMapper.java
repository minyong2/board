package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dw.board.vo.StudentsVO;

/**
 * @author dw-014
 *
 */
/**
 * @author dw-014
 *
 */
/**
 * @author dw-014
 *
 */
@Mapper
public interface StudentsMapper {

	
	/**
	 * @param vo
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 5. 18.
	 * comment : 
	 */
	public int insertStudents(StudentsVO vo);
	
	/**
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 5. 18.
	 * comment :학생 리스트 조회(페이지에 구현 할 것) 
	 */
	public List<Map<String, Object>> selectStudentsList();
	//전체조회라서 List
	
	public List<Map<String, Object>> getStudentsListByMap();
	//Map으로 조회
	
	public StudentsVO selectStudents(int studentsId);
	
	/**
	 * @param studentsId
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 5. 18.
	 * comment : 특정 학생 삭제
	 */
	public int removeStudents(int studentsId);
	
	
	/**
	 * @param vo
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 6. 7.
	 * comment : 특정 학생 정보 수정
	 */
	public int updateStudents(StudentsVO vo);
	
	
	/**
	 * @param vo
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 5. 19.
	 * comment : 학생 이름으로 학생 정보 조회
	 */
	public StudentsVO selectStudentsOne(StudentsVO vo);
	
	//학생 상세 정보 조회
	public StudentsVO selectDetailStudents(int studentsId);
	
	
	/**
	 * @param student
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 6. 7.
	 * comment : 학생 검색 조회
	 */
	public List<Map<String, Object>> selectSearchStudents(String studentsName);
	
	
}
