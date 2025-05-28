// AgendaService.java   (consultar + reservar)
package uniandes.edu.co.demo.service;

import uniandes.edu.co.demo.model.*;
import uniandes.edu.co.demo.repository.*;
import jakarta.validation.ValidationException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AgendaService {

    private final DisponibilidadRepository dispRepo;
    private final ServicioSaludRepository  servRepo;
    private final CitaRepository           citaRepo;
    private final OrdenRepository          ordenRepo;

    public AgendaService(DisponibilidadRepository d,
                         ServicioSaludRepository  s,
                         CitaRepository           c,
                         OrdenRepository          o){
        this.dispRepo = d; this.servRepo = s; this.citaRepo = c; this.ordenRepo=o;
    }

    /** RF7-1 : agenda para las próximas 4 semanas */
    public List<Disponibilidad> agenda4Semanas(ObjectId servicioId){
        Instant ahora = Instant.now();
        Instant fin   = ahora.plus(28, ChronoUnit.DAYS);
        return dispRepo.findAll().stream()
               .filter(d -> d.getIdServicio().equals(servicioId)
                         && !d.getFechaHora().isBefore(ahora)
                         && !d.getFechaHora().isAfter(fin))
               .toList();
    }

    /** RF7-2 : reservar cita usando una orden */
    public Cita reservar(ObjectId disponibilidadId,
                         ObjectId afiliadoId,
                         ObjectId ordenId){

        Disponibilidad disp = dispRepo.findById(disponibilidadId)
                         .orElseThrow(() -> new ValidationException("Slot no existe"));
        if(!disp.getEstado().equals("disponible"))
            throw new ValidationException("Slot no disponible");

        ServicioSalud srv = servRepo.findById(disp.getIdServicio())
                         .orElseThrow();

        // Si el servicio requiere orden verifica que la orden sea válida
        if(srv.isRequiereOrden()){
            OrdenServicio ord = ordenRepo.findById(ordenId)
                               .orElseThrow(() -> new ValidationException("Orden no existe"));
            if(!ord.getIdAfiliado().equals(afiliadoId))
                throw new ValidationException("Orden pertenece a otro afiliado");
        }

        disp.setEstado("reservada");
        dispRepo.save(disp);

        Cita c = new Cita();
        c.setIdAfiliado(afiliadoId);
        c.setIdDisponibilidad(disponibilidadId);
        c.setIdOrden(ordenId);
        return citaRepo.save(c);
    }
}
