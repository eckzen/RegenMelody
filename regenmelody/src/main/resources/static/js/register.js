document.addEventListener('DOMContentLoaded', (event) => {
    const registerForm = document.getElementById('registerForm');

    registerForm.addEventListener('submit', function(event) {
        event.preventDefault();
        
        const formData = new FormData(registerForm);
        const nombreUsuario = formData.get('nombreUsuario');
        let contraseña = formData.get('contraseña');
        console.log("contraseña: " + contraseña);
        if (!contraseña) {
            alert('La contraseña no puede estar vacía.');
            return;
        }

        const registerData = {
            nombreUsuario: nombreUsuario,
            contraseña: contraseña
        };

        console.log(registerData); // Verificar datos en la consola

        fetch('/usuarios/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(registerData)
        })
        .then(response => {
            if (response.ok) {
                alert('Registro exitoso. Ahora puede iniciar sesión.');
                window.location.href = '/login.html';
            } else {
                return response.text().then(text => { throw new Error(text); });
            }
        })
        .catch(error => {
            alert('Registro fallido: ' + error.message);
        });
    });
});



