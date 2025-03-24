// Obtener el ID de la noticia desde la URL
const urlParams = new URLSearchParams(window.location.search);
const noticiaId = urlParams.get('id');

// Función para obtener los detalles de la noticia
async function obtenerDetalleNoticia(id) {
  try {
    const response = await fetch(`http://localhost:8080/noticia/${id}`);
    if (!response.ok) {
      throw new Error('Error al obtener los detalles de la noticia');
    }
    const noticia = await response.json();
    actualizarDetalleNoticia(noticia);
  } catch (error) {
    console.error('Error:', error);
  }
}

// Función para actualizar el contenido de detalle.html
function actualizarDetalleNoticia(noticia) {
  document.querySelector(
    '#imagenPrincipal'
  ).style.backgroundImage = `url('${noticia.imagen}')`;
  document.querySelector('#imagenPrincipal div').textContent = noticia.titulo;
  document.querySelector('h2').textContent = noticia.titulo;
  document.querySelector('body').innerHTML = document
    .querySelector('body')
    .innerHTML.replace(
      'Fecha Publicacion: 12/02/2020',
      `Fecha Publicacion: ${noticia.fechaPublicacion}`
    );
  document.querySelector('dt').textContent = noticia.resumen;
  document.querySelector('dd').innerHTML = noticia.contenidoHtml;
  document.querySelector('#tiny-link').href = `/tiny.html?id=${noticia.id}`;

  // Actualizar el footer con la información de la empresa
  actualizarFooter(noticia.empresa);
}

// Función para actualizar el footer
function actualizarFooter(empresa) {
  document.querySelector('.rights').innerHTML = `
    ${empresa.denominacion} &#169; <span id="copyright-year"></span>
    <a href="index-5.html">Privacy Policy</a>
    <!-- {%FOOTER_LINK} -->
  `;
}

// Llamar a la función para obtener los detalles de la noticia
obtenerDetalleNoticia(noticiaId);
