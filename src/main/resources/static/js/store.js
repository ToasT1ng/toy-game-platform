// import { ajax } from "./ajax.js"

$(document).ready(function () {

    $(".launch-purchase-modal").click((button) => {
        let targetId = $(button.currentTarget).attr("data-whatever");
        console.log(targetId);
        $("#cartProductId").val(targetId);
        $('.exampleModal').modal('show');
    });

    $("#close-purchase-modal").click((button) => {
        $('.exampleModal').modal('hide');
    });



    // $("#exampleModal").on('shown.bs.tab', function () {
    //     var button = event.relatedTarget
    //     // Extract info from data-bs-* attributes
    //     var recipient = button.getAttribute('data-bs-whatever')
    //     // If necessary, you could initiate an AJAX request here
    //     // and then do the updating in a callback.
    //     //
    //     // Update the modal's content.
    //     var modalTitle = exampleModal.querySelector('.modal-title')
    //     var modalBodyInput = exampleModal.querySelector('.modal-body input')
    //
    //     modalTitle.textContent = 'New message to ' + recipient
    //     modalBodyInput.value = recipient
    // });

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