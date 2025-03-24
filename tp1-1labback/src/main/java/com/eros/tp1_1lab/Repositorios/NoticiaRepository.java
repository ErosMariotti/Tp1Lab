package com.eros.tp1_1lab.Repositorios;

import com.eros.tp1_1lab.Modelos.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    List<Noticia> findByEmpresaId(Long empresaId);
    Page<Noticia> findByEmpresaIdAndTituloContainingOrEmpresaIdAndResumenContainingOrderByFechaPublicacionDesc(
            Long empresaId1, String titulo, Long empresaId2, String resumen, Pageable pageable);
}