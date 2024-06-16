document.addEventListener('DOMContentLoaded', (e) => {
    const loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Evita que el formulario se envíe de la manera tradicional
       
        const formData = new FormData(loginForm);
        const loginData = {
            nombreUsuario: formData.get('nombreUsuario'),
            contraseña: formData.get('contraseña')
        };
        console.log(loginData);

        fetch('/usuarios/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData) 
        })
        .then(response => {
            if (response.ok) {
                alert('Log in exitoso! Será redirigido a la página protegida de usuarios');
                window.location.href = 'protected/protected.html';
            } else {
                return response.text().then(text => { throw new Error(text); });
            }
        })
        .catch(error => {
            alert('Login fallido: ' + error.message);
        });
    });

    //Botón Registro
    const botonRegistro = document.getElementById('botonRegistro');

    botonRegistro.addEventListener('click', function() {
        // Redirigir a la página de register
        window.location.href = '/register.html';
    });
});



