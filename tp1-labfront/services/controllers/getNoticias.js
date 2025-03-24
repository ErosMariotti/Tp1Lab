export async function getNoticias(buscarTexto) {
  const empresaId = localStorage.getItem('empresaId');
  if (!empresaId) {
    throw new Error('No se encontró el ID de la empresa en localStorage');
  }

  const response = await fetch(
    `http://localhost:8080/noticia/buscarPorEmpresa?empresaId=${empresaId}&texto=${buscarTexto}`
  );
  if (!response.ok) {
    throw new Error('Error fetching noticias');
  }
  return response.json();
}

export function displayNoticias(data, buscarTexto) {
  const container = document.querySelector('.well4 .container');
  const h2 = container.querySelector('h2');
  h2.textContent = `Resultados para: "${buscarTexto}"`;

  const rows = container.querySelector('.row.offs2');
  rows.innerHTML = '';

  if (data.content.length === 0) {
    const noResultsMessage = document.createElement('p');
    noResultsMessage.textContent =
      'No se encontraron resultados para su búsqueda.';
    rows.appendChild(noResultsMessage);
    return;
  }

  data.content.forEach(noticia => {
    const table = document.createElement('table');
    table.width = '90%';
    table.align = 'center';
    table.innerHTML = `
      <tbody>
        <tr>
          <td>
            <a href="detalle.html?id=${noticia.id}">
              <img width="250px" class="imgNoticia" src="${noticia.imagen}" alt="">
            </a>
          </td>
          <td width="25"></td>
          <td style="text-align:justify;" valign="top">
            <a style="text-align:justify; font-size:20px" href="detalle.html?id=${noticia.id}" class="banner">
              ${noticia.titulo}
            </a>
            <div class="verOcultar">
              ${noticia.resumen}<a href="detalle.html?id=${noticia.id}" style="color:blue"> Leer Mas - ${noticia.fechaPublicacion}</a>
            </div>
          </td>
        </tr>
      </tbody>
    `;
    rows.appendChild(table);
    rows.appendChild(document.createElement('hr'));
  });
}

export async function fetchAndDisplayNoticias(buscarTexto) {
  try {
    const data = await getNoticias(buscarTexto);
    displayNoticias(data, buscarTexto);
  } catch (error) {
    console.error('Error fetching noticias:', error);
  }
}
