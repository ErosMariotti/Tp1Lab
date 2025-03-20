package com.eros.tp1_1lab.Servicios;

import com.eros.tp1_1lab.Repositorios.NoticiaRepository;
import com.eros.tp1_1lab.Modelos.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia save(Noticia noticia) { return noticiaRepository.save(noticia); }
    public Optional<Noticia> findById(Long id) { return noticiaRepository.findById(id); }
    public List<Noticia> findAll() { return noticiaRepository.findAll(); }
    public void delete(Long id) { noticiaRepository.deleteById(id); }

    public List<Noticia> findByEmpresaId(Long empresaId) {
        return noticiaRepository.findByEmpresaId(empresaId);
    }

    public Noticia update(Long id, Noticia noticiaActualizada) {
        return noticiaRepository.findById(id).map(noticia -> {
            if (noticiaActualizada.getTitulo() != null) {
                noticia.setTitulo(noticiaActualizada.getTitulo());
            }
            if (noticiaActualizada.getResumen() != null) {
                noticia.setResumen(noticiaActualizada.getResumen());
            }
            if (noticiaActualizada.getImagen() != null) {
                noticia.setImagen(noticiaActualizada.getImagen());
            }
            if (noticiaActualizada.getContenidoHtml() != null) {
                noticia.setContenidoHtml(noticiaActualizada.getContenidoHtml());
            }
            if (noticiaActualizada.getPublicada() != '\0') {
                noticia.setPublicada(noticiaActualizada.getPublicada());
            }
            if (noticiaActualizada.getFechaPublicacion() != null) {
                noticia.setFechaPublicacion(noticiaActualizada.getFechaPublicacion());
            }
            if (noticiaActualizada.getEmpresa() != null) {
                noticia.setEmpresa(noticiaActualizada.getEmpresa());
            }
            return noticiaRepository.save(noticia);
        }).orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
    }
}