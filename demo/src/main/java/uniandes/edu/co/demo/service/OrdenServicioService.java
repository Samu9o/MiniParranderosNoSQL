package uniandes.edu.co.demo.service;

import uniandes.edu.co.demo.model.OrdenDeServicio;
import uniandes.edu.co.demo.repository.OrdenDeServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServicioService {

    private final OrdenDeServicioRepository repository;

    public OrdenServicioService(OrdenDeServicioRepository repository) {
        this.repository = repository;
    }

    public OrdenDeServicio crearOrden(OrdenDeServicio orden) {
        return repository.save(orden);
    }

    public List<OrdenDeServicio> list() {
        return repository.findAll();
    }
}
