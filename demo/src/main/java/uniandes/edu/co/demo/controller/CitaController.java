package uniandes.edu.co.demo.controller;

import uniandes.edu.co.demo.model.Cita;
import uniandes.edu.co.demo.service.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/citas")
@Validated
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cita> reservar(@Valid @RequestBody Cita c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.reservar(c));
    }

    @GetMapping
    public List<Cita> list() {
        return service.list();
    }
}
