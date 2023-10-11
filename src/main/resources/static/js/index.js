$(document).ready(function () {
    $("#myPage").click(() => {
        window.location.replace("http://localhost:8080/myPage");
    });

    $("#store").click(() => {
        window.location.replace("http://localhost:8080/store");
    });

    $("#game").click(() => {
        window.location.replace("http://localhost:8080/game");
    });
});