package uniandes.edu.co.demo.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import uniandes.edu.co.demo.model.Medico;
import uniandes.edu.co.demo.repository.MedicoRepository;
import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repo;

    public MedicoService(MedicoRepository repo) { this.repo = repo; }

    /* ----- API en español ----- */
    public Medico crear(@Valid Medico m) { return repo.save(m); }
    public List<Medico> listar()        { return repo.findAll(); }

    /* ----- Alias en inglés (lo que usan tus controladores) ----- */
    public Medico create(@Valid Medico m) { return crear(m); }
    public List<Medico> list()            { return listar(); }
}
