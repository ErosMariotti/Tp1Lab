document.addEventListener('DOMContentLoaded', function () {
  const apiUrl = 'http://localhost:8080';
  const urlParams = new URLSearchParams(window.location.search);
  const empresaId = urlParams.get('id');

  if (empresaId) {
    fetch(`${apiUrl}/noticia/listar/${empresaId}`)
      .then(response => response.json())
      .then(noticias => {
        const cameraWrap = document.getElementById('camera');
        if (cameraWrap) {
          console.log('cameWrap', cameraWrap);

          //   cameraWrap.innerHTML = ''; // Limpiar contenido existente

        //   noticias.forEach((noticia, index) => {
        //     const noticiaDiv = document.createElement('div');
        //     noticiaDiv.setAttribute(
        //       'data-src',
        //       `https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbpoB7V1XwH3TWJB_-8ze689ZU_v2Hxp0V5w&s`
        //     );
        //     noticiaDiv.innerHTML = `
        //       <div class="camera_caption fadeIn">
        //         <div class="jumbotron jumbotron${index + 1}">
        //           <em>
        //             <a href="detalle.html?id=${noticia.id}">${
        //       noticia.titulo
        //     }</a>
        //           </em>
        //           <div class="wrap">
        //             <p>${noticia.resumen}</p>
        //             <a href="detalle.html?id=${
        //               noticia.id
        //             }" class="btn-link fa-angle-right"></a>
        //           </div>
        //         </div>
        //       </div>
        //     `;
        //     cameraWrap.appendChild(noticiaDiv);
        //     console.log('noticiaDiv', noticiaDiv);
        //   });

          noticias.forEach((noticia, index) => {
            const jumbotron = document.querySelector(`.jumbotron${index + 1}`);
            if (jumbotron) {
              jumbotron.querySelector(
                'a'
              ).href = `detalle.html?id=${noticia.id}`;
              jumbotron.querySelector('a').innerText = noticia.titulo;
              jumbotron.querySelector('.wrap p').innerText = noticia.resumen;
              jumbotron.querySelector(
                '.wrap a'
              ).href = `detalle.html?id=${noticia.id}`;
              jumbotron.parentElement.parentElement.setAttribute(
                'data-src',
                `images/${noticia.imagen}`
              );
            }
          });
        } else {
          console.error('Elemento con id "camera" no encontrado.');
        }
      })
      .catch(error => console.error('Error al obtener noticias:', error));
  }
});
