package uniandes.edu.co.demo.service;

import uniandes.edu.co.demo.model.Cita;
import uniandes.edu.co.demo.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }

    public Cita reservar(Cita c) {
        return repository.save(c);
    }

    public List<Cita> list() {
        return repository.findAll();
    }
}
