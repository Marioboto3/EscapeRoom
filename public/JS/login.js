var value1="";

function setCookie(cname,cvalue,exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var user = getCookie("username");
    console.log("user;", user);
    if (user != "") {
        alert("Hola: "+ user);
        value1=user;
        var queryString ="?"+value1;
        location.href = "http://localhost:8080/Home.html";
        window.location.href = "Home.html" + queryString;
    }
}
$(document).ready(function(){
    console.log("Va cojones");
    checkCookie();
    $('#login').on('submit', function(e){
        user = $("#loginUsername").val();
        var myObj = {
            username: $("#loginUsername").val(),
            password: $("#loginPassword").val()
        };
        e.preventDefault();
        console.log("Me cago en dios");
        $.ajax({
            type: 'POST',
            url: '/dsaApp/user/login',
            data: JSON.stringify(myObj),
            success: function(data) {
                value1=user;
                setCookie("username", user, 30);
                location.href = "http://localhost:8080/Home.html";
                var queryString ="?"+value1;
                window.location.href = "Home.html" + queryString;
            },
            error: function (xhr, ajaxOptions, thrownError) {
                if(xhr.status===500){
                    alert("Password not match");
                }
                else{
                    alert("User not found");
                }
            },
            contentType: "application/json",
            dataType: 'json'
        });
    });
    $('#register').on('submit', function(e){
        var myObj = {
            username: $("#registerUsername").val(),
            password: $("#registerPassword").val()
        };
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: '/dsaApp/user/register',
            data: JSON.stringify(myObj),
            success: function(data) {
                var username = data.username;
                var password = data.password;
                document.getElementById('registerTextUsername').innerHTML = "Username: "+ username.toString();
                document.getElementById('registerTextPassword').innerHTML = "Password: "+ password.toString();
                var container = document.getElementById('secondRow');
                var registerContainer = document.getElementById('registerResponse');
                container.style.display="block";
                registerContainer.style.display="block";
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert("Existant user");
            },
            contentType: "application/json",
            dataType: 'json'
        });
    });
});