package uniandes.edu.co.demo.repository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EstadisticasRepository {

  private final MongoTemplate mongo;

  public EstadisticasRepository(MongoTemplate mongo) { this.mongo = mongo; }

  /** RFC1 – agenda próximas 4 semanas */
  public List<Document> agendaServicio(String idServicio) {

    Instant ahora   = Instant.now();
    Instant limite  = ahora.plus(28, ChronoUnit.DAYS);

    List<Document> pipeline = List.of(
    
      new Document("$match", new Document()
        .append("fechaHora", new Document("$gte", ahora).append("$lte", limite))
      ),
      /* join con prestacionServicio para filtrar por idServicio */
      new Document("$lookup", new Document()
        .append("from","prestacionServicio")
        .append("localField","idPrestacion")
        .append("foreignField","idPrestacion")
        .append("as","prest")
      ),
      new Document("$unwind","$prest"),
      new Document("$match", new Document("prest.idServicio", idServicio)),
      /* join con IPS y Médico para campos descriptivos */
      new Document("$lookup", new Document()
        .append("from","IPS")
        .append("localField","prest.idIPS")
        .append("foreignField","idIPS")
        .append("as","ips")
      ),
      new Document("$lookup", new Document()
        .append("from","medico")
        .append("localField","prest.idMédico")
        .append("foreignField","idMedico")
        .append("as","medico")
      ),
      new Document("$project", new Document()
        .append("_id",0)
        .append("fechaHora",1)
        .append("estado",1)
        .append("IPS", new Document("$arrayElemAt", List.of("$ips.nombre",0)))
        .append("medico", new Document("$arrayElemAt", List.of("$medico.nombre",0)))
      ),
      new Document("$sort", new Document("fechaHora",1))
    );
    return mongo.getCollection("disponibilidad").aggregate(pipeline).into(new java.util.ArrayList<>());
  }

  /** RFC2 – Top-20 servicios más solicitados en un periodo */
  public List<Document> topServicios(Instant desde, Instant hasta) {

    List<Document> pipeline = List.of(
      new Document("$match", new Document()
        .append("fechaReserva", new Document("$gte", desde).append("$lte", hasta))
      ),
      new Document("$group", new Document()
        .append("_id","$idDisponibilidad")
        .append("total", new Document("$sum",1))
      ),
      /* convertir idDisponibilidad -> idServicio */
      new Document("$lookup", new Document()
        .append("from","disponibilidad")
        .append("localField","_id")
        .append("foreignField","idDisponibilidad")
        .append("as","disp")
      ),
      new Document("$unwind","$disp"),
      new Document("$lookup", new Document()
        .append("from","prestacionServicio")
        .append("localField","disp.idPrestacion")
        .append("foreignField","idPrestacion")
        .append("as","prest")
      ),
      new Document("$unwind","$prest"),
      new Document("$group", new Document()
        .append("_id","$prest.idServicio")
        .append("total", new Document("$sum","$total"))
      ),
      new Document("$sort", new Document("total",-1)),
      new Document("$limit",20),
      /* join final para nombre del servicio */
      new Document("$lookup", new Document()
        .append("from","servicioSalud")
        .append("localField","_id")
        .append("foreignField","idServicio")
        .append("as","srv")
      ),
      new Document("$project", new Document()
        .append("_id",0)
        .append("idServicio","$_id")
        .append("nombreServicio", new Document("$arrayElemAt",List.of("$srv.nombreServicio",0)))
        .append("total",1)
      )
    );
    return mongo.getCollection("cita").aggregate(pipeline).into(new java.util.ArrayList<>());
  }
}
 