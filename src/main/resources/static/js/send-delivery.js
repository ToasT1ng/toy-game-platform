$(document).ready(function () {
    $("#sidebar-delivery-box-link").addClass("active");

    $(".addDeliveryButtons").click((button) => {
        let targetId = $(button.currentTarget).attr("id");
        let cartElements = targetId.split("_");
        $("#cartArea").append("<div><p class='eachCart'>아이템의 상품 아이디 <input type=\"number\" class=\"cartProductIds\" value='"+cartElements[1]+"' disabled> 갯수 <input type=\"number\" class=\"cartProductAmounts\"> <button class=\"btn deleteDeliveryButtons\">삭제하기</button></p></div>");
    });

    $('#cartArea').on('click', '.deleteDeliveryButtons', function() {
        $(this).closest('div').remove();
    });

    $("#deliveryButton").click(() => {
        let items = [];
        $('.eachCart').each(function() {
            let item = {
                productId: $(this).find(".cartProductIds").val(), amount:$(this).find(".cartProductAmounts").val()
            }
            items.push(item);
        });

        let query = {
            url: '/delivery',
            type: 'POST',
            data: JSON.stringify({
                senderId: $("#userId").val(),
                receiverUsername: $("#receiverUsername").val(),
                items: items,
                ruby: $("#rubyAmount").val()
            }),
            contentType: "application/json"
        };

        $.ajax(query).done((data, textStatus, jqXHR) => {
            ajaxDone(data, textStatus, jqXHR);
            window.location.replace("http://localhost:8080/delivery-box");
        }).fail((jqXHR, textStatus, errorThrown) => {
            ajaxFail(jqXHR, textStatus, errorThrown);
        });
    });

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