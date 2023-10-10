$(document).ready(function () {
    $("#loginButton").click(() => {
        window.location.replace("http://localhost:8080/login");
    });

    $("#signUpButton").click(() => {
        window.location.replace("http://localhost:8080/signup");
    });
});