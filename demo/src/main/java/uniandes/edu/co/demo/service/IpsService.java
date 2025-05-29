// src/main/java/uniandes/edu/co/demo/service/IpsService.java
package uniandes.edu.co.demo.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import uniandes.edu.co.demo.model.Ips;
import uniandes.edu.co.demo.repository.IpsRepository;

import java.util.List;

@Service
public class IpsService {
    private final IpsRepository repo;
    public IpsService(IpsRepository repo) { this.repo = repo; }

    public Ips create(@Valid Ips ips) {
        if (repo.existsByNit(ips.getNit()))
            throw new IllegalArgumentException("IPS con NIT ya existe");
        return repo.save(ips);
    }
    public List<Ips> list() { return repo.findAll(); }
}
