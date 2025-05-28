package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Ips;

/**
 * CRUD de la colección <code>ips</code> + métodos derivados.
 */
public interface IpsRepository extends MongoRepository<Ips, ObjectId> {

    /** Devuelve <code>true</code> si ya existe un documento con el NIT dado. */
    boolean existsByNit(String nit);
}