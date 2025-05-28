// AgendaController.java   (RF7)
package uniandes.edu.co.demo.controller;
import uniandes.edu.co.demo.model.Disponibilidad;
import uniandes.edu.co.demo.model.Cita;
import uniandes.edu.co.demo.service.AgendaService;
import org.bson.types.ObjectId;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/agenda")
public class AgendaController {

  private final AgendaService service;
  public AgendaController(AgendaService s){this.service=s;}

  /** RF7-1 consultar agenda */
  @GetMapping("/disponibilidad")
  public List<Disponibilidad> agenda(@RequestParam String servicioId){
      return service.agenda4Semanas(new ObjectId(servicioId));
  }

  /** RF7-2 agendar */
  @PostMapping("/reservar")
  public ResponseEntity<Cita> reservar(
          @RequestParam String disponibilidadId,
          @RequestParam String afiliadoId,
          @RequestParam String ordenId){

      Cita c = service.reservar(new ObjectId(disponibilidadId),
                                new ObjectId(afiliadoId),
                                new ObjectId(ordenId));
      return ResponseEntity.status(HttpStatus.CREATED).body(c);
  }
}
