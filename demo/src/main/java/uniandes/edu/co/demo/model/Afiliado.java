// Afiliado.java
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data @NoArgsConstructor
@Document(collection = "afiliado")
public class Afiliado {

    @Id                 private ObjectId id;
    @NotBlank           private String   tipoDocumento;
    @NotBlank           private String   numeroDocumento;
    @NotBlank           private String   nombre;
    @NotNull            private LocalDate fechaNacimiento;
                        private String   direccion;
                        private String   telefono;

    /** Cotizante = true, Beneficiario = false */
                        private boolean  cotizante;
                        private ObjectId idContribuyente;     // si beneficiario
                        private String   parentesco;
}
