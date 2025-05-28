// AfiliadoController.java
package uniandes.edu.co.demo.controller;
import uniandes.edu.co.demo.model.Afiliado;
import uniandes.edu.co.demo.service.AfiliadoService;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/afiliados") @Validated
public class AfiliadoController {
  private final AfiliadoService service;
  public AfiliadoController(AfiliadoService s){this.service=s;}

  @PostMapping  public ResponseEntity<Afiliado> crear(@RequestBody Afiliado a){
      return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(a)); }
  @GetMapping   public List<Afiliado> listar(){ return service.listar(); }
}

