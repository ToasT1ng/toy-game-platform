// import { ajax } from "./ajax.js"

$(document).ready(function () {
    $("#back").click(() => {
        window.location.replace("http://localhost:8080");
    });

    $("#createButton").click(() => {
        let query = {
            url: '/store-products',
            type: 'POST',
            headers: {Authorization:  $("#token").val()},
            data: {
                category: $("#category").val(),
                name: $("#name").val(),
                type : $("#type").val(),
                price: $("#price").val()
            },
            contentType: "application/x-www-form-urlencoded"
        };
        ajax(query);
    });

    $("#deleteButton").click(() => {
        let query = {
            url: '/store-products/' + $("#deleteId").val(),
            type: 'DELETE',
            headers: {Authorization:  $("#token").val()}
        };
        ajax(query);
    });

    let cartItems = [];


    $("#purchaseButton").click(() => {
        let query = {
            url: '/orders',
            type: 'POST',
            headers: {Authorization:  $("#token").val()},
            data: JSON.stringify({
                productId : $("#cartProductId").val(),
                amount : $("#cartProductAmount").val(),
                userId : $("#userId").val()
            }),
            contentType: "application/json"
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