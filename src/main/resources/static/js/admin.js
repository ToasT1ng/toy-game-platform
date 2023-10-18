// import { ajax } from "./ajax.js"

$(document).ready(function () {
    let currentActiveSidebar;
    let currentGoldType = $("#productGoldType").val();
    if (currentGoldType == "none") {
        $('#sidebar-store-entire-link').addClass("active");
        currentActiveSidebar = $('#sidebar-store-entire-link');
    } else if (currentGoldType == "ruby") {
        $('#sidebar-store-ruby-link').addClass("active");
        currentActiveSidebar = $('#sidebar-store-ruby-link');
    } else {
        $('#sidebar-store-diamond-link').addClass("active");
        currentActiveSidebar = $('#sidebar-store-diamond-link');
    }

    $('#sidebar-store-entire-link').click((aTag) => {
        currentActiveSidebar.removeClass("active");
        $(aTag.currentTarget).addClass("active");
        currentActiveSidebar = $(aTag.currentTarget);
        $("#productGoldType").val("none");
    });

    $('#sidebar-store-ruby-link').click((aTag) => {
        currentActiveSidebar.removeClass("active");
        $(aTag.currentTarget).addClass("active");
        currentActiveSidebar = $(aTag.currentTarget);
        $("#productGoldType").val("ruby");
    });

    $('#sidebar-store-diamond-link').click((aTag) => {
        currentActiveSidebar.removeClass("active");
        $(aTag.currentTarget).addClass("active");
        currentActiveSidebar = $(aTag.currentTarget);
        $("#productGoldType").val("diamond");
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

    $(".deleteButton").click((button) => {
        let deleteId = $(button.currentTarget).attr("data-whatever");
        let query = {
            url: '/store-products/' + deleteId,
            type: 'DELETE',
            headers: {Authorization:  $("#token").val()}
        };
        ajax(query);
    });

    function ajax(query) {
        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
            location.reload();
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