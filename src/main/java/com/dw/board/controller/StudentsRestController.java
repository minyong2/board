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
// 중복되는 url을 @RequestMapping으로 전역변수처럼 뺄 수 있음
@RequestMapping("/api/v1") //api주소에 버전1임
public class StudentsRestController {

	@Autowired
	private StudentsService studentsService;
	
		// 중요한 정보를 서버에 전송할 때 post사용
		@CrossOrigin
		@PostMapping("/login")
		public boolean callIsLogin(@RequestBody StudentsVO vo, HttpSession httpSession) {
			boolean isLogin = studentsService.isStuents(vo,httpSession);
			return isLogin;
		}
	
	
		// 학생 저장
		// post는 body로 데이터를 받음
		// @PostMapping("/api/v1/students") 
		@CrossOrigin 
		@PostMapping("/students")
		public int callSaveStudents(@RequestBody StudentsVO vo) {
			return studentsService.setStudents(vo);
		}
		
		// 학생 조회
//		@CrossOrigin
//		@GetMapping("/students")
//		public List<StudentsVO> callStudentsList(){
//			return studentsService.getAllStudentsList();
//		}
		
		@CrossOrigin
		@GetMapping("/students")
		public PageInfo<Map<String,Object>> callStudentsList(@RequestParam("pageNum")int pageNum,
				@RequestParam("pageSize")int pageSize){
			
			List<Map<String, Object>> list = studentsService.getAllStudentsList(pageNum,pageSize); 
			return new PageInfo<Map<String,Object>>(list);
		}
		
		
		// map으로 학생 조회
		@GetMapping("/students/map")
		public List<Map<String, Object>> callStudentsListByMap(HttpSession httpSession){
			
			// 현재 login메소드에 session로직을 추가해서 login을 먼저 실행 안하면 name = null
//			session데이터 가져오기 (추후 로직구현 예정)
//			String name = (String)httpSession.getAttribute("name");
//			System.out.println("session에서 가져온 이름은 ==> "+name);
//			if(name == null) {
//				return null;
//			}
			return studentsService.getAllStudentsMap();
		}
		
		// 특정 학생 조회(PK로 조회예정)
		@CrossOrigin
		@GetMapping("/students/id/{id}")
		public StudentsVO callStudents(@PathVariable("id") int studentsId) {
			return studentsService.getStudents(studentsId);
		}
		
		//특정 학생 삭제
		@CrossOrigin
		@DeleteMapping("/students/id/{id}")
		public int callRemoveStudents(@PathVariable("id") int studentsId) {
			return studentsService.deleteStudents(studentsId);
		}
		
		//특정 학생 수정
		@CrossOrigin
		@PatchMapping("/students/id/{id}")
		public int callUpdateStudents(@PathVariable("id") int studentsID, 
				@RequestBody StudentsVO vo) {
			return studentsService.getUpdateStudents(vo, studentsID);
		}
		
		
		@CrossOrigin
		@GetMapping("/students/search")
		public PageInfo<Map<String,Object>> callStudentsList(@RequestParam("writer") String writer,
				@RequestParam("pageNum")int pageNum,
				@RequestParam("pageSize")int pageSize){
			List<Map<String, Object>> list = studentsService.getStudentsSearchList(pageNum,pageSize,writer);
			return new PageInfo<Map<String,Object>>(list);
		}
}