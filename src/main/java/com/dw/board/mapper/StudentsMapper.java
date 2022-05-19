package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dw.board.vo.StudentsVO;

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
	 * comment : 
	 */
	public List<StudentsVO> selectAllStudentsList();
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
	public int updateStudents(StudentsVO vo);
	
	
	/**
	 * @param vo
	 * @return
	 * @author : Minyoung Kim
	 * @date : 2022. 5. 19.
	 * comment : 학생 이름으로 학생 정보 조회
	 */
	public StudentsVO selectStudentsOne(StudentsVO vo);
	
	
}
