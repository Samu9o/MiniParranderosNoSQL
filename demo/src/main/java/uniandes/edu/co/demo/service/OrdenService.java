// src/main/java/uniandes/edu/co/demo/service/OrdenService.java
package uniandes.edu.co.demo.service;

import uniandes.edu.co.demo.model.OrdenServicio;
import uniandes.edu.co.demo.repository.OrdenRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdenService {

    private final OrdenRepository repo;

    public OrdenService(OrdenRepository repo) {
        this.repo = repo;
    }

    public OrdenServicio crear(OrdenServicio o) {
        return repo.save(o);
    }

    public List<OrdenServicio> listar() {
        return repo.findAll();
    }
}
