// Medico.java
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data @NoArgsConstructor
@Document(collection = "medico")
public class Medico {

    @Id                 private ObjectId id;
    @NotBlank           private String   tipoDocumento;
    @NotBlank           private String   numeroDocumento;
    @NotBlank           private String   nombre;
                        private Especialidad especialidad;
                        private List<ObjectId> ips;        // múltiples IPS
                        private List<ObjectId> servicios;  // múltiples servicios
}
