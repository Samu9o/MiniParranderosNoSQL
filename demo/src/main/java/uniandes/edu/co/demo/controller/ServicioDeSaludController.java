package uniandes.edu.co.demo.controller;

import uniandes.edu.co.demo.model.ServicioDeSalud;
import uniandes.edu.co.demo.service.ServicioDeSaludService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/servicios")
@Validated
public class ServicioDeSaludController {

    private final ServicioDeSaludService service;

    public ServicioDeSaludController(ServicioDeSaludService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServicioDeSalud> create(@Valid @RequestBody ServicioDeSalud s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(s));
    }

    @GetMapping
    public List<ServicioDeSalud> list() {
        return service.list();
    }
}
