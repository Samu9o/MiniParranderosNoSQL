
package uniandes.edu.co.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "afiliados")
public class Afiliado {
    @Id           private ObjectId id;
    @NotBlank     private String   tipoDocumento;
    @NotBlank     private String   numeroDocumento;
    @NotBlank     private String   nombre;
                 private String   fechaNacimiento;
                 private String   direccion;
                 private String   telefono;
                 private boolean  cotizante;
}
