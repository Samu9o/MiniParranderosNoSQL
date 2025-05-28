package uniandes.edu.co.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Document(collection = "servicios_salud")
public class ServicioDeSalud {

    @Id
    private ObjectId id;

    @NotBlank
    private String codigo;

    @NotBlank
    private String nombre;

    private String descripcion;

    /**
     * true si requiere orden; false si puede agendarse directamente
     */
    private boolean requiereOrden;
}
