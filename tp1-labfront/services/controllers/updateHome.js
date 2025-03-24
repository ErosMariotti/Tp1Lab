document.addEventListener('DOMContentLoaded', function () {
  const apiUrl = 'http://localhost:8080';
  const empresaId = localStorage.getItem('empresaId');
  if (!empresaId) {
    throw new Error('No se encontró el ID de la empresa en localStorage');
  }

  if (empresaId) {
    fetch(`${apiUrl}/empresa/${empresaId}`)
      .then(response => response.json())
      .then(data => {
        console.log('data', data)
        // document.getElementById("empresa-nombre").textContent = data.nombre;
        // document.getElementById("empresa-telefono").textContent = data.telefono;
        // document.getElementById("empresa-descripcion").textContent = data.descripcion;
        // document.getElementById("empresa-mapa").src = data.mapa;
        // document.getElementById("empresa-footer").textContent = © ${new Date().getFullYear()} ${data.nombre};
        document.querySelector('.navbar-brand small').innerText =
          data.denominacion;
        const telefonoLink = document.querySelector('.help-box a');
        telefonoLink.innerText = data.telefono;
        telefonoLink.href = `callto:${data.telefono}`;
        document.querySelector(
          '.help-box small'
        ).innerHTML = `<span>Horario:</span> ${data.horarioAtencion}`;
        document.querySelector('h2.txt-pr').innerText = 'Quiénes Somos';
        document.querySelector('.well2 .col p').innerText = data.quienesSomos;
        document.querySelector(
          '.map iframe'
        ).src = `https://www.google.com/maps?q=${data.latitud},${data.longitud}&hl=es;z=14&output=embed`;
        document.querySelector(
          '.rights'
        ).innerHTML = `${data.denominacion} &#169; <span id="copyright-year"></span> <a href="index-5.html">Privacy Policy</a>`;
      })
      .catch(error => console.error('Error al obtener la empresa:', error));
  }
});
