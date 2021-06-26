"use strict";

let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
/*        $("#btn-login").on("click", () => {
            this.login();
        });*/
        $("#btn-update").on("click", () => {
            this.update();
        });

    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        $.ajax({
            type: "POST",
            url: "/auth/api/v1/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("회원가입이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert("다른 아이디로 설정해주세요!");
        });
    },
/*로그인 ajax    login: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/v1/user/login",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("로그인이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert("아이디 혹은 비밀번호가 잘못되었습니다.");
        });
    }*/
    update: function () {
        let data = {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        $.ajax({
            type: "PUT",
            url: "/api/v1/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("회원수정이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert("회원수정이 실패하였습니다ㅠ.ㅠ");
        });
    },
};
index.init();