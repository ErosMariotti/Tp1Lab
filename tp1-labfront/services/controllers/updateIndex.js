document.addEventListener('DOMContentLoaded', function () {
  const apiUrl = 'http://localhost:8080';
  fetch(`${apiUrl}/empresa/listar`)
    .then(response => response.json())
    .then(data => {
      let tabla = document.getElementById('table');
      data.forEach(empresa => {
        let fila = document.createElement('tr');
        fila.innerHTML = `
          <td>${empresa.denominacion}</td>
          <td><a href="home.html?id=${empresa.id}" class="empresa-link" data-id="${empresa.id}">URL PÁGINA HOME</a></td>
        `;
        tabla.appendChild(fila);
      });

      document.querySelectorAll('.empresa-link').forEach(link => {
        link.addEventListener('click', function (event) {
          const empresaId = event.target.getAttribute('data-id');
          localStorage.setItem('empresaId', empresaId);
        });
      });
    })
    .catch(error => console.error('Error al obtener empresas:', error));
});
