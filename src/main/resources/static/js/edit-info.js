$(document).ready(function () {
    $("#sidebar-my-page-link").addClass("active");

    $("#editInfo").click(() => {
        let query = {
            url: '/account',
            type: 'PUT',
            data: JSON.stringify({
                userId : $("#userId").val(),
                mailAddress: $("#mailAddress").val(),
                nickname: $("#nickname").val()
            }),
            contentType: "application/json"
        };

        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
            window.location.replace("http://localhost:8080/my-page");
        }).fail((jqXHR, textStatus, errorThrown) => {
            ajaxFail(jqXHR, textStatus, errorThrown);
        });
    });

    function ajaxDone(data, textStatus, jqXHR) {
        console.log('성공');
        console.log(data);
        console.log(textStatus);
        console.log(jqXHR);
    }

    function ajaxFail(jqXHR, textStatus, errorThrown) {
        console.log('실패');
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    }
});