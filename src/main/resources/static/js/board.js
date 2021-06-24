"use strict";

let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });

    },

    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/v1/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("글쓰기가 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert("글쓰기가 안됩니다ㅠ.ㅠ");
        });
    }

};
index.init();