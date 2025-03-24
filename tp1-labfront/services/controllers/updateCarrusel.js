document.addEventListener('DOMContentLoaded', function () {
  const urlParams = new URLSearchParams(window.location.search);
  const empresaId = urlParams.get('id');

  if (empresaId) {
    updateCarrusel(empresaId);
  }
});

export function updateCarrusel(empresaId) {
  const apiUrl = 'http://localhost:8080';
  if (empresaId) {
    fetch(`${apiUrl}/noticia/listar/${empresaId}`)
      .then(response => response.json())
      .then(noticias => {
        const cameraWrap = document.getElementById('camera');
        if (cameraWrap) {
          console.log('cameWrap', cameraWrap);
          cameraWrap.innerHTML = ''; // Limpiar contenido existente

          noticias.slice(0, 5).forEach((noticia, index) => {
            const noticiaDiv = document.createElement('div');
            noticiaDiv.setAttribute('data-src', noticia.imagen);
            noticiaDiv.innerHTML = `
              <div class="camera_caption fadeIn">
                <div class="jumbotron jumbotron${index + 1}">
                  <em>
                    <a href="detalle.html?id=${noticia.id}">${noticia.titulo}</a>
                  </em>
                  <div class="wrap">
                    <p>${noticia.resumen}</p>
                    <a href="detalle.html?id=${noticia.id}" class="btn-link fa-angle-right"></a>
                  </div>
                </div>
              </div>
            `;
            cameraWrap.appendChild(noticiaDiv);
          });

          // Reiniciar Camera.js después de actualizar el contenido
          if (window.jQuery && jQuery().camera) {
            jQuery('#camera').camera({
              height: '400px',
              loader: 'bar',
              pagination: true,
              thumbnails: false,
              hover: false,
              playPause: false,
              navigation: true,
            });
          } else {
            console.error('Camera.js no está cargado o jQuery no está disponible.');
          }
        } else {
          console.error('Elemento con id "camera" no encontrado.');
        }
      })
      .catch(error => console.error('Error al obtener noticias:', error));
  }
}
