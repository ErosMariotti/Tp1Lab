package Servicios;

import Repositorios.NoticiaRepository;
import com.eros.tp1_1lab.Noticia;
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
}