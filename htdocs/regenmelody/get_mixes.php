<?php
$servername = "localhost";
$username = "root";
$password = "wilsontiger3"; 
$dbname = "regenmelody";
$port = 3306;

$conn = new mysqli($servername, $username, $password, $dbname, $port);

// Verificar la conexión
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// Consultar los mixes guardados
$sql = "SELECT id, user_id, name, sounds FROM mixes";
$result = $conn->query($sql);

// Verificar si la consulta fue exitosa
if (!$result) {
  die("Error en la consulta: " . $conn->error);
}

$mixes = array();

// Procesar resultados si hay filas
if ($result->num_rows > 0) {
  while($row = $result->fetch_assoc()) {
    $mixSounds = json_decode($row['sounds']); // Decodificar la cadena JSON de la columna 'sounds'
    $responseData = array(
      'id' => $row['id'],
      'user_id' => $row['user_id'],
      'name' => $row['name'],
      'sounds' => [] // Matriz vacía para guardar datos de sonido y volumen
    );
    
    foreach ($mixSounds as $soundInfo) {
      $responseData['sounds'][] = array(
        'volume' => $soundInfo->volume,
        'soundId' => $soundInfo->soundId
      );
    }
    $mixes[] = $responseData;
  }
}

$conn->close();

header('Content-Type: application/json');
echo json_encode($mixes);
?>