// StatsController.java
package uniandes.edu.co.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.dto.*;
import uniandes.edu.co.demo.service.StatsService;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final StatsService service;
    public StatsController(StatsService service) {
        this.service = service;
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<List<DisponibilidadStats>> disponibilidadPorCodigo(
            @RequestParam("codigo") String codigo) {
        return ResponseEntity.ok(service.getDisponibilidadPorCodigo(codigo));
    }

    @GetMapping("/servicios-mas-solicitados")
    public ResponseEntity<List<ServicioSolicitadoStats>> topServicios(
            @RequestParam("desde") String desde,
            @RequestParam("hasta") String hasta) {
        return ResponseEntity.ok(service.getTopServicios(desde, hasta));
    }
}
