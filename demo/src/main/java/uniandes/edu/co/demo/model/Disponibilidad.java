// Disponibilidad.java  (slots de agenda)
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data @NoArgsConstructor
@Document(collection = "disponibilidad")
public class Disponibilidad {

    @Id                 private ObjectId id;
    @NotNull            private ObjectId idServicio;   // ServicioSalud
    @NotNull            private ObjectId idIPS;
                        private ObjectId idMedico;
    @NotNull            private Instant  fechaHora;
                        private String   estado = "disponible"; // disponible|reservada
}
