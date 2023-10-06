$(document).ready(function () {
    $("#myPage").click(() => {
        window.location.replace("http://localhost:8080/myPage");
    });

    $("#store").click(() => {
        window.location.replace("http://localhost:8080/store");
    });
});