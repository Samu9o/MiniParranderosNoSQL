// StatsService.java
package uniandes.edu.co.demo.service;

import org.bson.Document;
import org.springframework.stereotype.Service;
import uniandes.edu.co.demo.dto.*;
import uniandes.edu.co.demo.repository.StatsRepositoryCustom;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsService {
    private final StatsRepositoryCustom repo;
    public StatsService(StatsRepositoryCustom repo) {
        this.repo = repo;
    }

    public List<DisponibilidadStats> getDisponibilidadPorCodigo(String codigo) {
        return repo.disponibilidadPorCodigo(codigo).stream()
            .map(doc -> new DisponibilidadStats(
                doc.getString("servicioNombre"),
                doc.get("fechaHora", java.time.LocalDateTime.class),
                doc.getString("ipsNombre"),
                doc.getString("medicoNombre")))
            .collect(Collectors.toList());
    }

    public List<ServicioSolicitadoStats> getTopServicios(String desde, String hasta) {
        return repo.topServiciosMásSolicitados(desde, hasta).stream()
            .map(doc -> new ServicioSolicitadoStats(
                doc.getObjectId("servicioId").toHexString(),
                doc.getString("servicioNombre"),
                doc.getLong("total")))
            .collect(Collectors.toList());
    }
}
