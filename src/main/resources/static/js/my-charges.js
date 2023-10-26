$(document).ready(function () {
    $("#sidebar-my-charges-link").addClass("active");

    $(".launch-charge-modal").click((button) => {
        let radioValue = $("input[name='chargeRadio']:checked").val();
        let selectedInfo = radioValue.split("_");
        console.log(selectedInfo[0]);
        $("#exchangeRateId").val(selectedInfo[0]);
        $("#exchangeRateId").after(selectedInfo[0]);
        $("#chargeAmount").after(selectedInfo[2] + "개");
        $("#chargePrice").after(selectedInfo[1] + "원");
        $('#chargeModal').modal('show');
    });

    $("#close-charge-modal").click((button) => {
        $('#chargeModal').modal('hide');
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