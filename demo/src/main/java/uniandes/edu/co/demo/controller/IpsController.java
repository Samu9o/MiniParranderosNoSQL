package uniandes.edu.co.demo.controller;

import uniandes.edu.co.demo.model.Ips;
import uniandes.edu.co.demo.service.IpsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ips")
@Validated
public class IpsController {

    private final IpsService service;

    public IpsController(IpsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ips> create(@Valid @RequestBody Ips ips) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(ips));
    }

    @GetMapping
    public List<Ips> list() {
        return service.list();
    }
}
