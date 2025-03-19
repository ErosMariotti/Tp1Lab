package com.eros.tp1_1lab.Repositorios;

import com.eros.tp1_1lab.Modelos.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    List<Noticia> findByEmpresaId(Long empresaId);
}

