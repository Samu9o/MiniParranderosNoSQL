// OrdenServicio.java
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data @NoArgsConstructor
@Document(collection = "ordenServicio")
public class OrdenServicio {

    @Id                 private ObjectId id;
    @NotNull            private Instant  fechaEmision = Instant.now();
    @NotNull            private ObjectId idMedico;
    @NotNull            private ObjectId idAfiliado;
    @NotNull            private List<ObjectId> idServicios;   // uno o más
                        private String  estado = "vigente";    // vigente|usada|vencida
}
