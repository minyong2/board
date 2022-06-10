<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/resources/static/css/login.css" />
    <title>게시판 로그인</title>
  </head>
  <body>
    <div class="container">
      <h1>Login</h1>
      <div class="login-form">
        <div class="txt-field">
          <input id="userId" type="text" required />
          <label>이름</label>
        </div>
        <div class="txt-field">
          <input id="userPassword" type="password" required />
          <label>비밀번호</label>
        </div>
        <input class="login-btn" type="butten" value="로그인" onclick="join()"/>
        <div class="signup-link">회원이 아닌가요? <a href="/join">회원가입</a></div>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
    <script>
      function join(){
        var userId = $('#userId').val();
        var userPassword = $('#userPassword').val();


        if(userId == ''||userPassword==''){
          alert('회원 정보를 정확히 입력해주십시오.');
          return false;
        }

        var jsonData = {
          studentsName : userId,
          studentsPassword : userPassword

        }

        $.ajax({
          url : 'http://localhost:8080/api/v1/login',
          type : 'POST',
          contentType : 'application/json',
          data : JSON.stringify(jsonData),
          success : function(response){
            if(response){
              location.href = 'board/index.html'
            }else{
              alert('아이디 혹은 비밀번호가 틀렸습니다.')
            }
            
          }
        })
      }
   </script>
  </body>
</html>