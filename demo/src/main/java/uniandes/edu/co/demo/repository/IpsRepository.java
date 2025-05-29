// src/main/java/uniandes/edu/co/demo/repository/IpsRepository.java
package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.Ips;

import java.util.Optional;

public interface IpsRepository extends MongoRepository<Ips, ObjectId> {
    boolean existsByNit(String nit);
    Optional<Ips> findByNit(String nit);
}
