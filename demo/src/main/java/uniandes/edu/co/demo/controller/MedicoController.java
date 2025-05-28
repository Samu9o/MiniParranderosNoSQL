// MedicoController.java
package uniandes.edu.co.demo.controller;
import uniandes.edu.co.demo.model.Medico;
import uniandes.edu.co.demo.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/medicos") @Validated
public class MedicoController {
  private final MedicoService service;
  public MedicoController(MedicoService s){this.service=s;}

  @PostMapping  public ResponseEntity<Medico> crear(@RequestBody Medico m){
      return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(m)); }
  @GetMapping   public List<Medico> listar(){ return service.listar(); }
}
