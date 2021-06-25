<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

    <div class="container">
        <h2 class="mb-4">글 상세보기</h2>
        <c:if test="${board.user.id == principal.user.id}">
            <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
            <button id="btn-delete" class="btn btn-danger">삭제</button>
        </c:if>
        <br /><br />
        <div>
            글 번호: <span id="id"><i>${board.id} </i></span> |
            작성자: <span><i>${board.user.username} </i></span>
        </div>
        <br />
        <div class="form-group">
            <h2>제목: ${board.title}</h2>
        </div>
        <hr />
        <div class="form-group">
            <h5>내용: ${board.content}</h5>
        </div>
        <button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
        <br /><br />
    </div>

    <script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>