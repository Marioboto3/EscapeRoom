var contfusil;
var contcorredera;
var contkatana;
var contclueyellow;
var contclueblue;
var contcluered;
var contkeyyellow;
var contkeyblue;
var contkeyred;
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
    $.get("http://localhost:8080/dsaApp/user/inventory", function (data) {
        $.each(data, function (index, element) {
            if (data.name.equals("fusildetambor")) {
                contfusil = 1;
            }
            if (data.name.equals("katana")) {
                contkatana = 1;
            }
            if (data.name.equals("corredera")) {
                contcorredera = 1;
            }
            if (data.name.equals("keyblue")) {
                contkeyblue++;
            }
            if (data.name.equals("keyred")) {
                contkeyred++;
            }
            if (data.name.equals("keyyellow")) {
                contkeyyellow++;
            }
            if (data.name.equals("clueblue")) {
                contclueblue++;
            }
            if (data.name.equals("cluered")) {
                contcluered++;
            }
            if (data.name.equals("clueyellow")) {
                contclueyellow++;
            }
        })
        if (contfusil == 0) {
            document.getElementById('fusildetambor').src = "https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedor_fusil');
            conte.style.display = "none";
        } else {
            document.getElementById('fusildetambor').src = "https://3.bp.blogspot.com/-_7onQnAUhjk/W0Zgdxl1YTI/AAAAAAAADHk/-DUkca9CbAguymTgJ64cY-uen7JTZ88ngCLcBGAs/s1600/THOMPSON.png";
            var conte = document.getElementById('contenedor_fusil');
            conte.style.display = "block";
        }
        if (contcorredera == 0) {
            document.getElementById('corredera').src = "https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedor_corredera');
            conte.style.display = "none";
        } else {
            document.getElementById('corredera').src = "https://fortniteestadisticas.com/assets/img//weapons/double-barrel-shotgun.png";
            var conte = document.getElementById('contenedor_corredera');
            conte.style.display = "block";
        }
        if (contkatana == 0) {
            document.getElementById('katana').src = "https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedor_corredera');
            conte.style.display = "none";
        }
        else{
            document.getElementById('katana').src ="https://puregaming.es/wp-content/uploads/2019/01/Dw8klLOWkAEhrTX.png";
            var conte = document.getElementById('contenedor_corredera');
            conte.style.display = "block";
        }
        if(contclueyellow==0) {
            document.getElementById('clueyellow').src = "https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedor_yellow');
            conte.style.display = "none";
            var conta = document.getElementById('contador_yellow');
            conta.style.display = "none";
        }
        else{
            document.getElementById('clueyellow').src ="https://i.pinimg.com/originals/d3/c8/60/d3c860c48ad9f9bb48346528f74d3f48.png";
            var conte = document.getElementById('contenedor_yellow');
            conte.style.display = "block";
            var conta = document.getElementById('contador_yellow').innerText=contclueyellow;
            conta.style.display = "block";
        }
        if(contclueblue==0) {
            document.getElementById('clueblue').src ="https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedor_blue');
            conte.style.display = "none";
            var conta = document.getElementById('contador_blue');
            conta.style.display = "none";
        }
        else{
            document.getElementById('clueblue').src ="https://4.bp.blogspot.com/-w6rNRWPnMFU/UmFae6uZLyI/AAAAAAAABBM/-R1T3m-Pm2I/s640/preguntas.png";
            var conte = document.getElementById('contenedor_blue');
            conte.style.display = "block";
            var conta = document.getElementById('contador_blue').innerText=contclueblue;
            conta.style.display = "block";
        }
        if(contcluered==0) {
            document.getElementById('cluered').src ="https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedor_red');
            conte.style.display = "none";
            var conta = document.getElementById('contador_red');
            conta.style.display = "none";
        }
        else{
            document.getElementById('cluered').src ="https://pngimage.net/wp-content/uploads/2018/06/interrogantes-png-6.png";
            var conte = document.getElementById('contenedor_red');
            conte.style.display = "block";
            var conta = document.getElementById('contador_red').innerText=contcluered;
            conta.style.display = "block";
        }
        if(contkeyyellow==0) {
            document.getElementById('keyyellow').src ="https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedorkey_yellow');
            conte.style.display = "none";
            var conta = document.getElementById('contadorkey_yellow');
            conta.style.display = "none";
        }
        else{
            document.getElementById('keyyellow').src ="https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/59904610_2381158021936904_3630824489995993088_n.jpg?_nc_cat=105&_nc_ht=scontent-mad1-1.xx&oh=b09ac4773b91ee855ae246c60469be4e&oe=5D2FAC40";
            var conte = document.getElementById('contenedorkey_yellow');
            conte.style.display = "block";
            var conta = document.getElementById('contadorkey_yellow').innerText=contkeyyellow;
            conta.style.display = "block";
        }
        if(contkeyblue==0) {
            document.getElementById('keyblue').src ="https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedorkey_blue');
            conte.style.display = "none";
            var conta = document.getElementById('contadorkey_blue');
            conta.style.display = "none";
        }
        else{
            document.getElementById('keyblue').src ="https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/59627072_2381151755270864_7056317532851929088_n.jpg?_nc_cat=111&_nc_ht=scontent-mad1-1.xx&oh=2b3a0a634a078c0fdd3e487fccfac39d&oe=5D5EBFF3";
            var conte = document.getElementById('contenedorkey_blue');
            conte.style.display = "block";
            var conta = document.getElementById('contadorkey_blue').innerText=contkeyblue;
            conta.style.display = "block";
        }
        if(contkeyred==0) {
            document.getElementById('keyred').src ="https://pngimage.net/wp-content/uploads/2018/05/candados-png-6.png";
            var conte = document.getElementById('contenedorkey_red');
            conte.style.display = "none";
            var conta = document.getElementById('contadorkey_red');
            conta.style.display = "none";
        }
        else{
            document.getElementById('keyred').src ="https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/60104433_2381144115271628_7427805772727189504_n.jpg?_nc_cat=103&_nc_ht=scontent-mad1-1.xx&oh=ea2c6e453da7810df10e08054d6b06f3&oe=5D68709D";
            var conte = document.getElementById('contenedorkey_red');
            conte.style.display = "block";
            var conta = document.getElementById('contadorkey_red').innerText=contkeyred;
            conta.style.display = "block";
        }
    }, "json");
});
