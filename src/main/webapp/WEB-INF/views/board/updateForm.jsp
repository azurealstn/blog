<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

    <div class="container">
        <h2 class="mb-4">글쓰기</h2>
        <form>
            <input type="hidden" id="id" value="${board.id}">
            <div class="form-group">
                <label for="title">제목:</label>
                <input value="${board.title}" type="text" class="form-control" id="title" placeholder="제목을 입력하세요.">
            </div>
            <div class="form-group">
                <label for="content">내용:</label>
                <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
            </div>
        </form>
        <button id="btn-update" class="btn btn-primary mb-5">글수정</button>
    </div>

    <script src="/js/summerNote.js"></script>
    <script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>