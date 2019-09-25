$(document).ready(function(){

    //Ali--from editProfile.jsp when hit change passwor button
    $("#changePasswordBtn").click(function (event) {
        event.preventDefault();
        let old = $("#old-password").val();
        let newp = $("#new-password").val();
        let repeat = $("#repeat-password").val();

        let domain = document.URL;
        let url = domain.replace("view/user/editProfile.jsp","");
        url = url + "changePassword";

        $.post(url, {"old-password": old, "new-password": newp, "repeat-password": repeat})
            .then(function (response) {
                $("#errorMsg").text(response);
            })

    });

});