// MedicoService.java
package uniandes.edu.co.demo.service;
import uniandes.edu.co.demo.model.Medico;
import uniandes.edu.co.demo.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MedicoService {
    private final MedicoRepository repo;
    public MedicoService(MedicoRepository r){this.repo=r;}
    public Medico crear(Medico m){ return repo.save(m); }
    public List<Medico> listar(){ return repo.findAll(); }
}
