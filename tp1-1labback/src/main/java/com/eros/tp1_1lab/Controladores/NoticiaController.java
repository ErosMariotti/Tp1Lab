package com.eros.tp1_1lab.Controladores;

import com.eros.tp1_1lab.Modelos.Noticia;
import com.eros.tp1_1lab.Servicios.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/noticia")
@CrossOrigin(origins = "*")
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

    @GetMapping("/listar/{id}")
    public List<Noticia> listarPorEmpresa(@PathVariable Long id) {
        System.out.println("ID recibido en la API: " + id);
        return noticiaService.findByEmpresaId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        noticiaService.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Noticia> actualizar(@PathVariable Long id, @RequestBody Noticia noticiaDetails) {
        try {
            System.out.println("ID recibido en la API: " + id);
            Noticia updatedNoticia = noticiaService.update(id, noticiaDetails);
            return ResponseEntity.ok(updatedNoticia);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/buscar")
//    public ResponseEntity<Page<Noticia>> buscarNoticias(
//            @RequestParam(defaultValue = "") String texto,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "20") int size) {
//        Page<Noticia> noticias = noticiaService.buscarNoticias(texto, page, size);
//        return ResponseEntity.ok(noticias);
//    }

    @GetMapping("/buscarPorEmpresa")
    public ResponseEntity<Page<Noticia>> buscarNoticiasPorEmpresa(
            @RequestParam Long empresaId,
            @RequestParam(defaultValue = "") String texto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Page<Noticia> noticias = noticiaService.buscarNoticiasPorEmpresa(empresaId, texto, page, size);
        return ResponseEntity.ok(noticias);
    }
}