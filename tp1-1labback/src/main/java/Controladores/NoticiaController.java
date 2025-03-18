package Controladores;

import Servicios.NoticiaService;
import com.eros.tp1_1lab.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @PostMapping("/crear")
    public Noticia crear(@RequestBody Noticia noticia) {
        return noticiaService.save(noticia);
    }

    @PostMapping("/subirImagen")
    public ResponseEntity<String> subirImagen(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String ruta = "uploads/" + archivo.getOriginalFilename();
            File destino = new File(ruta);
            archivo.transferTo(destino);
            return ResponseEntity.ok(ruta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al subir la imagen");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> obtener(@PathVariable Long id) {
        return noticiaService.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public List<Noticia> listar() {
        return noticiaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        noticiaService.delete(id);
    }
}