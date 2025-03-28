# Trabajo Práctico N° 1 - Laboratorio de Computación 4
## Descripción del Proyecto 
Este proyecto implementa un sistema web que permite administrar empresas y noticias, cumpliendo con los requisitos del Trabajo Práctico N° 1 de la materia Laboratorio de Computación 4 . El sistema consta de un backend desarrollado en Spring Boot y un frontend construido con HTML, CSS, JavaScript , y Bootstrap . Además, se utiliza TinyMCE como editor de texto enriquecido para gestionar el contenido HTML de las noticias.

El objetivo principal es proporcionar una interfaz web funcional donde los usuarios puedan:

Administrar empresas (alta, baja, modificación y consulta).
Administrar noticias (alta, baja, modificación y consulta), incluyendo la posibilidad de subir imágenes y editar contenido HTML.
Visualizar datos dinámicamente en páginas específicas (index.html, home.html, detalle.html, buscador.html).

## <picture><img src = "https://github.com/7oSkaaa/7oSkaaa/blob/main/Images/about_me.gif?raw=true" width = 30px></picture> Equipo de Desarrollo: 
<pre>Jennifer Contreras
Eros Mariotti
Lautaro Gonzalez
Pablo Osorio 
Matias Araya 
Matias Rezinovsky</pre>
<hr>

## Tecnologías Utilizadas
[![Backend](https://img.shields.io/badge/Backend-Spring_Boot-blue)](https://spring.io/projects/spring-boot) <h2>Backend</h2>
- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3.x
- **Base de Datos:** H2 (puede configurarse para otras bases de datos SQL)
- **ORM:** JPA/Hibernate
- **API REST:** Controladores REST para interactuar con el frontend.
<hr>

[![Frontend](https://img.shields.io/badge/Frontend-HTML%20%7C%20CSS%20%7C%20JavaScript-orange)](https://developer.mozilla.org/) <h2>Frontend</h2>
- **HTML5, CSS3, JavaScript (ES6+):** Estructura y estilos de las páginas.
- **Bootstrap:** Diseño responsivo y componentes visuales.
- **Google Maps API:** Visualización dinámica de ubicaciones en la página home.html.
- **TinyMCE:** Editor de texto enriquecido para el campo Contenido HTML de las noticias.
<hr>

[![Database](https://img.shields.io/badge/Database-H2%20%7C%20SQL-green)](https://www.h2database.com/html/main.html)
 <h2>Database</h2>
Se configura H2 como base de datos
<hr>
<h2>Herramientas</h2>

- **Node.js y npm:** Herramientas para la gestión de dependencias y la ejecución de scripts en el frontend.
- **Gradle:** Herramienta para la gestión de dependencias y la construcción del proyecto backend.
- **Git:** Sistema de control de versiones utilizado para el desarrollo y mantenimiento del proyecto.

## **Funcionalidades Principales**

1. **Página `index.html`**
   - Muestra un listado de todas las empresas cargadas en la base de datos.
   - Cada empresa tiene un vínculo hacia `home.html`, pasando su `id` como parámetro.

2. **Página `home.html`**
   - Recupera los datos de la empresa seleccionada y los muestra en:
     - El encabezado.
     - La sección "Quienes Somos".
     - El mapa.
     - El pie de página.
   - Muestra un slider con las últimas 5 noticias publicadas, ordenadas por fecha descendente.

3. **Página `detalle.html`**
   - Muestra todos los datos de la noticia seleccionada, incluyendo el contenido HTML editado con TinyMCE.

4. **Página `buscador.html`**
   - Lista las últimas 20 noticias filtradas por texto ingresado.
   - Las noticias se ordenan por fecha de publicación descendente.
