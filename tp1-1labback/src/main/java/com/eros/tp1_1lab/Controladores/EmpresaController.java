package com.eros.tp1_1lab.Controladores;

import com.eros.tp1_1lab.Modelos.Empresa;
import com.eros.tp1_1lab.Servicios.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/crear")
    public Empresa crear(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtener(@PathVariable Long id) {
        return empresaService.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public List<Empresa> listar() {
        return empresaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        empresaService.delete(id);
    }
}