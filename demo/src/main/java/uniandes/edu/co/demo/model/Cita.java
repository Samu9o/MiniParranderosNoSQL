// Cita.java
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data @NoArgsConstructor
@Document(collection = "cita")
public class Cita {

    @Id                 private ObjectId id;
    @NotNull            private ObjectId idAfiliado;
    @NotNull            private ObjectId idDisponibilidad;
    @NotNull            private ObjectId idOrden;      // orden usada
                        private Instant  fechaReserva = Instant.now();
                        private String   estado = "agendada";
}
