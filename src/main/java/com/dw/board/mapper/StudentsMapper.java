package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dw.board.vo.StudentsVO;

@Mapper
public interface StudentsMapper {
	
	// 메소드를 클릭 한 상태에서 alt + shift + J
	/**
	 * @param vo
	 * @return
	 * @author : ji_U
	 * @date : 2022. 5. 18.
	 * comment :
	 */
	public int insertStudents(StudentsVO vo);
	
	/**
	 * @return
	 * @author : ji_U
	 * @date : 2022. 5. 18.
	 * comment :
	 */
//	public List<StudentsVO> selectAllStudentsList();
	public List<Map<String,Object>> selectAllStudentsList();
	/**
	 * @return
	 * @author : ji_U
	 * @date : 2022. 5. 18.
	 * comment :
	 */
	public List<Map<String, Object>> selectAllStudentsMap();
	
	public StudentsVO selectStudents(int studentsId);
	
	public int deleteStudents(int studentsId);
	
	/**
	 * @param vo
	 * @param studentsId
	 * @return
	 * @author : ji_U
	 * @date : 2022. 5. 18.
	 * comment : 특정학생 수정
	 */
	public int updateStudents(StudentsVO vo);
	
	
	/**
	 * @return
	 * @author : ji_U
	 * @date : 2022. 5. 19.
	 * comment : 학생이름으로 학생정보 조회
	 */
	public StudentsVO selectStudentsOne(StudentsVO vo);
	
	/**
	 * @param studentsName
	 * @return
	 * @author : ji_U
	 * @date : 2022. 6. 7.
	 * comment : 학생이름 검색
	 */
	public List<Map<String,Object>> studentsSearchList(@Param("studentsName") String studentsName);
}