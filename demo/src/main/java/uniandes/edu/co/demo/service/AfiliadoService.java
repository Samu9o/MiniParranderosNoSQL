// AfiliadoService.java
package uniandes.edu.co.demo.service;
import uniandes.edu.co.demo.model.Afiliado;
import uniandes.edu.co.demo.repository.AfiliadoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AfiliadoService {
    private final AfiliadoRepository repo;
    public AfiliadoService(AfiliadoRepository r){this.repo=r;}
    public Afiliado crear(Afiliado a){ return repo.save(a); }
    public List<Afiliado> listar(){ return repo.findAll(); }
}
