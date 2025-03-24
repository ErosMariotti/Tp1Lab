
document.addEventListener('DOMContentLoaded', function () {
    const empresaId = localStorage.getItem('empresaId');
    if (empresaId) {
      updateHeaderFooter(empresaId);
    }
  });
  
  export function updateHeaderFooter(empresaId) {
    const apiUrl = 'http://localhost:8080';
    if (empresaId) {
      fetch(`${apiUrl}/empresa/${empresaId}`)
        .then(response => response.json())
        .then(data => {
          console.log('data', data);
          document.querySelector('.navbar-brand small').innerText =
            data.denominacion;
          const telefonoLink = document.querySelector('.help-box a');
          telefonoLink.innerText = data.telefono;
          telefonoLink.href = `callto:${data.telefono}`;
          document.querySelector(
            '.help-box small'
          ).innerHTML = `<span>Horario:</span> ${data.horarioAtencion}`;
          document.querySelector(
            '.rights'
          ).innerHTML = `${data.denominacion} &#169; <span id="copyright-year"></span> <a href="index-5.html">Privacy Policy</a>`;
        })
        .catch(error => console.error('Error al obtener la empresa:', error));
    }
  }
  