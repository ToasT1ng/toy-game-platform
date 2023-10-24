$(document).ready(function () {
    $("#sidebar-my-page-link").addClass("active");

    $("#editAccount").click(() => {
        window.location.replace("http://localhost:8080/edit-info");
    });

    $("#editPassword").click(() => {
        window.location.replace("http://localhost:8080/edit-password");
    });
});