# RegenMelody

Regenmelody es una aplicación web para disfrutar de sonidos ambientales relajantes.


# Guía de Usuario:

Funcionalidades

Reproducción de sonidos ambientales como lluvia, truenos, olas, ríos, pájaros, fuego y viento.
Ajuste del volumen de cada sonido con controles deslizantes.
Cambio dinámico del video de fondo.
Navegación sencilla a través de las páginas principales (Inicio, About, Contacto, Mixes y Login).

Mixes Personalizados
Crear y Recuperar Mixes

Guardar Mix:

Selecciona los sonidos deseados ajustando los controles deslizantes.
Haz clic en el botón "Guardar Mix" para guardar la configuración actual como un mix personalizado.
Recuperar Mix:

Accede a la página "Mixes" desde el menú de navegación.
Haz clic en el botón "Recuperar Mix" para cargar y reproducir tus mixes guardados previamente.

Ejemplo de Uso
Crear un Mix Personalizado:

Ajusta los controles deslizantes de los sonidos de lluvia y truenos según tu preferencia.
Haz clic en "Guardar Mix" para almacenar esta combinación como "Mix de Lluvia y Truenos".
Recuperar un Mix Guardado:

Ve a la página "Mixes" desde el menú.
Haz clic en "Recuperar Mix" y selecciona "Mix de Lluvia y Truenos" para reproducir la configuración guardada anteriormente.

Preguntas Frecuentes (FAQ)
1. ¿Cómo puedo cambiar el video de fondo?

Haz clic en el botón "Cambiar Video" ubicado en la esquina superior derecha de la página.

2. ¿Puedo ajustar el volumen de los diferentes sonidos por separado?

Sí, cada tarjeta de sonido tiene un control deslizante que te permite ajustar su volumen individualmente.



# Instrucciones de Configuración y Despliegue
Requisitos previos

Java JDK (versión 11 o superior)
NetBeans IDE (preferiblemente la última versión)
Apache Tomcat (puede ser incluido en NetBeans)
MySQL (se puede utilizar MySQL Workbench)
XAMPP (para el servidor PHP)
Configuración

Clonar el repositorio desde GitHub:
git clone https://github.com/eckzen/RegenMelody.git
cd Regenmelody

Configuración del Servidor MySQL

1. Instalación y Configuración de MySQL:
Instala MySQL y asegúrate de que está corriendo en el puerto 3306.
Crea la base de datos regenmelody y las tablas users y mixes


Configuración y Despliegue del Backend Java (Spring Boot)

1. Configuración del Proyecto en NetBeans:
   
Crea un nuevo proyecto Spring Boot en NetBeans.
Agrega las siguientes dependencias en tu pom.xml:
Configura la conexión a la base de datos y otros parámetros en src/main/resources/application.properties 

Creación de Entidades y Repositorios:
Crea las entidades User y Mix, los repositorios correspondientes y los servicios en tu proyecto.

2. Implementación de Seguridad:
Configura Spring Security para manejar la autenticación y autorización.

3. Ejecuta el Proyecto:
Ejecuta tu aplicación Spring Boot desde NetBeans.


Configuración y Despliegue del Backend PHP (XAMPP)

 Instalación y Configuración de XAMPP:
   
Descarga e instala XAMPP. (no es necesario instalar MySQL en XAMPP puesto que ya se utiliza Workbench)
Asegúrate de que Apache y MySQL están corriendo.

Configuración del Proyecto PHP:
   
Crea un nuevo directorio en el directorio htdocs de XAMPP, por ejemplo, regenmelody-php.
Crea archivos PHP para manejar la lógica de los mixes (login, registro, CRUD de mixes).

Conexión a la Base de Datos:

Configura la conexión a la base de datos en tus scripts PHP, como en db.php

Implementación de Lógica de Negocios:

Crea scripts PHP para manejar el login, registro y gestión de mixes, asegurándote de que pueden interactuar con la base de datos MySQL.
Configuración y Despliegue del Frontend
1. Estructura del Proyecto:
Crea los archivos HTML, CSS y JavaScript en el directorio de la página dentro de htdocs.

2. Interacción con el Backend:
Utiliza AJAX o Fetch API en JavaScript para interactuar con los endpoints del backend (tanto el de Spring Boot como el de PHP).

3. Despliegue:
Asegúrate de que tu frontend está correctamente configurado para hacer solicitudes al backend Java en localhost:8080 y al backend PHP en localhost:80.

Configurar el frontend:

Coloca el contenido HTML en la carpeta de tu servidor web (por ejemplo, htdocs para Apache).
Asegúrate de que las rutas a los recursos (imágenes, videos, sonidos) sean correctas en tu entorno de despliegue.



