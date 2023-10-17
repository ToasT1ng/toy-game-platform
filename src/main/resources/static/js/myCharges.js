$(document).ready(function () {
    $("#sidebar-my-charges-link").addClass("active");

    $("#chargeKakaoPayButton").click(() => {
        let query = {
            url: '/charge/diamond/' + $("#exchangeRateId").val(),
            type: 'POST',
            headers: {Authorization:  $("#token").val()},
            data: {
                userId: $("#userId").val(),
                type: "KAKAO_PAY"
            },
            contentType: "application/x-www-form-urlencoded"
        };

        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
            window.location.replace(data["redirectUrl"]);
        }).fail((jqXHR, textStatus, errorThrown) => {
            ajaxFail(jqXHR, textStatus, errorThrown);
            $("#chargeErrorBox").prepend(jqXHR.responseText);
        });
    });

    // $("#chargePaycoButton").click(() => {
    //     let query = {
    //         url: '/charge/diamond/' + $("#exchangeRateId").val(),
    //         type: 'POST',
    //         data: {
    //             userId: $("#userId").val(),
    //             type: "PAYCO"
    //         },
    //         contentType: "application/x-www-form-urlencoded"
    //     };
    //     ajax(query);
    // });


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