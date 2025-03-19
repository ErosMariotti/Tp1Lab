package com.eros.tp1_1lab.Inicializador;

import com.eros.tp1_1lab.Modelos.Empresa;
import com.eros.tp1_1lab.Modelos.Noticia;
import com.eros.tp1_1lab.Repositorios.EmpresaRepository;
import com.eros.tp1_1lab.Repositorios.NoticiaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private NoticiaRepository noticiaRepository;

    @PostConstruct
    public void init() {
//        List<Long> empresaIds = Arrays.asList(1L, 33L);
//        for (Long empresaId : empresaIds) {
//            Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
//            if (empresa != null) {
//                for (int i = 1; i <= 3; i++) {
//                    Noticia noticia = new Noticia();
//                    noticia.setTitulo("Noticia " + i + " de Empresa " + empresaId);
//                    noticia.setResumen("Resumen de la noticia " + i + " de la empresa " + empresaId);
//                    noticia.setImagen("imagen" + i + ".jpg");
//                    noticia.setContenidoHtml("<p>Contenido HTML de la noticia " + i + " de la empresa " + empresaId + "</p>");
//                    noticia.setPublicada('S');
//                    noticia.setFechaPublicacion(LocalDate.now());
//                    noticia.setEmpresa(empresa);
//                    noticiaRepository.save(noticia);
//                }
//            }
//        }
    }
}