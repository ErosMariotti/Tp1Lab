package Inicializador;

import Repositorios.EmpresaRepository;
import Repositorios.NoticiaRepository;
import com.eros.tp1_1lab.Empresa;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private NoticiaRepository noticiaRepository;

    @PostConstruct
    public void init() {
        Empresa empresa = new Empresa();
        empresa.setDenominacion("Ejemplo S.A.");
        empresa.setTelefono("123456789");
        empresa.setHorarioAtencion("Lunes a Viernes 9:00 - 18:00");
        empresa.setQuienesSomos("Somos una empresa dedicada a...");
        empresa.setLatitud(-34.6037);
        empresa.setLongitud(-58.3816);
        empresa.setDomicilio("Av. Ejemplo 123");
        empresa.setEmail("contacto@ejemplo.com");
        empresaRepository.save(empresa);
    }
}