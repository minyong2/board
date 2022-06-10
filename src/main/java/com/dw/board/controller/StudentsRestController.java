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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.StudentsService;
import com.dw.board.vo.StudentsVO;
import com.github.pagehelper.PageInfo;

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

	//학생 전체 조회
		@CrossOrigin
		@GetMapping("/student")
		public PageInfo<Map<String,Object>> callStudentsList(@RequestParam("pageNum")int pageNum,
				@RequestParam("pageSize")int pageSize){
			
			List<Map<String,Object>> list = studentsService.selectStudentsList(pageNum, pageSize);
			return new PageInfo<Map<String, Object>>(list);
		}
		
//		@GetMapping("/student/map")
//		public List<Map<String, Object>> callStudentsListByMap(HttpSession httpSession){
////			String name = (String)httpSession.getAttribute("name");
////			System.out.println("세션에서 가져온 이름은 ===>" + name);
//			return studentsService.getStudentsListByMap();
//		}
		
	//특정 학생 조회(PK로 조회)
		@GetMapping("/student/id/{id}")
		public StudentsVO callStudent(@PathVariable("id") int studentsId) {
			return studentsService.selectStudents(studentsId);
		}
		
	//특정 학생 삭제
		@CrossOrigin
		@DeleteMapping("/student/id/{id}")
		public int callRemoveStudents(@PathVariable("id") int studentsId) {
			return studentsService.removeStudents(studentsId);
		}
		
	// 특정 학생 수정
		@CrossOrigin
		@PatchMapping("/student/id/{id}")
		public int callPatchStudents(@PathVariable("id") int studentsId,
				@RequestBody StudentsVO vo) {
			return studentsService.updateStudents(studentsId, vo);
		}

	//클릭한 학생 상세 조회
		@CrossOrigin
		@GetMapping("/student/detail/{studentsId}")
		public StudentsVO selectDetailStudents(@PathVariable("studentsId") int studentsId) {
			
			return studentsService.selectDetailStudents(studentsId);
		}
		
		//학생 검색하기
		@CrossOrigin
		@GetMapping("/student/search")
		public List<Map<String, Object>> selectSearchStudents(@RequestParam("studentsName") String studentsName,
				@RequestParam("pageNum") int pageNum,
				@RequestParam("pageSize") int pageSize){
			
			List<Map<String,Object>> list = studentsService.selectSearchStudents(studentsName,pageNum,pageSize);
//			return new PageInfo<Map<String,Object>>(list);
			return null;
		}
}
