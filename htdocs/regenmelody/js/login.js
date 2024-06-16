$(document).ready(function() {
    $('#loginForm').submit(function(e) {
        e.preventDefault(); // Evita que el formulario se envíe normalmente

        // Obtén los valores de usuario y contraseña
        var username = $('#username').val();
        var password = $('#password').val();

        // Envia la solicitud AJAX
        $.ajax({
            type: 'POST',
            url: 'login.php',
            data: {
                username: username,
                password: password
            },
            success: function(response) {
                // Si el login es exitoso, redirige a la página de bienvenida
                if (response === 'success') {
                    window.location.href = 'success.php';
                } else {
                    // Muestra el mensaje de error si hay algún problema
                    $('#error').html(response);
                }
            }
        });
    });
});

/*
jQuery y AJAX: El código jQuery captura el evento de envío del formulario ($('#loginForm').submit(function(e) {...}) 
y evita que se envíe normalmente (e.preventDefault()). Luego, recoge los valores de username y password, 
y realiza una solicitud POST a login.php.
*/ 