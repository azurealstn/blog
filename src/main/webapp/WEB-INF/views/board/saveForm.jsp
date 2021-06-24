<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

    <div class="container">
        <h2 class="mb-4">글쓰기</h2>
        <form>
            <div class="form-group">
                <label for="title">제목:</label>
                <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요.">
            </div>
            <div class="form-group">
                <label for="content">내용:</label>
                <textarea class="form-control summernote" rows="5" id="content"></textarea>
            </div>
        </form>
        <button id="btn-save" class="btn btn-primary mb-5">글쓰기</button>
    </div>
    <script src="/js/summerNote.js"></script>
    <script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>