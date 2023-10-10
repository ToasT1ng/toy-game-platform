$(document).ready(function () {
    $("#back").click(() => {
        window.location.replace("http://localhost:8080");
    });

    $("#deliveryBox").click(() => {
        window.location.replace("http://localhost:8080/deliveryBox");
    });

    $("#logoutButton").click(() => {
        window.location.replace("http://localhost:8080/logout");
    });

    $("#chargeKakaoPayButton").click(() => {
        let query = {
            url: '/charge/diamond/' + $("#exchangeRateId").val(),
            type: 'POST',
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
        });
    });

    $("#deliveryButton").click(() => {
        let query = {
            url: '/delivery',
            type: 'POST',
            data: JSON.stringify({
                senderId: $("#userId").val(),
                receiverId: $("#receiverId").val(),
                items: [
                    {itemId: $("#cartAccountProductId").val(), amount:$("#cartProductAmount").val()}
                ],
                ruby: $("#rubyAmount").val()
            }),
            contentType: "application/json"
        };

        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
            window.location.replace("http://localhost:8080/myPage");
        }).fail((jqXHR, textStatus, errorThrown) => {
            ajaxFail(jqXHR, textStatus, errorThrown);
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