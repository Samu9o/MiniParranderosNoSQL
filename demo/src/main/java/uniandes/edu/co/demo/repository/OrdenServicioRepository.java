package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.model.OrdenServicio;

public interface OrdenServicioRepository
        extends MongoRepository<OrdenServicio, ObjectId> { }
