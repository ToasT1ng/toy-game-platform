$(document).ready(function () {
    $("#sidebar-my-page-link").addClass("active");

    $("#logoutButton").click(() => {
        window.location.replace("http://localhost:8080/logout");
    });
});