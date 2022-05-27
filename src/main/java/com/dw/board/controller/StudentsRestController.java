package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.StudentsService;
import com.dw.board.vo.StudentsVO;

@RestController
@RequestMapping("/api/v1")
public class StudentsRestController {
	@Autowired
	private StudentsService studentsService;
	
	//중요한 정보를 서버에 전송할 때 POST 사용
	@CrossOrigin
	@PostMapping("/login")
	public boolean callIsLogin(@RequestBody StudentsVO vo, HttpSession httpSession) {
		
		
		boolean isLogin = studentsService.isStudents(vo);
		
		if(isLogin) {
			httpSession.setAttribute("name", "kimminyoung");
		}
		
		return isLogin;
	}
	//학생 저장
		//post는 body로 데이터를 받는다. (왜냐? 보안때문에)
		@CrossOrigin
		@PostMapping("/student")
		public int callSaveStudents(@RequestBody StudentsVO vo) {
			return studentsService.insertStudents(vo);
		}

	//학생 조회
		@GetMapping("/student")
		public List<StudentsVO> callStudentsList(){
			return studentsService.getAllStudentsList();
		}
		
		@GetMapping("/student/map")
		public List<Map<String, Object>> callStudentsListByMap(HttpSession httpSession){
			String name = (String)httpSession.getAttribute("name");
			System.out.println("세션에서 가져온 이름은 ===>" + name);
			return studentsService.getStudentsListByMap();
		}
		
	//특정 학생 조회(PK로 조회)
		@GetMapping("/student/id/{id}")
		public StudentsVO callStudent(@PathVariable("id") int studentsId) {
			return studentsService.selectStudents(studentsId);
		}
		
	//특정 학생 삭제
		@DeleteMapping("/student/id/{id}")
		public int callRemoveStudents(@PathVariable("id") int studentsId) {
			return studentsService.removeStudents(studentsId);
		}
		
	// 특정 학생 수정
		@PatchMapping("/student/id/{id}")
		public int callPatchStudents(@PathVariable("id") int studentsId,
				@RequestBody StudentsVO vo) {
			return studentsService.updateStudents(studentsId, vo);
		}
}
