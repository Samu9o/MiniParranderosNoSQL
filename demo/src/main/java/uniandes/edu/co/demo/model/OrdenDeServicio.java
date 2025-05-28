package uniandes.edu.co.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "ordenes_servicio")
public class OrdenDeServicio {

    @Id
    private ObjectId id;

    @NotNull
    private LocalDateTime fechaEmision;

    private boolean completada = false;

    @NotNull
    private ObjectId idMedico;

    @NotNull
    private ObjectId idAfiliado;

    /**
     * Lista de servicios de salud prescritos
     */
    private List<ObjectId> idServiciosSalud;
}
