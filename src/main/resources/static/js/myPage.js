// import { ajax } from "./ajax.js"

$(document).ready(function () {
    $("#chargeButton").click(() => {
        let query = {
            url: '/charge/diamond/' + $("#exchangeRateId").val(),
            type: 'POST',
            data: {
                userId: $("#userId").val()
            },
            contentType: "application/x-www-form-urlencoded"
        };
        ajax(query);
    });

    function ajax(query) {
        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
        }).fail((jqXHR, textStatus, errorThrown) => {
            ajaxFail(jqXHR, textStatus, errorThrown);
        });
    }

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