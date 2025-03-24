document.addEventListener('DOMContentLoaded', async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const noticiaId = urlParams.get('id');
  if (noticiaId) {
    try {
      const response = await fetch(
        `http://localhost:8080/noticia/${noticiaId}`
      );
      if (!response.ok) {
        throw new Error('Error al obtener los detalles de la noticia');
      }
      const noticia = await response.json();
      tinymce.get('editorHtml').setContent(noticia.contenidoHtml);
    } catch (error) {
      console.error('Error:', error);
    }
  }
});

async function verHTML() {
  const urlParams = new URLSearchParams(window.location.search);
  const noticiaId = urlParams.get('id');
  const content = tinymce.get('editorHtml').getContent();

  console.log('content', content);
  try {
    const body = { contenidoHtml: content };

    const updateResponse = await fetch(
      `http://localhost:8080/noticia/actualizar/${noticiaId}`,
      {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
        body: JSON.stringify(body),
      }
    );

    if (!updateResponse.ok) {
      throw new Error(
        `Error en la petición: ${updateResponse.status} ${updateResponse.statusText}`
      );
    }

    const data = await updateResponse.json();
    console.log('Respuesta del servidor:', data);

    alert('Noticia actualizada correctamente');
    window.location.href = `http://localhost:8080/noticia/${noticiaId}`;
  } catch (error) {
    console.error('Error:', error);
    alert('Error al actualizar la noticia');
  }
}
