package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Cita;

/**
 * CRUD para la colección <code>cita</code>.
 */
public interface CitaRepository extends MongoRepository<Cita, ObjectId> {
}
