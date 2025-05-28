package uniandes.edu.co.demo.service;

import uniandes.edu.co.demo.model.Ips;
import uniandes.edu.co.demo.repository.IpsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpsService {

    private final IpsRepository repository;

    public IpsService(IpsRepository repository) {
        this.repository = repository;
    }

    public Ips create(Ips ips) {
        if (repository.existsByNit(ips.getNit())) {
            throw new IllegalArgumentException("IPS con NIT ya existe");
        }
        return repository.save(ips);
    }

    public List<Ips> list() {
        return repository.findAll();
    }
}
