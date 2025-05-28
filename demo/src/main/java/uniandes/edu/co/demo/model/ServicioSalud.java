// ServicioSalud.java  (referencia mínima)
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor
@Document(collection = "servicioSalud")
public class ServicioSalud {
    @Id                 private ObjectId id;
    @NotBlank           private String   nombreServicio;
                        private boolean  requiereOrden;   // false para MG/urgencias
}
