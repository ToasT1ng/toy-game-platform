// import { ajax } from "./ajax.js"

$(document).ready(function () {
    $('#sidebar-store-entire-link').addClass("active");
    let currentActiveSidebar = $('#sidebar-store-entire-link');

    $('#sidebar-store-entire-link').click((aTag) => {
        currentActiveSidebar.removeClass("active");
        $(aTag.currentTarget).addClass("active");
        currentActiveSidebar = $(aTag.currentTarget);
    });

    $('#sidebar-store-ruby-link').click((aTag) => {
        currentActiveSidebar.removeClass("active");
        $(aTag.currentTarget).addClass("active");
        currentActiveSidebar = $(aTag.currentTarget);
    });

    $('#sidebar-store-diamond-link').click((aTag) => {
        currentActiveSidebar.removeClass("active");
        $(aTag.currentTarget).addClass("active");
        currentActiveSidebar = $(aTag.currentTarget);
    });

    $(".launch-purchase-modal").click((button) => {
        let targetId = $(button.currentTarget).attr("data-whatever");
        console.log(targetId);
        $("#cartProductId").val(targetId);
        $('#storeModal').modal('show');
    });

    $("#close-purchase-modal").click((button) => {
        $('#storeModal').modal('hide');
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
            setTimeout(() => $('#storeModal').modal('hide'), 3000);
            $("#purchase-success-paragraph").removeClass("d-none");
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