package uniandes.edu.co.demo.service;

import uniandes.edu.co.demo.model.ServicioDeSalud;
import uniandes.edu.co.demo.repository.ServicioDeSaludRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDeSaludService {

    private final ServicioDeSaludRepository repository;

    public ServicioDeSaludService(ServicioDeSaludRepository repository) {
        this.repository = repository;
    }

    public ServicioDeSalud create(ServicioDeSalud s) {
        return repository.save(s);
    }

    public List<ServicioDeSalud> list() {
        return repository.findAll();
    }
}
