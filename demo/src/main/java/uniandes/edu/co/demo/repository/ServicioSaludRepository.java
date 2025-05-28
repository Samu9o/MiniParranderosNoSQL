package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.ServicioSalud;

/**
 * CRUD para la colección <code>servicioSalud</code>.
 */
public interface ServicioSaludRepository extends MongoRepository<ServicioSalud, ObjectId> {
}
