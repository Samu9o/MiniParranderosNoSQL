// OrdenController.java
package uniandes.edu.co.demo.controller;
import uniandes.edu.co.demo.model.OrdenServicio;
import uniandes.edu.co.demo.service.OrdenService;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/ordenes") @Validated
public class OrdenController {
  private final OrdenService service;
  public OrdenController(OrdenService s){this.service=s;}

  @PostMapping  public ResponseEntity<OrdenServicio> crear(@RequestBody OrdenServicio o){
      return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(o)); }
  @GetMapping   public List<OrdenServicio> listar(){ return service.listar(); }
}
