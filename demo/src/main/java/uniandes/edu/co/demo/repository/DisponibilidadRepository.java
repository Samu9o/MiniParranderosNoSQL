package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Disponibilidad;

/**
 * CRUD para la colección <code>disponibilidad</code>.
 */
public interface DisponibilidadRepository extends MongoRepository<Disponibilidad, ObjectId> {
}
