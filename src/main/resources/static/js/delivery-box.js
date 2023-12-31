$(document).ready(function () {
    $("#sidebar-delivery-box-link").addClass("active");

    $("#back").click(() => {
        window.location.replace("http://localhost:8080/my-page");
    });

    $("#sendDeliveryButton").click(() => {
        window.location.replace("http://localhost:8080/send-delivery");
    });

    $(".cancelButtons").click((button) => {
        let targetId = $(button.currentTarget).attr("id");
        targetId = targetId.split("_");
        let query = {
            url: '/delivery/cancel/' + targetId[0],
            type: 'POST',
            contentType: "application/x-www-form-urlencoded"
        };
        ajax(query);
    });

    $(".rejectButtons").click((button) => {
        let targetId = $(button.currentTarget).attr("id");
        targetId = targetId.split("_");
        let query = {
            url: '/delivery/reject/' + targetId[0],
            type: 'POST',
            contentType: "application/x-www-form-urlencoded"
        };
        ajax(query);
    });

    $(".acceptButtons").click((button) => {
        let targetId = $(button.currentTarget).attr("id");
        targetId = targetId.split("_");
        let query = {
            url: '/delivery/accept/' + targetId[0],
            type: 'POST',
            contentType: "application/x-www-form-urlencoded"
        };
        ajax(query);
    });

    function ajax(query) {
        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
            window.location.reload();
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