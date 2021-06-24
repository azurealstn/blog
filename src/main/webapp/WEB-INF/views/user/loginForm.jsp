<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

    <div class="container">
        <h2 class="mb-4">로그인</h2>
        <form action="/auth/api/v1/user/login" method="POST">
            <div class="form-group">
                <label for="username">아이디:</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="아이디를 입력하세요.">
            </div>
            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요.">
            </div>
            <button id="btn-login" class="btn btn-primary mb-5">로그인</button>
        </form>
    </div>

<%@ include file="../layout/footer.jsp"%>