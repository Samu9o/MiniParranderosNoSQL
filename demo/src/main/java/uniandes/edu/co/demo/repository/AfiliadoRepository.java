package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Afiliado;

/**
 * CRUD para la colección <code>afiliado</code>.
 */
public interface AfiliadoRepository extends MongoRepository<Afiliado, ObjectId> {
}
