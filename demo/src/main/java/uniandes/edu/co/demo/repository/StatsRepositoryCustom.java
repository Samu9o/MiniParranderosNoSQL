// StatsRepositoryCustom.java
package uniandes.edu.co.demo.repository;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StatsRepositoryCustom {
    private final MongoTemplate mongo;
    public StatsRepositoryCustom(MongoTemplate mongo) {
        this.mongo = mongo;
    }

    public List<Document> disponibilidadPorCodigo(String codigo) {
        List<Document> pipeline = List.of(
            new Document("$match", new Document("codigo", codigo)),
            new Document("$lookup", new Document()
                .append("from", "servicios_salud")
                .append("localField", "_id")
                .append("foreignField", "_id")
                .append("as", "srv")),
            new Document("$unwind", "$srv"),
            new Document("$lookup", new Document()
                .append("from", "disponibilidades")
                .append("localField", "srv._id")
                .append("foreignField", "servicioId")
                .append("as", "disp")),
            new Document("$unwind", "$disp"),
            new Document("$match", new Document("disp.disponible", true)
                .append("disp.fechaHora", new Document("$gte", java.time.LocalDateTime.now())
                                         .append("$lte", java.time.LocalDateTime.now().plusWeeks(4)))),
            new Document("$lookup", new Document()
                .append("from", "ips")
                .append("localField", "disp.ipsId")
                .append("foreignField", "_id")
                .append("as", "ips")),
            new Document("$unwind", "$ips"),
            new Document("$lookup", new Document()
                .append("from", "medicos")
                .append("localField", "disp.medicoId")
                .append("foreignField", "_id")
                .append("as", "med")),
            new Document("$unwind", "$med"),
            new Document("$project", new Document()
                .append("servicioNombre", "$srv.nombre")
                .append("fechaHora", "$disp.fechaHora")
                .append("ipsNombre", "$ips.nombre")
                .append("medicoNombre", "$med.nombre"))
        );
        return mongo.getCollection("servicios_salud")
                    .aggregate(pipeline).into(new java.util.ArrayList<>());
    }

    public List<Document> topServiciosMásSolicitados(String desde, String hasta) {
        List<Document> pipeline = List.of(
            new Document("$match", new Document("fechaCreacion",
                new Document("$gte", Document.parse("{ \"$date\": \""+desde+"T00:00:00Z\" }"))
                  .append("$lte", Document.parse("{ \"$date\": \""+hasta+"T23:59:59Z\" }")))),
            new Document("$unwind", "$idServicios"),
            new Document("$group", new Document()
                .append("_id", "$idServicios")
                .append("total", new Document("$sum", 1))),
            new Document("$sort", new Document("total", -1)),
            new Document("$limit", 20),
            new Document("$lookup", new Document()
                .append("from", "servicios_salud")
                .append("localField", "_id")
                .append("foreignField", "_id")
                .append("as", "srv")),
            new Document("$unwind", "$srv"),
            new Document("$project", new Document()
                .append("servicioId", "$_id")
                .append("servicioNombre", "$srv.nombre")
                .append("total", 1))
        );
        return mongo.getCollection("ordenes_servicio")
                    .aggregate(pipeline).into(new java.util.ArrayList<>());
    }
}
