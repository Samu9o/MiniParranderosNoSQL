package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Medico;

/**
 * CRUD para la colección <code>medico</code>.
 */
public interface MedicoRepository extends MongoRepository<Medico, ObjectId> {
    /*  Métodos derivados de MongoRepository son suficientes:
        - findAll()
        - findById(...)
        - save(...)
        - deleteById(...)
    */
}
