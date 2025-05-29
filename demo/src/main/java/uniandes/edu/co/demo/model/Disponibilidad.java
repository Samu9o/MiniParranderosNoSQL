// src/main/java/uniandes/edu/co/demo/model/Disponibilidad.java
package uniandes.edu.co.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "disponibilidades")
public class Disponibilidad {

    @Id
    private ObjectId id;

    /** El servicio de salud al que aplica esta disponibilidad */
    @NotNull(message = "servicioId no puede ser null")
    private ObjectId servicioId;

    /** Fecha y hora en que está disponible (debe ser futura) */
    @NotNull(message = "fechaHora no puede ser null")
    @Future(message = "fechaHora debe ser en el futuro")
    private LocalDateTime fechaHora;

    /** La IPS que ofrece este turno */
    @NotNull(message = "ipsId no puede ser null")
    private ObjectId ipsId;

    /** El médico que estará disponible */
    @NotNull(message = "medicoId no puede ser null")
    private ObjectId medicoId;

    /** true = libre, false = ya reservado */
    private boolean disponible = true;
}
