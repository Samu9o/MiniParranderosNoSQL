// src/main/java/uniandes/edu/co/demo/repository/DisponibilidadRepository.java
package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Disponibilidad;

import java.time.LocalDateTime;
import java.util.List;

public interface DisponibilidadRepository
        extends MongoRepository<Disponibilidad, ObjectId> {

    /**
     * Encuentra todas las disponibilidades de un servicio entre dos fechas
     * y que estén libres (disponible=true).
     */
    List<Disponibilidad> findByServicioIdAndFechaHoraBetweenAndDisponibleTrue(
            ObjectId servicioId,
            LocalDateTime desde,
            LocalDateTime hasta);
}
