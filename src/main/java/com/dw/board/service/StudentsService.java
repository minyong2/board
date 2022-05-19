package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.board.mapper.StudentsMapper;
import com.dw.board.vo.StudentsVO;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsMapper studentsMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//학생 저장
	public int insertStudents(StudentsVO vo) {
		//학생 비밀번호 암호화
		String password = vo.getStudentsPassword();
		password = passwordEncoder.encode(password);
		vo.setStudentsPassword(password);
		return studentsMapper.insertStudents(vo);
	}
	
	//학생 전체 조회
	public List<StudentsVO> getAllStudentsList(){
		return studentsMapper.selectAllStudentsList();
	}
	
	public List<Map<String, Object>> getStudentsListByMap(){
		return studentsMapper.getStudentsListByMap();
	}
	
	public StudentsVO selectStudents(int studentsId) {
		return studentsMapper.selectStudents(studentsId);
	}

	@Transactional(rollbackFor = Exception.class)
	public int removeStudents(int studentsId) {
		return studentsMapper.removeStudents(studentsId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int updateStudents(int studentsId, StudentsVO vo) {
		vo.setStudentsId(studentsId);
		return studentsMapper.updateStudents(vo);
	}
	//가입된 학생인지 아닌지 여부 체크
	public boolean isStudents(StudentsVO vo) {
		
		StudentsVO student = studentsMapper.selectStudentsOne(vo);
		//회원이 있는지 없는지부터 체크
		if(student == null) {
			//쿼리 결과가 null 리턴
			return false;
		}
		String inputPassword = vo.getStudentsPassword();
		//HTML에서 받아온 비밀번호
		String password = student.getStudentsPassword();
		//DB에서 가져온 비밀번호
		
		if(!passwordEncoder.matches(inputPassword, password)) {
		//비밀번호 체크
			return false;
		}
		
		return true;
	}
}
