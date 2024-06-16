<?php
session_start();
if (!isset($_SESSION['username'])) {
    header("Location: login.html");
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
</head>
<body>
    <h1>Hola, <?php echo $_SESSION['username']; ?>!</h1>
    <p>This is a protected page. Todo funciona!</p>
    <a href="logout.php">Cerrar sesión</a>
    
    <script>
        setTimeout(function() {
            window.location.href = 'mixes.html';
        }, 3000); // Redirigir después de 3 segundos
    </script>
</body>
</html>
