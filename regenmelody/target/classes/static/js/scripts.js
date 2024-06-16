document.addEventListener("DOMContentLoaded", function() {
  const sounds = {};
  
  document.querySelectorAll('.card img').forEach(img => {
      const sound = new Audio(`media/${img.dataset.sound}`);
      sound.loop = true;  // Hacer que los sonidos se reproduzcan en bucle
      sounds[img.dataset.sound] = sound;
  //Función anónima que mantiene el play al hacer click en una imagen, la cual mantiene el hover active
      img.addEventListener('click', function() {
          if (sound.paused) {
              sound.play();
          } else {
              sound.pause();
          }
          img.classList.toggle('active');
      });
  });

  // Variables que toman id
  const rainVolume = document.getElementById("rainVolume");
  const thunderVolume = document.getElementById("thunderVolume");
  const wavesVolume = document.getElementById("wavesVolume");
  const riversVolume = document.getElementById("riversVolume");
  const birdsVolume = document.getElementById("birdsVolume");
  const fireVolume = document.getElementById("fireVolume");
  const cricketsVolume = document.getElementById("cricketsVolume");
  const windVolume = document.getElementById("windVolume");

  
  

  /* Control de volumen input */
  const volumeControls = {
    rainVolume: "rain.mp3",
    thunderVolume: "thunder.mp3",
    wavesVolume: "waves.mp3",
    riversVolume: "rivers.mp3",
    birdsVolume: "birds.mp3",
    fireVolume: "fire.mp3",
    cricketsVolume: "crickets.mp3",
    windVolume: "wind.mp3"
  };

  // Funciones play
  Object.keys(volumeControls).forEach(controlId => {
    const control = document.getElementById(controlId);
    control.addEventListener("input", function() {
      const soundFile = volumeControls[controlId];
      if (sounds[soundFile]) {
        sounds[soundFile].volume = control.value / 100;
      }
    });
  });
  // Funciones Play sin simplificar código
  // rainVolume.addEventListener("input", function() {
  //   sounds["rain.mp3"].volume = rainVolume.value / 100;
  // });
  // thunderVolume.addEventListener("input", function() {
  //   sounds["media/thunder.mp3"].volume = thunderVolume.value / 100;
  // });
  // resto de funciones (Waves, Rivers, etc)

});

// Botón para cambiar el video de fondo
const videos = ["media/video1.mp4", "media/video2.mp4", "media/video3.mp4"];
let currentVideoIndex = 0;
const backgroundVideo = document.getElementById("backgroundVideo");
const changeVideoButton = document.getElementById("btn-change-video");

changeVideoButton.addEventListener("click", function() {
   currentVideoIndex = (currentVideoIndex + 1) % videos.length;
   backgroundVideo.querySelector("source").src = videos[currentVideoIndex];
   backgroundVideo.load();
   backgroundVideo.play();
});



//Botón hacia arriba

//variable toma botón
let botonarriba = document.getElementById("btn-back-to-top");

// Cuando se hace scroll down 20px desde el top, muestra el boton
window.onscroll = function () {
funcionScroll();
};

function funcionScroll() {
if ( document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
       botonarriba.style.display = "block";
} else {
       botonarriba.style.display = "none";
}
}
// Al hacer click, vuelve al top
botonarriba.addEventListener("click", volverAlTop);

function volverAlTop() {
document.body.scrollTop = 0;
document.documentElement.scrollTop = 0;
}



/* 
    ___        ___         __        ___              ( )      ___         __
  //   ) )   //   ) )   //   ) )   //___) ) \\ / /   / /     //   ) )   //   ) )
 //         //   / /   //   / /   //         \/ /   / /     //   / /   //   / /
((____     ((___/ /   //   / /   ((____      / /\  / /     ((___/ /   //   / /
*/

document.getElementById('loginForm').addEventListener('submit', function(e) {
  e.preventDefault(); // Previene que el formulario se envíe de la manera tradicional
  
  const username = document.getElementById('username').value; 
  const password = document.getElementById('password').value; 

  fetch('/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify({ username: username, password: password })
  })
  .then(response => response.json())
  .then(data => {
      if (data.success) {
          // Redirigir a la página principal o mostrar un mensaje de éxito
          window.location.href = '404.html';
      } else {
          // Mostrar un mensaje de error
          alert('Login failed: ' + data.message);
      }
  })
  .catch(error => {
      console.error('Error:', error);
  });
});

