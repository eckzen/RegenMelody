<?php
session_start();
require 'config.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];

    $sql = "SELECT * FROM users WHERE username='$username'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        if (password_verify($password, $row['password'])) {
            $_SESSION['username'] = $username;
            $_SESSION['user_id'] = $row['id']; // Almacena el user ID en la sesión
            echo 'success'; // Respuesta de éxito para AJAX
            exit();
        } else {
            echo "Incorrect password";
        }
    } else {
        echo "No user found";
    }
}
?>
