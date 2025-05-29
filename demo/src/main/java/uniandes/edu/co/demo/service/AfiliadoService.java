package uniandes.edu.co.demo.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import uniandes.edu.co.demo.model.Afiliado;
import uniandes.edu.co.demo.repository.AfiliadoRepository;
import java.util.List;

@Service
public class AfiliadoService {

    private final AfiliadoRepository repo;
    public AfiliadoService(AfiliadoRepository repo) { this.repo = repo; }

    public Afiliado crear(@Valid Afiliado a) { return repo.save(a); }
    public List<Afiliado> listar()            { return repo.findAll(); }

    public Afiliado create(@Valid Afiliado a) { return crear(a); }
    public List<Afiliado> list()              { return listar(); }
}
