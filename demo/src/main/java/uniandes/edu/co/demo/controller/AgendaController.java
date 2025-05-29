// src/main/java/uniandes/edu/co/demo/controller/AgendaController.java
package uniandes.edu.co.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.model.Disponibilidad;
import uniandes.edu.co.demo.service.AgendaService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/agenda")
@Validated
public class AgendaController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    /** 
     * RF7.1: Consultar la agenda de disponibilidad para un servicio 
     * en las próximas 4 semanas.
     */
    @GetMapping("/disponibilidad")
    public ResponseEntity<List<Disponibilidad>> disponibilidad(
            @RequestParam("servicioId") String servicioId) {

        ObjectId sId = new ObjectId(servicioId);
        List<Disponibilidad> lista = service.consultarDisponibilidad(sId);
        return ResponseEntity.ok(lista);
    }

    /**
     * POST /agenda/disponibilidad
     * Crea un nuevo turno de disponibilidad y devuelve el ID generado.
     */
    @PostMapping("/disponibilidad")
    public ResponseEntity<Disponibilidad> crearDisponibilidad(
            @Valid @RequestBody Disponibilidad disp) {

        Disponibilidad creado = service.crearDisponibilidad(disp);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    /**
     * RF7.2: Reservar una cita (marcar disponibilidad=false).
     */
    @PostMapping("/reservar")
    public ResponseEntity<Disponibilidad> reservar(
            @RequestParam("disponibilidadId") String disponibilidadId) {

        ObjectId dId = new ObjectId(disponibilidadId);
        Disponibilidad reservado = service.reservar(dId);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservado);
    }
}
