// import { ajax } from "./ajax.js"

$(document).ready(function () {
    $("#back").click(() => {
        window.location.replace("http://localhost:8080");
    });

    $("#createButton").click(() => {
        let query = {
            url: '/store-products',
            type: 'POST',
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
            type: 'DELETE'
        };
        ajax(query);
    });

    let cartItems = [];

    $("#addCartButton").click(() => {
        let productId = $("#cartProductId").val();
        let amount = $("#cartProductAmount").val();
        $("#cart").prepend("<p> 제품 아이디 : " + productId + " / 갯수 : " + amount + "</p>");

        cartItems.push({productId : productId, amount : amount});
    });

    $("#clearCartButton").click(() => {
        cartItems = [];
        $("#cart").empty();
    });

    $("#purchaseButton").click(() => {
        let query = {
            url: '/orders',
            type: 'POST',
            data: JSON.stringify({cart: cartItems}),
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