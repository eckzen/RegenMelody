<?php
session_start();
require 'config.php';

if (!isset($_SESSION['user_id'])) {
    echo json_encode(['success' => false, 'error' => 'Not logged in']);
    exit();
}

$user_id = $_SESSION['user_id'];
$data = json_decode(file_get_contents('php://input'), true);
$selectedSounds = $data['selectedSounds'];
$mixName = $data['mixName']; // Nombre del mix enviado desde el cliente

if (empty($selectedSounds)) {
    echo json_encode(['success' => false, 'error' => 'No sounds selected']);
    exit();
}

// Convertir la lista de sonidos a formato JSON
$soundsJson = json_encode($selectedSounds);

$sql = "INSERT INTO mixes (user_id, name, sounds) VALUES (?, ?, ?)";
$stmt = $conn->prepare($sql);

if ($stmt) {
    $stmt->bind_param('iss', $user_id, $mixName, $soundsJson);

    if ($stmt->execute()) {
        echo json_encode(['success' => true]);
    } else {
        echo json_encode(['success' => false, 'error' => $stmt->error]);
    }

    $stmt->close();
} else {
    echo json_encode(['success' => false, 'error' => $conn->error]);
}

$conn->close();
?>