package uniandes.edu.co.demo.controller;

import uniandes.edu.co.demo.model.OrdenDeServicio;
import uniandes.edu.co.demo.service.OrdenServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
@Validated
public class OrdenServicioController {

    private final OrdenServicioService service;

    public OrdenServicioController(OrdenServicioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrdenDeServicio> create(@Valid @RequestBody OrdenDeServicio o) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearOrden(o));
    }

    @GetMapping
    public List<OrdenDeServicio> list() {
        return service.list();
    }
}
