// src/main/java/uniandes/edu/co/demo/service/AgendaService.java
package uniandes.edu.co.demo.service;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import uniandes.edu.co.demo.model.Disponibilidad;
import uniandes.edu.co.demo.repository.DisponibilidadRepository;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaService {

    private final DisponibilidadRepository repo;

    public AgendaService(DisponibilidadRepository repo) {
        this.repo = repo;
    }

    /**
     * RF7.1: Consultar disponibilidad en las próximas 4 semanas.
     */
    public List<Disponibilidad> consultarDisponibilidad(ObjectId servicioId) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime cuatroSemanas = ahora.plusWeeks(4);
        return repo.findByServicioIdAndFechaHoraBetweenAndDisponibleTrue(
                servicioId, ahora, cuatroSemanas);
    }

    /**
     * RF7.2: Reservar una disponibilidad existente.
     */
    public Disponibilidad reservar(ObjectId disponibilidadId) {
        Disponibilidad d = repo.findById(disponibilidadId)
            .orElseThrow(() -> new IllegalArgumentException("Disponibilidad no encontrada: " + disponibilidadId));
        if (!d.isDisponible()) {
            throw new IllegalStateException("Ya está reservada: " + disponibilidadId);
        }
        d.setDisponible(false);
        return repo.save(d);
    }

    /**
     * POST disponibilidad: crea un nuevo turno de disponibilidad.
     * Devuelve el objeto con el id generado.
     */
    public Disponibilidad crearDisponibilidad(@Valid Disponibilidad d) {
        // forzar disponible=true si no se envió
        d.setDisponible(true);
        return repo.save(d);
    }
}
