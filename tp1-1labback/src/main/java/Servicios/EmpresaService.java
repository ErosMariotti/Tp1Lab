package Servicios;

import Repositorios.EmpresaRepository;
import com.eros.tp1_1lab.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa) { return empresaRepository.save(empresa); }
    public Optional<Empresa> findById(Long id) { return empresaRepository.findById(id); }
    public List<Empresa> findAll() { return empresaRepository.findAll(); }
    public void delete(Long id) { empresaRepository.deleteById(id); }
}