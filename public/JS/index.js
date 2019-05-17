var BASE_URI = "http://localhost:8080/dsaApp";


$(document).ready(function() {
    // Add smooth scrolling to all links in navbar + footer link
    $(".navbar a, footer a[href='#myPage']").on('click', function (event) {
        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash
            var hash = this.hash;

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 900, function () {

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });
    $(window).scroll(function () {
        $(".slideanim").each(function () {
            var pos = $(this).offset().top;

            var winTop = $(window).scrollTop();
            if (pos < winTop + 600) {
                $(this).addClass("slide");
            }
        });
    });

    console.log("LOOOOOOGIN!!!!");
    $("#login_button").click(function () {

        var username = $("#username").val();
        console.log(username);
        var password = $("#password").val();
        console.log(password);
        console.log("Estoy en login script");
        //Create the object that we want to pass, which is user
        var user = {
            "username": "mario",
            "password": "mario",
        };
        console.log("****** USER !!!!!!! ", user);
        console.log(JSON.stringify(user));
        $.ajax({
            type: 'POST',
            url: BASE_URI.concat("/user/login"),
            contentType: "application/json",
            data: JSON.stringify(user),
            dataType: 'json',
            success: function (data) {
                console.log("Log in succesfully");
                console.log(data);
                console.log(url);
            },
            error: function (error) {
                console.log("error'''''':", error);
            }
        });
    })
});
