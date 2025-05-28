package uniandes.edu.co.demo.repository;

import uniandes.edu.co.demo.model.OrdenDeServicio;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdenDeServicioRepository extends MongoRepository<OrdenDeServicio, ObjectId> {
}
