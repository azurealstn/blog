<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

    <div class="container">
        <h2 class="mb-4">로그인</h2>
        <form action="/action_page.php">
            <div class="form-group">
                <label for="username">아이디:</label>
                <input type="username" class="form-control" id="username" placeholder="아이디를 입력하세요.">
            </div>
            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요.">
            </div>

            <div class="form-group form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> Remember me
                </label>
            </div>
            <button type="submit" class="btn btn-primary mb-5">로그인</button>
        </form>
    </div>

<%@ include file="../layout/footer.jsp"%>