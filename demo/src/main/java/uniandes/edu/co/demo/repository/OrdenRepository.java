package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.OrdenServicio;

/**
 * CRUD para la colección <code>ordenServicio</code>.
 */
public interface OrdenRepository extends MongoRepository<OrdenServicio, ObjectId> {
}
