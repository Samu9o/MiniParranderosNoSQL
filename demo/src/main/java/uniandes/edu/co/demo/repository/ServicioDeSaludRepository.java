package uniandes.edu.co.demo.repository;

import uniandes.edu.co.demo.model.ServicioDeSalud;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ServicioDeSaludRepository extends MongoRepository<ServicioDeSalud, ObjectId> {
    Optional<ServicioDeSalud> findByCodigo(String codigo);
}
